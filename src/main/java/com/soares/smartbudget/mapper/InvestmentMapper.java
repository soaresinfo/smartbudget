package com.soares.smartbudget.mapper;

import com.soares.smartbudget.controller.model.InvestmentResponseModel;
import com.soares.smartbudget.repository.entity.InvestmentEntity;
import com.soares.smartbudget.service.core.Investment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {InvestmentTypeMapper.class, LocationMapper.class})
public interface InvestmentMapper {

    InvestmentMapper INSTANCE = Mappers.getMapper(InvestmentMapper.class);
    Investment fromEntityToCore(InvestmentEntity entity);
    List<Investment> fromEntityToCore(List<InvestmentEntity> entities);
    List<InvestmentResponseModel> fromCoreToModel(List<Investment> core);
}