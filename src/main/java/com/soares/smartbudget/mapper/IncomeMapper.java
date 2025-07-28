package com.soares.smartbudget.mapper;

import com.soares.smartbudget.controller.model.IncomeResponseModel;
import com.soares.smartbudget.repository.entity.IncomeEntity;
import com.soares.smartbudget.service.core.Income;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {IncomeCategoryMapper.class})
public interface IncomeMapper {

    IncomeMapper INSTANCE = Mappers.getMapper(IncomeMapper.class);

    Income fromEntityToCore(IncomeEntity entity);

    List<Income> fromEntityToCore(List<IncomeEntity> entities);

    IncomeEntity fromCoreToEntity(Income core);

    IncomeResponseModel fromCoreToModel(Income core);

    List<IncomeResponseModel> fromCoreToModel(List<Income> core);
}