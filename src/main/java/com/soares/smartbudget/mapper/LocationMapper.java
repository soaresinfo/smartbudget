package com.soares.smartbudget.mapper;

import com.soares.smartbudget.repository.entity.LocationEntity;
import com.soares.smartbudget.service.core.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);
    Location fromEntityToCore(LocationEntity entity);
}