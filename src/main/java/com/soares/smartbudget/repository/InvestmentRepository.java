package com.soares.smartbudget.repository;

import com.soares.smartbudget.repository.entity.InvestmentEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface InvestmentRepository extends CrudRepository<InvestmentEntity, UUID> {

    List<InvestmentEntity> findAllByLastUpdateDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
