package com.soares.smartbudget.repository;

import com.soares.smartbudget.repository.entity.InvestmentTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InvestmentTypeRepository extends CrudRepository<InvestmentTypeEntity, UUID> {

}
