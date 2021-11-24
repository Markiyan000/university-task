package com.task.lectorsdepartments;

import com.task.lectorsdepartments.view.ConsoleView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LectorsDepartmentsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(LectorsDepartmentsApplication.class, args);
        ConsoleView consoleView = applicationContext.getBean(ConsoleView.class);
        String departmentName = "Computer Science";

        consoleView.showHeadOfDepartment(departmentName);
        consoleView.showStatisticsOfLectors(departmentName);
        consoleView.showAverageSalaryByDepartment(departmentName);
        consoleView.showEmployeeCountByDepartment(departmentName);
        consoleView.globalSearchByTemplate("pet");
    }
}
