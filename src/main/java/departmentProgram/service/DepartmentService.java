package departmentProgram.service;

import departmentProgram.model.Department;
import departmentProgram.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void updateMainDepartment(Department department, String name_main_department){
        department.setNameMainDepartment(name_main_department);
        departmentRepository.save(department);
    }

  public int departmentSalary(String departamentName){
       return departmentRepository.departmentSalary(departmentRepository.findByName(departamentName).getId_department());
    }

}
