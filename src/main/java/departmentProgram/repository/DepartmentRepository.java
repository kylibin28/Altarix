package departmentProgram.repository;

import departmentProgram.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Макс on 11.10.2017.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

//    @Query("select departament_name from departments d where d.departament_name = :departament_name")
//    Department findByName(@Param("departament_name") String departament_name);
}
