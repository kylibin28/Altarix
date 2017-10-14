package departmentProgram.repository;

import departmentProgram.model.Department;
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

    @Query(value = "select * from departments d where d.departament_name = :departament_name", nativeQuery = true)
    Department findByName(@Param("departament_name") String departament_name);

    @Query(value = "select * from departments d where d.name_main_department = :name_main_department", nativeQuery = true)
    List<Department> findSubDepartments(@Param("name_main_department") String name_main_department);

    @Query(value = "select sum(e.salary) from employees e where e.departament = :departament", nativeQuery = true)
    int departmentSalary(@Param("departament") int departament);

}
