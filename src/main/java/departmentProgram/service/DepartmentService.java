package departmentProgram.service;

import departmentProgram.model.Department;
import departmentProgram.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public void delete(Department department){
        departmentRepository.delete(department);
    }

    public Department findById(int departmentId){
        return departmentRepository.findOne(departmentId);
    }
}
