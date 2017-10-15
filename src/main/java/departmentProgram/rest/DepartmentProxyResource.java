package departmentProgram.rest;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.service.DepartmentService;
import departmentProgram.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.MultipartConfig;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Макс on 15.10.2017.
 */
@RestController
@RequestMapping("/proxy/department")
@MultipartConfig
@Slf4j
@RequiredArgsConstructor
@ConfigurationProperties("localpath.department")
public class DepartmentProxyResource {

    @Value("${department.directory}")
    private String directory;

    @Value("${department.name}")
    private String name;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public void addDepartment(@RequestBody Department department) {
        Department department1Duplicate = departmentService.findByName(department.getDepartament_name());
        if (department1Duplicate != null)
            throw new RuntimeException("Found duplicate during exception");
        departmentService.save(department);
    }

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.DELETE)
    public void deleteDepartment(@RequestBody Department department) {
        List<Employee> employeeList = employeeService.findEmployeesInDepartment(department.getDepartament_name());
        if (employeeList != null && employeeList.size() != 0)
            throw new RuntimeException("The department contains employees!");
        changeDepartmentsAssociation(department);
        departmentService.delete(department);
    }

    private void changeDepartmentsAssociation(Department department) {
        List<Department> departmentList = departmentService.findAllSubDepartments(department.getDepartament_name());
        for (int i = 0; i < departmentList.size(); i++) {
            departmentService.updateMainDepartment(departmentList.get(i), department.getNameMainDepartment());
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Department> findAllDepartments() {
        return departmentService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Employee findChiefEmployee(Department department) {
        return employeeService.findById(departmentService.findChiefEmployee(department));
    }

    @RequestMapping(value = "/updateDepartment", method = RequestMethod.PUT)
    public void updateDepartment(@RequestBody Department department) {
        Department department1Duplicate = departmentService.findByName(department.getDepartament_name());
        if (department1Duplicate != null)
            throw new RuntimeException("Found duplicate during exception");
        departmentService.delete(department);
    }

    @RequestMapping(value = "/updateMainDepartment", method = RequestMethod.PUT)
    public void updateMainDepartment(@RequestBody Department department, String nameMainDepartment) {
        departmentService.updateMainDepartment(department, nameMainDepartment);
    }

    @RequestMapping(value = "/findDepartmentById", method = RequestMethod.GET)
    public Department findDepartmentById(@RequestBody int id) {
        return departmentService.findById(id);
    }

    @RequestMapping(value = "/findDepartmentByName", method = RequestMethod.GET)
    public Department findDepartmentByName(@RequestBody String name) {
        return departmentService.findByName(name);
    }

    @RequestMapping(value = "/findSubDepartments", method = RequestMethod.GET)
    public List<Department> findSubDepartments(@RequestBody String name) {
        return departmentService.findSubDepartments(name);
    }

    @RequestMapping(value = "/findAllMainDepartments", method = RequestMethod.GET)
    public List<Department> findAllMainDepartments(@RequestBody String name) {
        return departmentService.findAllMainDepartments(name);
    }

    @RequestMapping(value = "/departmentSalary", method = RequestMethod.GET)
    public int departmentSalary(@RequestBody String name) {
        return departmentService.departmentSalary(name);
    }


}
