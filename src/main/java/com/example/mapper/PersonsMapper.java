package com.example.mapper;

import com.example.dto.PersonsDto;
import com.example.model.Persons;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonsMapper {
    // Example mapping methods (customize as needed)
    Persons toEntity(PersonsDto dto);
    PersonsDto toDto(Persons entity);
}
