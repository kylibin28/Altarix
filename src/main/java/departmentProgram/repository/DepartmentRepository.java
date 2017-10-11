package departmentProgram.repository;

import departmentProgram.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Макс on 11.10.2017.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
