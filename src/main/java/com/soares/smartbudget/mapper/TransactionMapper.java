package com.soares.smartbudget.mapper;

import com.soares.smartbudget.controller.model.TransactionRequestModel;
import com.soares.smartbudget.controller.model.TransactionResponseModel;
import com.soares.smartbudget.repository.entity.TransactionEntity;
import com.soares.smartbudget.service.core.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ExpenseMapper.class)
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "idTransaction", ignore = true)
    @Mapping(source = "idExpense", target = "expense.idExpense")
    Transaction fromModelToCore(TransactionRequestModel source);

    TransactionResponseModel fromCoreToModel(Transaction source);

    TransactionEntity fromCoreToEntity(Transaction core);

    Transaction fromEntityToCore(TransactionEntity save);
}
