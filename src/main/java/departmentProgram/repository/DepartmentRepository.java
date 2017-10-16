package departmentProgram.repository;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(value = "select * from departments d where d.department_name = :department_name", nativeQuery = true)
    Department findDepartmentByDepartmentName(@Param("department_name") String department_name);

    @Query(value = "select * from departments d where d.name_main_department = :name_main_department", nativeQuery = true)
    List<Department> findSubDepartments(@Param("name_main_department") String name_main_department);

    @Query(value = "select sum(e.salary) from employees e where e.id_department = :id_department", nativeQuery = true)
    int departmentSalary(@Param("id_department") int id_department);

    @Query(value = "Select chief_employee from departments where id_department = " +
            "(Select id_department from employees where id_employee = :id_employee)", nativeQuery = true)
    int findChiefEmployee(@Param("id_employee") int id_employee);

}
