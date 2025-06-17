package com.example.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Container(containerName = "persons")
@Data
@NoArgsConstructor
public class Persons {
    @Id
    @PartitionKey
    private String id;

    private String name;
    private Integer age;
    private String sex;
}
