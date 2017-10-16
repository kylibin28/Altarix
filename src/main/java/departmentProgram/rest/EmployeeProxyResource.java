package departmentProgram.rest;

import departmentProgram.model.Department;
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
        employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
    }

    @RequestMapping(value = "/findAllEmployee",method = RequestMethod.GET)
    public List<Employee> findAllEmployee() {
        return employeeService.findAllEmployees();
    }

    @RequestMapping(value = "/findEmployeesById", method = RequestMethod.GET)
    public Employee findEmployeesById(@RequestBody int id) {
        return employeeService.findEmployeeById(id);
    }

    @RequestMapping(value = "/findEmployeesInDepartment", method = RequestMethod.GET)
    public List<Employee> findEmployeesInDepartment(@RequestBody String departmemtName) {
        return employeeService.findEmployeesInDepartment(departmemtName);
    }

    @RequestMapping(value = "/findEmployeesByParameters", method = RequestMethod.GET)
    public List<Employee> findEmployeesByParameters(@RequestBody String surname, String name, String patronymic, Date birthday) {
        return employeeService.findEmployeesByParameters(surname, name, patronymic, birthday);
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee oldEmployee, Employee newEmployee) {
        employeeService.updateEmployee(oldEmployee, newEmployee);
    }

    @RequestMapping(value = "/updateEmployeesDepartment", method = RequestMethod.PUT)
    public void updateEmployeesDepartment(@RequestBody Employee oldEmployee, String newDepartmemtName) {
        Department department = departmentService.findDepartmentByDepartmentName(newDepartmemtName);
        if(department == null)
            throw new RuntimeException("Not found department " + newDepartmemtName);
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
    public Employee findChiefOfEmployee(@RequestBody int id) {
        return employeeService.findChiefOfEmployeeById(id);
    }
}
