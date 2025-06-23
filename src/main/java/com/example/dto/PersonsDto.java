package com.example.dto;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class PersonsDto {
    private String name;
    private Integer age;
    private String sex;
}
