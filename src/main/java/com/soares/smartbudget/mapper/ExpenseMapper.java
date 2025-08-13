package com.soares.smartbudget.mapper;

import com.soares.smartbudget.controller.model.ExpenseRequestModel;
import com.soares.smartbudget.controller.model.ExpenseResponseModel;
import com.soares.smartbudget.repository.entity.ExpenseEntity;
import com.soares.smartbudget.service.core.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExpenseMapper {

    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    @Mapping(target = "idExpense", ignore = true)
    Expense fromModelToCore(ExpenseRequestModel source);

    List<Expense> fromEntityToCore(List<ExpenseEntity> entity);

    Expense fromEntityToCore(ExpenseEntity entity);

    List<ExpenseResponseModel> fromCoreToModel(List<Expense> source);
}
