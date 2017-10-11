package departmentProgram.service;

import departmentProgram.model.Employee;
import departmentProgram.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee save(Employee department){
        return employeeRepository.save(department);
    }

    public void delete(Employee department){
        employeeRepository.delete(department);
    }

    public Employee findById(int departmentId){
        return employeeRepository.findOne(departmentId);
    }
}
