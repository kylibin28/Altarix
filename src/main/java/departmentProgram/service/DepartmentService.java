package departmentProgram.service;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeService employeeService;

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    public Department findDepartmentById(int departmentId) {
        return departmentRepository.findOne(departmentId);
    }

    public Department findDepartmentByDepartmentName(String departamentName) {
        return departmentRepository.findDepartmentByDepartment_name(departamentName);
    }

    public List<Department> findSubDepartments(String name_main_department) {
        return departmentRepository.findSubDepartments(name_main_department);
    }

    public List<Employee> findEmployeesInDepartment(String departmemtName) {
        Department dep = findDepartmentByDepartmentName(departmemtName);
        return departmentRepository.findEmployeesInDepartment(dep.getId_department());
    }


    public void updateMainDepartment(Department department, String name_main_department) {
        department.setNameMainDepartment(name_main_department);
        departmentRepository.save(department);
    }

    public int departmentSalary(String departamentName) {
        return departmentRepository.departmentSalary(departmentRepository.findDepartmentByDepartment_name(departamentName).getId_department());
    }

    public void updateChiefEmployee(Department oldDepartment, Employee chiefEmployee) {
        oldDepartment.setChief_employee(chiefEmployee);
        departmentRepository.save(oldDepartment);
    }

    public Employee findChiefEmployee(Department department) {
        return employeeService.findEmployeeById(departmentRepository.findChiefEmployee(department.getId_department()));
    }

    public List<Department> findAllMainDepartments(String nameDepartment) {
        List<Department> departmentList = new ArrayList<Department>();
        Department department = findDepartmentByDepartmentName(nameDepartment);
        String mainName = department.getNameMainDepartment();
        while (mainName != null){
           Department dep = findDepartmentByDepartmentName(mainName);
           departmentList.add(dep);
           mainName = dep.getNameMainDepartment();
        }
        return departmentList;
    }

    public List<Department> findAllSubDepartments(String nameDepartment) {//TODO рекурсивный поиск
        List<Department> departmentList = new ArrayList<Department>();
        Department department = findDepartmentByDepartmentName(nameDepartment);
        String mainName = department.getNameMainDepartment();
        while (mainName != null){
            Department dep = findDepartmentByDepartmentName(mainName);
            departmentList.add(dep);
            mainName = dep.getNameMainDepartment();
        }
        return departmentList;
    }

}
