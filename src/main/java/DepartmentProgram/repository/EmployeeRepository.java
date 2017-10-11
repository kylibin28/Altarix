package DepartmentProgram.repository;

import DepartmentProgram.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Макс on 11.10.2017.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
