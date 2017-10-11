package departmentProgram;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.service.DepartmentService;
import departmentProgram.service.EmployeeService;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
public class TestClass {

    EmployeeService employeeService;
    DepartmentService departmentService;

    @Test
    private void add(){
        departmentService.save(new Department(
                "First",
                new Date(2000,10,5),
                ""));

        employeeService.save(new Employee(
                "Борисевич",
                "Илья",
                "Александрович",
                "Мужской",
                new Date(1995,04,04),
                new Date(2010,05,04),
                null,
                "Директор",
                40000,
                true,
                new Department()));


    }

    @Test
    private void select(){
        List<Department> departmentList = departmentService.findAll();
        for (Department department : departmentList){
            System.out.println(department.toString());
        }

        List<Employee> employeeList = employeeService.findAll();
        for (Employee employee : employeeList){
            System.out.println(employee.toString());
        }

    }
}
