package com.soares.smartbudget.repository;

import com.soares.smartbudget.repository.entity.IncomeEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IncomeRepository extends CrudRepository<IncomeEntity, UUID> {

    List<IncomeEntity> findAllByIncomeDateBetween(LocalDate startDate, LocalDate endDate);
}
