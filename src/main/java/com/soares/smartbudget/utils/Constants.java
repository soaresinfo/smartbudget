package com.soares.smartbudget.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constants {

    DATE("yyyy-MM-dd");

    private final String description;
}
