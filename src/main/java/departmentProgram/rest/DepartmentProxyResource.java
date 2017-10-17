package departmentProgram.rest;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.service.DepartmentService;
import departmentProgram.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Макс on 15.10.2017.
 */
@RequestMapping(value = "/departments")
@RestController
public class DepartmentProxyResource {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/addDepartment/{department}", method = RequestMethod.POST)
    public void addDepartment(@RequestBody Department department) {
        Department department1Duplicate = departmentService.findDepartmentByDepartmentName(department.getDepartment_name());
        if (department1Duplicate != null)
            throw new RuntimeException("Found duplicate during exception");
        departmentService.saveDepartment(department);
    }

    @RequestMapping(value = "/deleteDepartment/{department}", method = RequestMethod.DELETE)
    public void deleteDepartment(@RequestBody Department department) {
        List<Employee> employeeList = employeeService.findEmployeesInDepartment(department.getDepartment_name());
        if (employeeList != null && employeeList.size() != 0)
            throw new RuntimeException("The department contains employees!");
        changeDepartmentsAssociation(department);
        departmentService.deleteDepartment(department);
    }

    private void changeDepartmentsAssociation(Department department) {
        List<Department> departmentList = departmentService.findSubDepartments(department.getDepartment_name());
        for (int i = 0; i < departmentList.size(); i++) {
            departmentService.updateMainDepartment(departmentList.get(i), department.getNameMainDepartment());
        }
    }

    @RequestMapping(value = "/findAllDepartments", method = RequestMethod.GET)
    public List<Department> findAllDepartments() {
        return departmentService.findAllDepartments();
    }

    @RequestMapping(value = "/findChiefEmployee/{department}", method = RequestMethod.GET)
    public Employee findChiefEmployee(@PathVariable Department department) {
        return departmentService.findChiefEmployee(department);
    }

    @RequestMapping(value = "/updateDepartment/{department}", method = RequestMethod.PUT)
    public void updateDepartment(@PathVariable Department department) {
        Department department1Duplicate = departmentService.findDepartmentByDepartmentName(department.getDepartment_name());
        if (department1Duplicate != null)
            throw new RuntimeException("Found duplicate during exception");
        departmentService.saveDepartment(department);
    }

    @RequestMapping(value = "/updateMainDepartment/{department, nameMainDepartment}", method = RequestMethod.PUT)
    public void updateMainDepartment(@PathVariable Department department, String nameMainDepartment) {
        departmentService.updateMainDepartment(department, nameMainDepartment);
    }

    @RequestMapping(value = "/findDepartmentById/{id}", method = RequestMethod.GET)
    public Department findDepartmentById(@PathVariable("id") int id) {
        return departmentService.findDepartmentById(id);
    }

    @RequestMapping(value = "/findDepartmentByName/{name}", method = RequestMethod.GET)
    public Department findDepartmentByName(@PathVariable String name) {
        return departmentService.findDepartmentByDepartmentName(name);
    }

    @RequestMapping(value = "/findSubDepartments/{name}", method = RequestMethod.GET)
    public List<Department> findSubDepartments(@PathVariable String name) {
        return departmentService.findSubDepartments(name);
    }

    @RequestMapping(value = "/findAllMainDepartments/{name}", method = RequestMethod.GET)
    public List<Department> findAllMainDepartments(@PathVariable String name) {
        return departmentService.findAllMainDepartments(name);
    }

 @RequestMapping(value = "/findAllSubDepartments/{name}", method = RequestMethod.GET)
    public List<Department> findAllSubDepartments(@PathVariable String name) {
        return departmentService.findAllSubDepartments(name);
    }

    @RequestMapping(value = "/departmentSalary/{name}", method = RequestMethod.GET)
    public int departmentSalary(@PathVariable String name) {
        return departmentService.departmentSalary(name);
    }


}
