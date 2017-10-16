package departmentProgram.rest;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Макс on 15.10.2017.
 */
@RequestMapping(value = "/departments")
@RestController
public class DepartmentProxyResource {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public void addDepartment(@RequestBody Department department) {
        Department department1Duplicate = departmentService.findDepartmentByDepartmentName(department.getDepartment_name());
        if (department1Duplicate != null)
            throw new RuntimeException("Found duplicate during exception");
        departmentService.saveDepartment(department);
    }

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.DELETE)
    public void deleteDepartment(@RequestBody Department department) {
        List<Employee> employeeList = departmentService.findEmployeesInDepartment(department.getDepartment_name());
        if (employeeList != null && employeeList.size() != 0)
            throw new RuntimeException("The department contains employees!");
        changeDepartmentsAssociation(department);
        departmentService.deleteDepartment(department);
    }

    private void changeDepartmentsAssociation(Department department) {
        List<Department> departmentList = departmentService.findAllSubDepartments(department.getDepartment_name());
        for (int i = 0; i < departmentList.size(); i++) {
            departmentService.updateMainDepartment(departmentList.get(i), department.getNameMainDepartment());
        }
    }
    @RequestMapping(value = "/findAllDepartments",method = RequestMethod.GET)
    public List<Department> findAllDepartments() {
        return departmentService.findAllDepartments();
    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public Employee findChiefEmployee(Department department) {
//        return departmentService.findChiefEmployee(department);
//    }

    @RequestMapping(value = "/updateDepartment", method = RequestMethod.PUT)
    public void updateDepartment(@RequestBody Department department) {
        Department department1Duplicate = departmentService.findDepartmentByDepartmentName(department.getDepartment_name());
        if (department1Duplicate != null)
            throw new RuntimeException("Found duplicate during exception");
        departmentService.saveDepartment(department);
    }

    @RequestMapping(value = "/updateMainDepartment", method = RequestMethod.PUT)
    public void updateMainDepartment(@RequestBody Department department, String nameMainDepartment) {
        departmentService.updateMainDepartment(department, nameMainDepartment);
    }

    @RequestMapping(value = "/findDepartmentById", method = RequestMethod.GET)
    public Department findDepartmentById(@RequestBody int id) {
        return departmentService.findDepartmentById(id);
    }

    @RequestMapping(value = "/findDepartmentByName", method = RequestMethod.GET)
    public Department findDepartmentByName(@RequestBody String name) {
        return departmentService.findDepartmentByDepartmentName(name);
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
