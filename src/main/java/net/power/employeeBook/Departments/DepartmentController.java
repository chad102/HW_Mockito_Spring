package net.power.employeeBook.Departments;

import net.power.employeeBook.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
@GetMapping(path = "/all")
    public List<Employee> printAllEmployeesInDep(@RequestParam("departmentId") int departmentId) {
        return departmentService.printEmployeesInDep(departmentId);
    }

@GetMapping("/{departmentId}/employees")
    public List<Employee> getEmployeesInDep(@PathVariable("departmentId") int departmentId) {
        return departmentService.printEmployeesInDep(departmentId);
    }

@GetMapping("/{departmentId}/salary/sum")
public Integer getSumSalaryInDep(@PathVariable("departmentId") int departmentId) {
    return departmentService.getSumSalaryInDep(departmentId);
}

@GetMapping("/{departmentId}/salary/max")
    public Employee getMaxSalaryInDepByNum(@PathVariable("departmentId") int departmentId) {
        return departmentService.getMaxSalaryInDep(departmentId);
}

@GetMapping("/{departmentId}/salary/min")
    public Employee getMinSalaryInDepByNum(@PathVariable("departmentId") int departmentId) {
        return departmentService.getMinSalaryInDep(departmentId);
}

@GetMapping("/employees")
    public Map<Integer,List<Employee>> getEmployeesByDep() {
        return departmentService.getEmployeesByDep();
}
}