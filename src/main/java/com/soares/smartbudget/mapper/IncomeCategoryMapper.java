package com.soares.smartbudget.mapper;

import com.soares.smartbudget.controller.model.IncomeCategoryResponseModel;
import com.soares.smartbudget.repository.entity.IncomeCategoryEntity;
import com.soares.smartbudget.service.core.IncomeCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IncomeCategoryMapper {
    IncomeCategoryMapper INSTANCE = Mappers.getMapper(IncomeCategoryMapper.class);

    IncomeCategory fromEntityToCore(IncomeCategoryEntity entity);

    IncomeCategoryResponseModel fromCoreToModel(IncomeCategory core);
}