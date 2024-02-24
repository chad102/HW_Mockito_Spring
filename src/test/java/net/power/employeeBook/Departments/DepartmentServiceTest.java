package net.power.employeeBook.Departments;

import net.power.employeeBook.Employee;
import net.power.employeeBook.EmployeeService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService out;

    @Test
    @DisplayName("С добавлением одного сотрудника в map")
    void getMaxSalaryInDep1() {
        Employee employee = new Employee("asdf","qwet", 2, 2134);
        Map<String, Employee> expected = Map.of(employee.getFirstName()+ employee.getLastName(),employee);
        when(employeeService.printAllEmployees()).thenReturn(expected);
        Employee actual = out.getMaxSalaryInDep(2);
        assertThat(employee).isEqualTo(actual);
    }

    @Test
    @DisplayName("С добавлением нескольких сотрудников в map")
    void getMaxSalaryInDep2() {
        Employee employee = new Employee("asdf","qwet", 2, 2134);
        Employee employee1 = new Employee("ыжвдлат","аьор", 2, 33218);
        Employee employee2 = new Employee("атм","кен", 2, 516);
        Map<String, Employee> expected = Map.of(employee.getFirstName()+ employee.getLastName(),employee,
                employee1.getFirstName() + employee1.getLastName(),employee1,
                employee2.getFirstName() + employee2.getLastName(),employee2);
        when(employeeService.printAllEmployees()).thenReturn(expected);
        Employee actual = out.getMaxSalaryInDep(2);
        assertThat(employee1).isEqualTo(actual);
    }

    @Test
    @DisplayName("С добавлением одного сотрудника в map")
    void getMinSalaryInDep1() {
        Employee employee = new Employee("asdf","qwet", 2, 2134);
        Map<String, Employee> expected = Map.of(employee.getFirstName()+ employee.getLastName(),employee);
        when(employeeService.printAllEmployees()).thenReturn(expected);
        Employee actual = out.getMinSalaryInDep(2);
        assertThat(employee).isEqualTo(actual);
    }

    @Test
    @DisplayName("С добавлением нескольких сотрудников в map")
    void getMinSalaryInDep2() {
        Employee employee = new Employee("asdf","qwet", 2, 2134);
        Employee employee1 = new Employee("ыжвдлат","аьор", 2, 33218);
        Employee employee2 = new Employee("атм","кен", 2, 516);
        Map<String, Employee> expected = Map.of(employee.getFirstName()+ employee.getLastName(),employee,
                employee1.getFirstName() + employee1.getLastName(),employee1,
                employee2.getFirstName() + employee2.getLastName(),employee2);
        when(employeeService.printAllEmployees()).thenReturn(expected);
        Employee actual = out.getMinSalaryInDep(2);
        assertThat(employee2).isEqualTo(actual);
    }

    @Test
    void printEmployeesInDep() {
        List<Employee> expected = List.of();
        Assertions.assertEquals(expected, out.printEmployeesInDep(1));
    }

    @Test
    void printEmployeesAllDeps() {
        List<Employee> expected = List.of();
        Assertions.assertEquals(expected, out.printEmployeesAllDeps());
    }

    @Test
    void getSumSalaryInDep() {
        Integer expected = 0;
        Assertions.assertEquals(expected, out.getSumSalaryInDep(2));
    }

    @Test
    void getEmployeesByDep() {
        Map<Integer,List<Employee>> expected = Collections.emptyMap();
        Assertions.assertEquals(expected, out.getEmployeesByDep());
    }
}