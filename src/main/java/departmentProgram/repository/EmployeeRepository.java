package departmentProgram.repository;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employees e where e.departament = :departament", nativeQuery = true)
    List<Employee> findEmployeesInDepartment(@Param("departament") int departament);
}
