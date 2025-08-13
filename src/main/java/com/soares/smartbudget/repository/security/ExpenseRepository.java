package com.soares.smartbudget.repository.security;

import com.soares.smartbudget.repository.entity.ExpenseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ExpenseRepository extends CrudRepository<ExpenseEntity, UUID> {
}
