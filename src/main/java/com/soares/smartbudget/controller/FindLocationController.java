package com.soares.smartbudget.controller;

import com.soares.smartbudget.controller.model.LocationResponseModel;
import com.soares.smartbudget.mapper.LocationMapper;
import com.soares.smartbudget.service.FindLocationService;
import com.soares.smartbudget.service.core.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class FindLocationController {

    private final FindLocationService service;

    @GetMapping(path = "/locations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationResponseModel>> findAll(){
        List<Location> locations = service.findAll();
        return ResponseEntity.ok(LocationMapper.INSTANCE.fromCoreToModel(locations));
    }

}
