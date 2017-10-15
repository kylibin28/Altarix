package departmentProgram;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import departmentProgram.service.DepartmentService;
import departmentProgram.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @Test
    public void add() {

        departmentService.save(new Department(
                "First",
                new Date(2008 - 1900, 12, 7),
                null)
        );

        departmentService.save(new Department(
                "Second",
                new Date(2010 - 1900, 6, 10),
                "First")
        );


//        employeeService.save(new Employee(
//                "Крикунов",
//                "Леонид",
//                "Викторович",
//                "Мужской",
//                new Date(1995 - 1900, 03, 3),
//                new Date(2010 - 1900, 10, 10),
//                null,
//                "Директор",
//                45000,
//                false,
//                departmentService.findByName("Six"))
//        );
//
//        employeeService.save(new Employee(
//                "Селиверстов",
//                "Геннадий",
//                "Александрович",
//                "Мужской",
//                new Date(1985 - 1900, 8, 16),
//                new Date(2012 - 1900, 10, 10),
//                null,
//                "Руководитель",
//                50000,
//                true,
//                departmentService.findByName("Six"))
//        );


    }

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.findAll();
        for (Department department : departmentList) {
            System.out.println(department.toString());
        }

        List<Employee> employeeList = employeeService.findAll();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

    }


    @Test
    public void select() {
//
//        Employee emp = employeeService.findChief(employeeService.findById(6));
//        System.out.println("Chief-"+emp.toString());
//
//        Department dep = departmentService.findByName("First");
//        System.out.println(dep.toString());

//        List<Employee> employeeList = employeeService.findEmployeesInDepartment("Six");
//        for (Employee employee : employeeList) {
//            System.out.println(employee.toString());
//        }

//        System.out.println("salary=" + departmentService.departmentSalary("Six"));

//        List<Department> departmentList = departmentService.findSubDepartments("Six");
//        for (Department department : departmentList) {
//            System.out.println(department.toString());
//        }
//
//
 List<Department> departmentList = departmentService.findAllMainDepartments("Six");
        for (Department department : departmentList) {
            System.out.println(department.toString());
        }
    }

    @Test
    public void update() {
        departmentService.updateChiefEmployee(
                departmentService.findByName("Six"),
                employeeService.findById(4));
//        employeeService.updateAllEmployeesDepartment("Six", "Seven");

//        departmentService.updateMainDepartment(departmentService.findByName("New"),"Six");
//        Employee employee = employeeService.findById(3);
//        Employee emp = employeeService.findById(3);
////        employeeService.updateEmployeesDepartment(emp, "Seven");
//        employeeService.dismissEmployee(emp, new Date(2015,10,18));
//
//        employeeService.updateEmployee(employee, new Employee(
//                "Сальников",
//                "Михаил",
//                "Александрович",
//                "Мужской",
//                new Date(1985 - 1900, 8, 16),
//                new Date(2012 - 1900, 10, 10),
//                null,
//                "Менеджер",
//                25000,
//                false,
//                departmentService.findById(1))
//        );
    }

    @Test
    public void delete() {
        employeeService.delete(employeeService.findById(3));
        employeeService.delete(employeeService.findById(4));
    }
}
