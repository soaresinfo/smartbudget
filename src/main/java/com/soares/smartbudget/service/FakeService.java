package com.soares.smartbudget.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FakeService {

    public void save(){
        System.out.println("FakeService.save() -> spy rodou");
    }
}
