package com.task.lectorsdepartments.service;

import com.task.lectorsdepartments.dto.LectorDto;
import com.task.lectorsdepartments.dto.StatisticsDto;
import com.task.lectorsdepartments.entity.Department;
import com.task.lectorsdepartments.mapper.LectorMapper;
import com.task.lectorsdepartments.repository.DepartmentRepository;
import com.task.lectorsdepartments.repository.LectorRepository;
import com.task.lectorsdepartments.service_api.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;
    private final LectorMapper lectorMapper;

    @Override
    public LectorDto getHeadOfDepartment(String departmentName) {
        Department department = departmentRepository.findDepartmentByName(departmentName);
        return lectorMapper.toLectorDto(department.getHeadOfDepartment());
    }

    @Override
    public List<StatisticsDto> findStatisticOfLectors(String departmentName) {
        return departmentRepository.findStatisticOfLectors(departmentName);
    }

    @Override
    public BigDecimal findAverageSalaryByDepartment(String departmentName) {
        return departmentRepository.findAverageSalaryByDepartment(departmentName);
    }

    @Override
    public Integer findCountOfEmployeeByDepartment(String departmentName) {
        return lectorRepository.findCountOfEmployeeByDepartment(departmentName);
    }
}
