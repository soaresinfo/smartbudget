package com.soares.smartbudget.mapper;

import com.soares.smartbudget.controller.model.InvestmentTypeResponseModel;
import com.soares.smartbudget.repository.entity.InvestmentTypeEntity;
import com.soares.smartbudget.service.core.InvestmentType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvestmentTypeMapper {
    InvestmentTypeMapper INSTANCE = Mappers.getMapper(InvestmentTypeMapper.class);
    InvestmentType fromEntityToCore(InvestmentTypeEntity entity);
    InvestmentTypeResponseModel fromCoreToModel(InvestmentType core);
}