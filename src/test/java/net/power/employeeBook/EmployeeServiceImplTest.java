package net.power.employeeBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    @Test
    void addNewEmployeePositiveTest() {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        Employee result = employeeServiceImpl.addNewEmployee("Иван", "Иванов", 1, 5000);
        Employee expected = new Employee("Иван", "Иванов", 1, 5000);
        Map<String, Employee> resultMap = employeeServiceImpl.employees;
        Map<String, Employee> expectedMap = Map.of("ИванИванов", new Employee("Иван", "Иванов", 1, 5000));
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(expectedMap, resultMap);
    }

    @Test
    @DisplayName("Если сотрудник уже добавлен")
    void addNewEmployeeNegativeTest() {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        employeeServiceImpl.addNewEmployee("Иван", "Иванов", 1, 5000);
        Assertions.assertThrows(RuntimeException.class, () -> employeeServiceImpl.addNewEmployee("Иван", "Иванов", 1, 5000));
    }

    @Test
    void removeEmployee() {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        employeeServiceImpl.addNewEmployee("Иван", "Иванов", 1, 5000);
        employeeServiceImpl.removeEmployee("Иван", "Иванов");
        Map<String, Employee> resultMap = employeeServiceImpl.employees;

        Map<String, Employee> expectedMap = Map.of();

        Assertions.assertEquals(expectedMap, resultMap);
    }

    @Test
    @DisplayName("Если сотрудник не найден")
        void removeEmployee2() {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        Assertions.assertThrows(RuntimeException.class, () -> employeeServiceImpl.removeEmployee("Иван", "Иванов"));
    }

    @Test
    void findEmployee() {
        Map<String, Employee> employees = new HashMap<>();
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

        Employee addedEmployee = employeeServiceImpl.addNewEmployee("Иван", "Иванов", 1, 5000);
        employees.put(addedEmployee.getFirstName() + addedEmployee.getLastName(), addedEmployee);

        Employee result = employeeServiceImpl.findEmployee("Иван", "Иванов");

        Employee expected = employeeServiceImpl.findEmployee(addedEmployee.getFirstName(), addedEmployee.getLastName());

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Если сотрудник не найден")
    void findEmployee2() {
        Map<String, Employee> employees = new HashMap<>();
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

        Employee addedEmployee = employeeServiceImpl.addNewEmployee("Иван", "Иванов", 1, 5000);
        employees.put(addedEmployee.getFirstName() + addedEmployee.getLastName(), addedEmployee);

        Assertions.assertThrows(RuntimeException.class, () -> employeeServiceImpl.findEmployee("Петр", "Петров"));
    }

    @Test
    void printAllEmployees() {
        Map<String, Employee> employees = new HashMap<>();
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        Employee addedEmployee = employeeServiceImpl.addNewEmployee("Иван", "Иванов", 1, 5000);
        employees.put(addedEmployee.getFirstName() + addedEmployee.getLastName(), addedEmployee);

        Map<String, Employee> actualMap = employeeServiceImpl.printAllEmployees();

        Assertions.assertEquals(employees, actualMap);
    }

}