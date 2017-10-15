package departmentProgram.service;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void delete(Department department) {
        departmentRepository.delete(department);
    }

    public Department findById(int departmentId) {
        return departmentRepository.findOne(departmentId);
    }

    public Department findByName(String departamentName) {
        return departmentRepository.findByName(departamentName);
    }

    public List<Department> findSubDepartments(String name_main_department) {
        return departmentRepository.findSubDepartments(name_main_department);
    }

    public void updateMainDepartment(Department department, String name_main_department) {
        department.setNameMainDepartment(name_main_department);
        departmentRepository.save(department);
    }

    public int departmentSalary(String departamentName) {
        return departmentRepository.departmentSalary(departmentRepository.findByName(departamentName).getId_department());
    }

    public void updateChiefEmployee(Department oldDepartment, Employee chiefEmployee) {
        oldDepartment.setChief_employee(chiefEmployee);
        departmentRepository.save(oldDepartment);
    }

    public int findChiefEmployee(Department department) {
        return departmentRepository.departmentSalary(department.getId_department());
    }

    public List<Department> findAllMainDepartments(String nameDepartment) {
        List<Department> departmentList = new ArrayList<Department>();
        Department department = findByName(nameDepartment);
        String mainName = department.getNameMainDepartment();
        while (mainName != null){
           Department dep = findByName(mainName);
           departmentList.add(dep);
           mainName = dep.getNameMainDepartment();
        }
        return departmentList;
    }

    public List<Department> findAllSubDepartments(String nameDepartment) {//TODO рекурсивный поиск
        List<Department> departmentList = new ArrayList<Department>();
        Department department = findByName(nameDepartment);
        String mainName = department.getNameMainDepartment();
        while (mainName != null){
            Department dep = findByName(mainName);
            departmentList.add(dep);
            mainName = dep.getNameMainDepartment();
        }
        return departmentList;
    }

}
