package departmentProgram.service;

import departmentProgram.model.Employee;
import departmentProgram.repository.DepartmentRepository;
import departmentProgram.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee findEmployeeById(int employeeID) {
        return employeeRepository.findOne(employeeID);
    }

    public void updateEmployee(Employee oldEmployee, Employee newEmployee) {
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

    public void updateEmployeesDepartment(Employee oldEmployee, String newDepartmemtName) {
        oldEmployee.setDepartament(departmentService.findDepartmentByDepartment_name(newDepartmemtName));
        employeeRepository.save(oldEmployee);
    }

    public void dismissEmployee(Employee employee, Date demissDate) {
        employee.setDismissal_date(demissDate);
        employeeRepository.save(employee);
    }

    @Transactional
    public void changeDepartment(String oldDepartmentName, String newDepartmemtName) {
        employeeRepository.updateAllEmployeesDepartment(
                departmentService.findDepartmentByDepartment_name(oldDepartmentName).getId_department(),
                departmentService.findDepartmentByDepartment_name(newDepartmemtName).getId_department()
        );
    }

    public Employee findChiefOfEmployee(Employee employee) {
        return findEmployeeById(departmentService.findChiefEmployee(employee.getId_employee()));
    }
}
