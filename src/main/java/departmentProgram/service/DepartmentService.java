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

    private List<Department> departmentList;

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
        return departmentRepository.findDepartmentByDepartmentName(departamentName);
    }

    public List<Department> findSubDepartments(String name_main_department) {
        return departmentRepository.findSubDepartments(name_main_department);
    }

    public void updateMainDepartment(Department department, String name_main_department) {
        department.setNameMainDepartment(name_main_department);
        departmentRepository.save(department);
    }

    public int departmentSalary(String departamentName) {
        return departmentRepository.departmentSalary(departmentRepository.findDepartmentByDepartmentName(departamentName).getId_department());
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
        while (mainName != null) {
            Department dep = findDepartmentByDepartmentName(mainName);
            departmentList.add(dep);
            mainName = dep.getNameMainDepartment();
        }
        return departmentList;
    }

    public List<Department> findAllSubDepartments(String nameDepartment){
        departmentList = new ArrayList<Department>();
        findAllSubDepartmentsRec(nameDepartment);
        return departmentList;
    }

    private void findAllSubDepartmentsRec(String nameDepartment) {
        List<Department> subList = departmentRepository.findSubDepartments(nameDepartment);
        if (subList != null) {
            for (int i = 0; i < subList.size(); i++) {
                departmentList.add(subList.get(i));
                findAllSubDepartmentsRec(subList.get(i).getDepartment_name());
            }
        }
    }

}
