package com.task.lectorsdepartments.service;

import com.task.lectorsdepartments.dto.LectorDto;
import com.task.lectorsdepartments.mapper.LectorMapper;
import com.task.lectorsdepartments.repository.LectorRepository;
import com.task.lectorsdepartments.service_api.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;
    private final LectorMapper lectorMapper;

    @Override
    public List<LectorDto> globalSearchByTemplate(String template) {
        return lectorRepository.globalSearchByTemplate(template).stream()
                .map(lectorMapper::toLectorDto)
                .collect(Collectors.toList());
    }
}
