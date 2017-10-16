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

        departmentService.saveDepartment(new Department(
                "First",
                new Date(2008 - 1900, 12, 7),
                null)
        );

        departmentService.saveDepartment(new Department(
                "Second",
                new Date(2010 - 1900, 6, 10),
                "First")
        );


        employeeService.saveEmployee(new Employee(
                "Веселов",
                "Константин",
                "Викторович",
                "Мужской",
                new Date(1995 - 1900, 03, 3),
                new Date(2010 - 1900, 10, 10),
                null,
                "Директор",
                45000,
                false,
                departmentService.findDepartmentByDepartmentName("First"))
        );

        employeeService.saveEmployee(new Employee(
                "Васильева",
                "Татьяна",
                "Константиновна",
                "Мужской",
                new Date(1985 - 1900, 8, 16),
                new Date(2012 - 1900, 10, 10),
                null,
                "Руководитель",
                50000,
                true,
                departmentService.findDepartmentByDepartmentName("Second"))
        );

        employeeService.saveEmployee(new Employee(
                "Шеремеев",
                "Максим",
                "Владимирович",
                "Мужской",
                new Date(1985 - 1900, 8, 16),
                new Date(2012 - 1900, 10, 10),
                null,
                "Руководитель",
                50000,
                false,
                departmentService.findDepartmentByDepartmentName("Second"))
        );


    }

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.findAllDepartments();
        for (Department department : departmentList) {
            System.out.println(department.toString());
        }

        List<Employee> employeeList = employeeService.findAllEmployees();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

    }


    @Test
    public void select() {


        List<Employee> employeeList =  employeeService.findEmployeesByParameters("Шеремеев",
                "Максим",
                "Владимирович", new Date(1985 - 1900, 8, 16));
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
//
//        Employee emp = employeeService.findChiefOfEmployeeById(5);
//        System.out.println("Chief-" + emp.toString());
//
//
//        Department dep = departmentService.findDepartmentByDepartmentName("First");
//        System.out.println(dep.toString());

//        List<Employee> employeeList = employeeService.findEmployeesInDepartment("First");
//        for (Employee employee : employeeList) {
//            System.out.println(employee.toString());
//        }

//        System.out.println("salary=" + departmentService.departmentSalary("Second"));

//        List<Department> departmentList = departmentService.findSubDepartments("Six");
//        for (Department department : departmentList) {
//            System.out.println(department.toString());
//        }
//
//
//        List<Department> departmentList = departmentService.findAllMainDepartments("Second");
//        for (Department department : departmentList) {
//            System.out.println(department.toString());
//        }
    }

    @Test
    public void update() {
        employeeService.changeDepartment("Second", "First");

//        departmentService.updateChiefEmployee(
//                departmentService.findDepartmentByDepartmentName("Second"),
//                employeeService.findEmployeeById(3));


//        employeeService.changeDepartment("Six", "Seven");

//        departmentService.updateMainDepartment(
//                departmentService.findDepartmentByDepartmentName("Second"),
//                "First");
//        Employee employee = employeeService.findEmployeeById(3);

//        Employee emp = employeeService.findEmployeeById(5);
//        employeeService.updateEmployeesDepartment(emp, "First");

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
//                departmentService.findEmployeeById(1))
//        );
    }

    @Test
    public void delete() {
        employeeService.deleteEmployee(employeeService.findEmployeeById(3));
        employeeService.deleteEmployee(employeeService.findEmployeeById(4));
    }
}
