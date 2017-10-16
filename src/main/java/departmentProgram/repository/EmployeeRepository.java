package departmentProgram.repository;

import departmentProgram.model.Department;
import departmentProgram.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by Макс on 11.10.2017.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "update employees set id_department = :new_department where id_department = :old_department", nativeQuery = true)
        //and e.chief =: false
    void updateAllEmployeesDepartment(@Param("old_department") int old_department, @Param("new_department") int new_department);

    @Query(value = "select * from employees e where e.id_department = :id_department", nativeQuery = true)
    List<Employee> findEmployeesInDepartment(@Param("id_department") int id_department);

    @Query(value = "select * from employees e where e.name = :nam and e.surname = :surname " +
            "and e.patronymic = :patronymic and e.birthday = :birthday", nativeQuery = true)
    List<Employee> findEmployeesByParameters(@Param("surname") String surname,
                                             @Param("nam") String name,
                                             @Param("patronymic") String patronymic,
                                             @Param("birthday") Date birthday);
}
