package com.task.lectorsdepartments.repository;

import com.task.lectorsdepartments.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query(value = "select count(l.id) from lector as l " +
            "inner join lector_department as dl " +
            "on l.id = dl.lector_id " +
            "inner join department as d " +
            "on d.id = dl.department_id " +
            "where d.name = :departmentName", nativeQuery = true)
    Integer findCountOfEmployeeByDepartment(String departmentName);

    @Query(value = "select l from Lector l " +
            "where lower(l.firstName) like lower(concat('%', :template, '%')) " +
            "or lower(l.lastName) like lower(concat('%', :template, '%'))")
    List<Lector> globalSearchByTemplate(String template);
}
