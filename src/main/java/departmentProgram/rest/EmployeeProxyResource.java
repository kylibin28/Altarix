package departmentProgram.rest;

import departmentProgram.model.Employee;
import departmentProgram.service.DepartmentService;
import departmentProgram.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * Created by Макс on 15.10.2017.
 */
@RequestMapping(value = "/employees")
@RestController
public class EmployeeProxyResource {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeService.delete(employee);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAllEmployee() {
        return employeeService.findAll();
    }

    @RequestMapping(value = "/findEmployeesById", method = RequestMethod.GET)
    public Employee findEmployeesById(@RequestBody int id) {
        return employeeService.findById(id);
    }

    @RequestMapping(value = "/findEmployeesInDepartment", method = RequestMethod.GET)
    public List<Employee> findEmployeesInDepartment(@RequestBody String departmemtName) {
        return departmentService.findEmployeesInDepartment(departmemtName);
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee oldEmployee, Employee newEmployee) {
        employeeService.updateEmployee(oldEmployee, newEmployee);
    }

    @RequestMapping(value = "/updateEmployeesDepartment", method = RequestMethod.PUT)
    public void updateEmployeesDepartment(@RequestBody Employee oldEmployee, String newDepartmemtName) {
        employeeService.updateEmployeesDepartment(oldEmployee, newDepartmemtName);
    }

    @RequestMapping(value = "/dismissEmployee", method = RequestMethod.PUT)
    public void dismissEmployee(@RequestBody Employee employee, Date demissDate) {
        employeeService.dismissEmployee(employee, demissDate);
    }

    @RequestMapping(value = "/changeDepartment", method = RequestMethod.PUT)
    public void changeDepartment(@RequestBody String oldDepartmentName, String newDepartmemtName) {
        employeeService.changeDepartment(oldDepartmentName, newDepartmemtName);
    }

    @RequestMapping(value = "/findChiefOfEmployee", method = RequestMethod.PUT)
    public Employee findChiefOfEmployee(@RequestBody Employee employee) {
        return employeeService.findChiefOfEmployee(employee);
    }
}
