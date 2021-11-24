package com.task.lectorsdepartments.mapper;

import com.task.lectorsdepartments.dto.LectorDto;
import com.task.lectorsdepartments.entity.Lector;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LectorMapper {
    LectorDto toLectorDto(Lector lector);
}
