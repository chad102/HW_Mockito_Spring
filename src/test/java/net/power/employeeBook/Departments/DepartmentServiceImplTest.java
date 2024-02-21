package net.power.employeeBook.Departments;

import net.power.employeeBook.Employee;
import net.power.employeeBook.EmployeeService;
import net.power.employeeBook.EmployeeServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    public void setUp() {
        Map<String, Employee> employees = new HashMap<>();
        when(employeeService.printAllEmployees()).thenReturn(employees);
    }


    @Test
    @DisplayName("Не возвращает лист сотрудников")
    void getMaxSalaryInDep() {
        Optional<Employee> expected = Optional.empty();
        Assertions.assertEquals(expected, out.getMaxSalaryInDep(1));
        assertThat(out.getMaxSalaryInDep(1)).isEmpty();
    }

    @Test
    @DisplayName("С добавлением одного сотрудника в map")
    void getMaxSalaryInDep1() {
        Employee employee = new Employee("asdf","qwet", 2, 2134);
        Map<String, Employee> expected = Map.of(employee.getFirstName()+ employee.getLastName(),employee);
        when(employeeService.printAllEmployees()).thenReturn(expected);
        Employee actual = out.getMaxSalaryInDep(2).get();
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
        Employee actual = out.getMaxSalaryInDep(2).get();
        assertThat(employee).isEqualTo(actual);
    }


    @Test
    void getMinSalaryInDep() {
        Optional<Employee> expected = Optional.empty();
        Assertions.assertEquals(expected, out.getMinSalaryInDep(1));
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