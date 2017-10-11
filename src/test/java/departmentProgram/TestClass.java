package departmentProgram;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.repository.DepartmentRepository;
import departmentProgram.repository.EmployeeRepository;
import departmentProgram.service.DepartmentService;
import departmentProgram.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClass {

    @Autowired
    private EmployeeRepository employeeService;
    @Autowired
    private DepartmentRepository departmentService;

    @Test
    public void add() {
        Department dep = new Department(
                "New",
                new Date(2000 - 1900, 5, 8),
                "");
        departmentService.save(dep);

        employeeService.save(new Employee(
                "Борисевич",
                "Илья",
                "Александрович",
                "Мужской",
                new Date(1995 - 1900, 04, 04),
                new Date(2010 - 1900, 05, 04),
                null,
                "Директор",
                40000,
                true,
                departmentService.findOne(1)));


    }

    @Test
    public void select() {
        List<Department> departmentList = departmentService.findAll();
        for (Department department : departmentList) {
            System.out.println(department.toString());
        }

        List<Employee> employeeList = employeeService.findAll();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

    }
}
