package departmentProgram.service;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.repository.DepartmentRepository;
import departmentProgram.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentService;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }

    public Employee findById(int departmentId){
        return employeeRepository.findOne(departmentId);
    }

    public List<Employee> findEmployeesInDepartment(String departmemtName){
        Department dep = departmentService.findByName(departmemtName);
        return employeeRepository.findEmployeesInDepartment(dep.getId_department());
    }

    public void updateEmployee(Employee oldEmployee, Employee newEmployee){
        oldEmployee.setSurname(newEmployee.getSurname());
        oldEmployee.setName(newEmployee.getName());
        oldEmployee.setPatronymic(newEmployee.getPatronymic());
        oldEmployee.setSex(newEmployee.getSex());
        oldEmployee.setBirthday(newEmployee.getBirthday());
        oldEmployee.setAdmition_date(newEmployee.getAdmition_date());
        oldEmployee.setDismissal_date(newEmployee.getDismissal_date());
        oldEmployee.setPost(newEmployee.getPost());
        oldEmployee.setSalary(newEmployee.getSalary());
        oldEmployee.setChief(newEmployee.getChief());
        oldEmployee.setDepartament(newEmployee.getDepartament());
        employeeRepository.save(oldEmployee);
    }

    public void updateEmployeesDepartment(Employee oldEmployee, String newDepartmemtName){
        oldEmployee.setDepartament(departmentService.findByName(newDepartmemtName));
        employeeRepository.save(oldEmployee);
    }

    public void dismissEmployee(Employee oldEmployee, Date demissDate){
        oldEmployee.setDismissal_date(demissDate);
        employeeRepository.save(oldEmployee);
    }
}
