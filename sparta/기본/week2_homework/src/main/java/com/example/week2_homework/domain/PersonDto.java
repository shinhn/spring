package com.example.week2_homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class PersonDto {
    private String name;
    private String job;
    private int age;
    private String address;
}
