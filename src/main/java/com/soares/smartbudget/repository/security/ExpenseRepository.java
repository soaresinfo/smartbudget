package com.soares.smartbudget.repository.security;

import com.soares.smartbudget.repository.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenseRepository extends CrudRepository<CategoryEntity, UUID> {

    public List<CategoryEntity> findByParentIsNull();

    public List<CategoryEntity> findCategoriesByParent(CategoryEntity parent);
}
