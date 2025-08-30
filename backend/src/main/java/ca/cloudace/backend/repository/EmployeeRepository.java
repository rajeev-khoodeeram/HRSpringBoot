package ca.cloudace.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ca.cloudace.backend.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 // necessary to implement custom methods
}
