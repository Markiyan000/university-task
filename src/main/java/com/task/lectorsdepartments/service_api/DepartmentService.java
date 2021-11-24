package com.task.lectorsdepartments.service_api;

import com.task.lectorsdepartments.dto.LectorDto;
import com.task.lectorsdepartments.dto.StatisticsDto;

import java.math.BigDecimal;
import java.util.List;

public interface DepartmentService {
    LectorDto getHeadOfDepartment(String departmentName);

    List<StatisticsDto> findStatisticOfLectors(String departmentName);

    BigDecimal findAverageSalaryByDepartment(String departmentName);

    Integer findCountOfEmployeeByDepartment(String departmentName);
}
