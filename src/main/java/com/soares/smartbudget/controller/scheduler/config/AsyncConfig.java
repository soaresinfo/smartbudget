package com.soares.smartbudget.controller.scheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "investmentTaskExecutor")
    public Executor investmentTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // Define o número inicial de threads
        executor.setCorePoolSize(5);

        // LIMITANTE CRUCIAL: Não deve exceder o maximum-pool-size do Hikari (15 no seu caso)
        // Deixe uma margem para threads que não são do scheduler (ex: requisições web)
        executor.setMaxPoolSize(12);

        // Capacidade da fila de espera antes de criar novas threads até o MaxPoolSize
        executor.setQueueCapacity(500);

        executor.setThreadNamePrefix("Inv-Async-");

        // Política de rejeição: o que fazer se a fila estiver cheia e as 12 threads ocupadas?
        // CallerRunsPolicy faz com que a thread principal execute a tarefa, diminuindo o ritmo
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.initialize();
        return executor;
    }
}