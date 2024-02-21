package net.power.employeeBook.Departments;

import net.power.employeeBook.Employee;
import net.power.employeeBook.EmployeeService;
import net.power.employeeBook.EmployeeServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl extends EmployeeServiceImpl {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Optional<Employee> getMaxSalaryInDep (int departmentId) {
        return employeeService.printAllEmployees().values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    public Optional<Employee> getMinSalaryInDep (int departmentId) {
        return employeeService.printAllEmployees().values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary));
    }

    public List<Employee> printEmployeesInDep (int departmentId) {
        return employeeService.printAllEmployees().values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    List<Employee> printEmployeesAllDeps() {
        return employeeService.printAllEmployees().values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }

    public Integer getSumSalaryInDep(int departmentId) {
        return employeeService.printAllEmployees().values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
        }

    public Map<Integer, List<Employee>> getEmployeesByDep() {
        return employeeService.printAllEmployees().values().stream()
                .collect(Collectors.toMap(Employee :: getDepartmentId, e -> this.printEmployeesInDep(e.getDepartmentId())));
    }
}