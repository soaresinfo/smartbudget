package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Investment;
import com.soares.smartbudget.service.gateway.SaveInvestmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SaveInvestmentService {

    private final SaveInvestmentGateway gateway;

    @Transactional
    public Investment save(Investment investment) {

        if (investment.idInvestment() == null) {
            UUID newPortfolioId = UUID.randomUUID();
            Investment newPosition = new Investment(
                    null,
                    newPortfolioId,
                    investment.investmentType(),
                    investment.location(),
                    investment.balance(),
                    investment.monthRevenue(),
                    investment.lastUpdateDate()
            );
            return gateway.save(newPosition);
        }

        LocalDate today = LocalDate.now();
        LocalDate lastUpdate = investment.lastUpdateDate();

        // CONDIÇÃO PRINCIPAL: O mês (e ano) atual é posterior ao do último registro?
        if (today.getYear() > lastUpdate.getYear() || (today.getYear() == lastUpdate.getYear() && today.getMonthValue() > lastUpdate.getMonthValue())) {
            // SIM: Criamos um NOVO registro (snapshot) para o mês atual.
            // Mantemos o portfolioId, mas o idInvestment será novo.
            Investment newSnapshot = new Investment(
                    null,
                    investment.idPortfolio(),
                    investment.investmentType(),
                    investment.location(),
                    investment.balance(),
                    investment.monthRevenue(),
                    today
            );
            return gateway.save(newSnapshot);
        } else {
            // NÃO: A atualização é para o mesmo mês. Apenas atualizamos o registro existente.
            // O ID do registro e o ID do portfólio são mantidos.
            return gateway.save(investment);
        }
    }
}
