package com.task.lectorsdepartments.view;

import com.task.lectorsdepartments.dto.LectorDto;
import com.task.lectorsdepartments.dto.StatisticsDto;
import com.task.lectorsdepartments.service_api.DepartmentService;
import com.task.lectorsdepartments.service_api.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsoleView {
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    public void showHeadOfDepartment(String departmentName) {
        LectorDto headOfDepartment = departmentService.getHeadOfDepartment(departmentName);
        System.out.println("The head of department of " + departmentName + " is " + headOfDepartment.getFirstName() + " " + headOfDepartment.getLastName());
    }

    public void showStatisticsOfLectors(String departmentName) {
        List<StatisticsDto> statisticOfLectors = departmentService.findStatisticOfLectors(departmentName);
        for (StatisticsDto statisticOfLector : statisticOfLectors) {
            System.out.println(statisticOfLector.getDegree() + " ---> " + statisticOfLector.getNumber());
        }
    }

    public void showAverageSalaryByDepartment(String departmentName) {
        BigDecimal averageSalaryByDepartment = departmentService.findAverageSalaryByDepartment(departmentName);
        System.out.println("The average salary of " + departmentName + " is " + averageSalaryByDepartment);
    }

    public void showEmployeeCountByDepartment(String departmentName) {
        Integer countOfEmployeeByDepartment = departmentService.findCountOfEmployeeByDepartment(departmentName);
        System.out.println("The employee count of " + departmentName + " is " + countOfEmployeeByDepartment);
    }

    public void globalSearchByTemplate(String template) {
        List<LectorDto> lectors = lectorService.globalSearchByTemplate(template);
        for(LectorDto lector : lectors) {
            System.out.println(lector.getFirstName() + " " + lector.getLastName());
        }
    }

}
