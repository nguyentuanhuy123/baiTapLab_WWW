package iuh.fit.se.lab08bai1.repositories;

import iuh.fit.se.lab08bai1.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
