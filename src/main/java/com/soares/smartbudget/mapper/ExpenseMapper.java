package com.soares.smartbudget.mapper;

import com.soares.smartbudget.controller.model.ExpenseRequestModel;
import com.soares.smartbudget.service.core.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseMapper {

    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    @Mapping(target = "idExpense", ignore = true)
    Expense fromModelToCore(ExpenseRequestModel source);
}
