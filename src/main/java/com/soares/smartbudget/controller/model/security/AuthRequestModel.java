package com.soares.smartbudget.controller.model.security;

import lombok.Data;

@Data
public class AuthRequestModel {
    private String username;
    private String password;
}