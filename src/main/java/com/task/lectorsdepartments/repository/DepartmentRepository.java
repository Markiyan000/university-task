package com.task.lectorsdepartments.repository;

import com.task.lectorsdepartments.dto.StatisticsDto;
import com.task.lectorsdepartments.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value = "select d from Department d join fetch d.headOfDepartment where d.name = :departmentName")
    Department findDepartmentByName(String departmentName);

    @Query(value = "select l.degree, count(l.degree) as number from department as d " +
            "inner join lector_department as dl " +
            "on d.id = dl.department_id " +
            "inner join lector as l " +
            "on l.id = dl.lector_id " +
            "where d.name = :departmentName " +
            "group by l.degree;", nativeQuery = true)
    List<StatisticsDto> findStatisticOfLectors(String departmentName);

    @Query(value = "select avg(salary) from department as d " +
            "inner join lector_department as dl " +
            "on d.id = dl.department_id " +
            "inner join lector as l " +
            "on l.id = dl.lector_id " +
            "where d.name = :departmentName", nativeQuery = true)
    BigDecimal findAverageSalaryByDepartment(String departmentName);
}
