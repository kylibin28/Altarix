package departmentProgram.rest;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.service.DepartmentService;
import departmentProgram.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/addEmployee/{employee}", method = RequestMethod.POST)
    public void addEmployee(@PathVariable Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "/deleteEmployee/{employee}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable Employee employee) {
        employeeService.deleteEmployee(employee);
    }

    @RequestMapping(value = "/findAllEmployee", method = RequestMethod.GET)
    public List<Employee> findAllEmployee() {
        return employeeService.findAllEmployees();
    }

    @RequestMapping(value = "/findEmployeesById/{id}", method = RequestMethod.GET)
    public Employee findEmployeesById(@PathVariable int id) {
        return employeeService.findEmployeeById(id);
    }

    @RequestMapping(value = "/findEmployeesInDepartment/{departmentName}", method = RequestMethod.GET)
    public List<Employee> findEmployeesInDepartment(@PathVariable String departmentName) {
        return employeeService.findEmployeesInDepartment(departmentName);
    }

    @RequestMapping(value = "/findEmployeesByParameters/{surname,name,patronymic,birthday}", method = RequestMethod.GET)
    public List<Employee> findEmployeesByParameters(@PathVariable String surname, String name, String patronymic, Date birthday) {
        return employeeService.findEmployeesByParameters(surname, name, patronymic, birthday);
    }

    @RequestMapping(value = "/updateEmployee/{oldEmployee,newEmployee}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable Employee oldEmployee, Employee newEmployee) {
        employeeService.updateEmployee(oldEmployee, newEmployee);
    }

    @RequestMapping(value = "/updateEmployeesDepartment/{oldEmployee,newDepartmentName}", method = RequestMethod.PUT)
    public void updateEmployeesDepartment(@PathVariable Employee oldEmployee, String newDepartmentName) {
        Department department = departmentService.findDepartmentByDepartmentName(newDepartmentName);
        if (department == null)
            throw new RuntimeException("Not found department " + newDepartmentName);
        employeeService.updateEmployeesDepartment(oldEmployee, newDepartmentName);
    }

    @RequestMapping(value = "/dismissEmployee/{employee,demissDate}", method = RequestMethod.PUT)
    public void dismissEmployee(@PathVariable Employee employee, Date demissDate) {
        employeeService.dismissEmployee(employee, demissDate);
    }

    @RequestMapping(value = "/changeDepartment/{oldDepartmentName,newDepartmentName}", method = RequestMethod.PUT)
    public void changeDepartment(@PathVariable String oldDepartmentName, String newDepartmentName) {
        employeeService.changeDepartment(oldDepartmentName, newDepartmentName);
    }

    @RequestMapping(value = "/findChiefOfEmployee/{id}", method = RequestMethod.PUT)
    public Employee findChiefOfEmployee(@PathVariable int id) {
        return employeeService.findChiefOfEmployeeById(id);
    }
}
