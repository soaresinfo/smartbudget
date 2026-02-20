package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Location;
import com.soares.smartbudget.service.gateway.FindLocationGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindLocationService {

    private final FindLocationGateway gateway;

    public List<Location> findAll(){
        return gateway.findAllLocations();
    }

}
