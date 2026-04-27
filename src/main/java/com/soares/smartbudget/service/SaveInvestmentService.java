package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Investment;
import com.soares.smartbudget.service.gateway.FindInvestmentsGateway;
import com.soares.smartbudget.service.gateway.SaveInvestmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SaveInvestmentService {

    private final SaveInvestmentGateway saveGateway;
    private final FindInvestmentsGateway findGateway;

    @Transactional
    @Async("investmentTaskExecutor")
    public Investment save(Investment investment) {

        // 1. Criação de novo investimento
        if (investment.idInvestment() == null) {
            UUID newPortfolioId = UUID.randomUUID();
            Investment newPosition = new Investment(
                    null,
                    newPortfolioId.toString(),
                    investment.investmentType(),
                    investment.location(),
                    investment.balance(),
                    BigDecimal.ZERO, // Sem rendimento na criação
                    investment.contribution(),
                    investment.withdraw(),
                    investment.lastUpdateDate()
            );
            return saveGateway.save(newPosition);
        }

        // 2. Lógica de Atualização
        LocalDate today = LocalDate.now();
        LocalDate lastUpdate = investment.lastUpdateDate();

        // Busca o registro do mês anterior para servir de base de cálculo
        Optional<Investment> investmentPreviousMonth = findGateway.findInvestmentByPortfolioAndPreviousMonth(investment.idPortfolio(), today);
        Investment previousRecord = investmentPreviousMonth.orElse(investment);

        // Verifica se é uma virada de mês
        boolean isNewMonth = today.getYear() > lastUpdate.getYear() ||
                (today.getYear() == lastUpdate.getYear() && today.getMonthValue() > lastUpdate.getMonthValue());

        if (isNewMonth) {
            // CENÁRIO: Virada de Mês -> Novo Snapshot
            // Aqui o rendimento é calculado baseado na diferença entre o fechamento do mês anterior e o saldo atual
            Investment newSnapshot = getNewSnapshot(investment, previousRecord, today);
            return saveGateway.save(newSnapshot);

        } else {
            // CENÁRIO: Atualização no Mesmo Mês -> Atualiza Registro Existente

            BigDecimal currentRevenue = getCurrentRevenue(investment, investmentPreviousMonth, previousRecord);

            Investment updatedSnapshot = new Investment(
                    investment.idInvestment(),
                    investment.idPortfolio(),
                    investment.investmentType(),
                    investment.location(),
                    investment.balance(),
                    currentRevenue, // Rendimento recalculado
                    investment.contribution(),
                    investment.withdraw(),
                    today
            );
            return saveGateway.save(updatedSnapshot);
        }
    }

    private static BigDecimal getCurrentRevenue(Investment investment, Optional<Investment> investmentPreviousMonth, Investment previousRecord) {
        BigDecimal currentRevenue;

        if (investmentPreviousMonth.isEmpty()) {
            // Se não tem mês anterior, é o mês de criação. Rendimento deve ser ZERO.
            // (Ou calculado se você considerar lucro intraday no primeiro mês, mas o padrão é 0)
            currentRevenue = BigDecimal.ZERO;
        } else {
            // Fórmula: Saldo Atual - Saldo Mês Anterior - Aportes Atuais + Retiradas Atuais
            // Isso garante que se você mudar o saldo e o aporte agora, o rendimento se ajusta corretamente.
            currentRevenue = investment.balance()
                    .subtract(previousRecord.balance())
                    .subtract(investment.contribution() != null ? investment.contribution() : BigDecimal.ZERO)
                    .add(investment.withdraw() != null ? investment.withdraw() : BigDecimal.ZERO);
        }
        return currentRevenue;
    }

    private static Investment getNewSnapshot(Investment investment, Investment previousRecord, LocalDate today) {
        BigDecimal monthRevenue = investment.balance()
                .subtract(previousRecord.balance());

        return new Investment(
                null,
                investment.idPortfolio(),
                investment.investmentType(),
                investment.location(),
                investment.balance(),
                monthRevenue,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                today
        );
    }
}