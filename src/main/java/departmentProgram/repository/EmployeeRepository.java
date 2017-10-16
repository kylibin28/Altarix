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
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "update employees set departament = :new_department where departament = :old_department", nativeQuery = true) //and e.chief =: false
    void updateAllEmployeesDepartment(@Param("old_department") int old_department, @Param("new_department") int new_department);

    @Query(value = "select * from departments where id_department = " +
            "(Select id_department from employees  where id_employee = :id_employee)",
            nativeQuery = true)//e.id_employee = :id_employee
    int findChief(@Param("id_employee") int id_employee);

    @Query(value = "Select id_department from employees where id_employee = :id_employee",
            nativeQuery = true)
    int findEmployeesDepartment(@Param("id_employee") int id_employee);


}
