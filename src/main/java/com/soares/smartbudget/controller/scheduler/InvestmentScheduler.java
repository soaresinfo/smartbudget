package com.soares.smartbudget.controller.scheduler;

import com.soares.smartbudget.controller.scheduler.config.AsyncConfig;
import com.soares.smartbudget.service.FindInvestmentsService;
import com.soares.smartbudget.service.SaveInvestmentService;
import com.soares.smartbudget.service.core.Investment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvestmentScheduler {

    private final SaveInvestmentService saveInvestment;
    private final FindInvestmentsService findInvestment;

    // Executa à 01:00 AM no primeiro dia de cada mês
    @Scheduled(cron = "0 0 4 1 * ?")
    public void processMonthlyInvestments() {
        LocalDate today = LocalDate.now();
        log.info("Iniciando processamento mensal de investimentos para a data: {}", today);

        try {
            LocalDate startOfLastMonth = today.minusMonths(1).withDayOfMonth(1);
            LocalDate endOfLastMonth = today.minusDays(1);

            List<Investment> lastMonthInvestments = findInvestment.findAllInvestmentsByMonth(startOfLastMonth, endOfLastMonth);

            log.info("Encontrados {} investimentos para processar snapshot.", lastMonthInvestments.size());

            lastMonthInvestments.forEach(investment -> {
                try {
                    CompletableFuture.runAsync(() -> saveInvestment.save(investment), new AsyncConfig().investmentTaskExecutor());
                } catch (Exception e) {
                    log.error("Erro ao processar snapshot para o portfolio: {}", investment.idPortfolio(), e);
                }
            });

            log.info("Processamento mensal concluído com sucesso.");
        } catch (Exception e) {
            log.error("Falha crítica no scheduler de investimentos", e);
        }
    }
}