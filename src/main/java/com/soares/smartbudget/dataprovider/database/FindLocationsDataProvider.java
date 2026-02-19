package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.mapper.LocationMapper;
import com.soares.smartbudget.repository.LocationRepository;
import com.soares.smartbudget.service.core.Location;
import com.soares.smartbudget.service.gateway.FindLocationGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindLocationsDataProvider implements FindLocationGateway {

    private final LocationRepository locationRepository;

    private final LocationMapper locationMapper = LocationMapper.INSTANCE;

    @Override
    public List<Location> findAllLocations() {
        log.info("Starting to find all locations.");
        try {
            log.debug("Searching for locations");
            var listLocationEntity = locationRepository.findAll();
            List<Location> listLocation = StreamSupport
                    .stream(listLocationEntity.spliterator(), false)
                    .map(locationMapper::fromEntityToCore)
                    .collect(Collectors.toList());

            if (listLocation.isEmpty()) {
                log.info("No locations found.");
                return Collections.emptyList();
            }

            log.info("Successfully found {} locations for the current month.", listLocation.size());
            return listLocation;
        } catch (Exception e) {
            log.error("Error finding investments.", e);
            return Collections.emptyList();
        }
    }

}
