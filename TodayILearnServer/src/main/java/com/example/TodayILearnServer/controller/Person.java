package com.example.TodayILearnServer.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Person {
    private String lastName;
    private String firstName;
}
