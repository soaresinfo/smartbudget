package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Investment;
import com.soares.smartbudget.service.gateway.FindInvestmentsGateway;
import com.soares.smartbudget.service.gateway.SaveInvestmentGateway;
import lombok.RequiredArgsConstructor;
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
    public Investment save(Investment investment) {

        if (investment.idInvestment() == null) {
            UUID newPortfolioId = UUID.randomUUID();
            Investment newPosition = new Investment(
                    null,
                    newPortfolioId.toString(),
                    investment.investmentType(),
                    investment.location(),
                    investment.balance(),
                    investment.monthRevenue(),
                    investment.contribution(),
                    investment.lastUpdateDate()
            );
            return saveGateway.save(newPosition);
        }

        LocalDate today = LocalDate.now();
        LocalDate lastUpdate = investment.lastUpdateDate();

        Optional<Investment> investmentPreviousMonth = findGateway.findInvestmentByPortfolioAndPreviousMonth(investment.idPortfolio(), today);
        BigDecimal monthRevenue = investment.balance().subtract(investmentPreviousMonth.orElse(investment).balance());

        // CONDIÇÃO PRINCIPAL: O mês (e ano) atual é posterior ao do último registro?
        if (today.getYear() > lastUpdate.getYear() || (today.getYear() == lastUpdate.getYear() && today.getMonthValue() > lastUpdate.getMonthValue())) {
            // SIM: Criamos um NOVO registro (snapshot) para o mês atual.
            // Mantemos o portfolioId, mas o idInvestment será novo.
            Investment newSnapshot = new Investment(
                    null,
                    investment.idPortfolio(),
                    investment.investmentType(),
                    investment.location(),
                    investment.balance().add(investment.contribution()),
                    monthRevenue,
                    BigDecimal.ZERO,
                    today
            );
            return saveGateway.save(newSnapshot);
        } else {
            // NÃO: A atualização é para o mesmo mês. Apenas atualizamos o registro existente.
            // O ID do registro e o ID do portfólio são mantidos.
            Investment updatedSnapshot = new Investment(
                    investment.idInvestment(),
                    investment.idPortfolio(),
                    investment.investmentType(),
                    investment.location(),
                    investment.balance(),
                    monthRevenue,
                    investment.contribution(),
                    investment.lastUpdateDate()
            );
            return saveGateway.save(updatedSnapshot);
        }
    }
}
