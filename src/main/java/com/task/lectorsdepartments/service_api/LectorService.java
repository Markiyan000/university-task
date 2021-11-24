package com.task.lectorsdepartments.service_api;

import com.task.lectorsdepartments.dto.LectorDto;

import java.util.List;

public interface LectorService {
    List<LectorDto> globalSearchByTemplate(String template);
}
