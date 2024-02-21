package net.power.employeeBook.Departments;

import net.power.employeeBook.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;
    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }
@GetMapping(path = "/max-salary")
    public Optional<Employee> getMaxSalaryInDep(@RequestParam("departmentId") int departmentId) {
        return departmentServiceImpl.getMaxSalaryInDep(departmentId);
    }
@GetMapping(path = "/min-salary")
    public Optional<Employee> getMinSalaryInDep(@RequestParam("departmentId") int departmentId) {
        return departmentServiceImpl.getMinSalaryInDep(departmentId);
    }
@GetMapping(path = "/all")
    public List<Employee> printAllEmployeesInDep(@RequestParam("departmentId") int departmentId) {
        return departmentServiceImpl.printEmployeesInDep(departmentId);
    }

@GetMapping(path = "/all1")
    public List<Employee> printAllDeps() {
        return departmentServiceImpl.printEmployeesAllDeps();
    }

@GetMapping("/{departmentId}/employees")
    public List<Employee> getEmployeesInDep(@PathVariable("departmentId") int departmentId) {
        return departmentServiceImpl.printEmployeesInDep(departmentId);
    }

@GetMapping("/{departmentId}/salary/sum")
public Integer getSumSalaryInDep(@PathVariable("departmentId") int departmentId) {
    return departmentServiceImpl.getSumSalaryInDep(departmentId);
}

@GetMapping("/{departmentId}/salary/max")
    public Optional<Employee> getMaxSalaryInDepByNum(@PathVariable("departmentId") int departmentId) {
        return departmentServiceImpl.getMaxSalaryInDep(departmentId);
}

@GetMapping("/{departmentId}/salary/min")
    public Optional<Employee> getMinSalaryInDepByNum(@PathVariable("departmentId") int departmentId) {
        return departmentServiceImpl.getMinSalaryInDep(departmentId);
}

@GetMapping("/employees")
    public Map<Integer,List<Employee>> getEmployeesByDep() {
        return departmentServiceImpl.getEmployeesByDep();
}
}