package com.soares.smartbudget.repository;

import com.soares.smartbudget.repository.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LocationRepository extends CrudRepository<LocationEntity, UUID> {

}
