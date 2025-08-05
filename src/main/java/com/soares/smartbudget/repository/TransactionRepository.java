package com.soares.smartbudget.repository;

import com.soares.smartbudget.repository.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findByTransactionDateBetween(LocalDate start, LocalDate end);
}
