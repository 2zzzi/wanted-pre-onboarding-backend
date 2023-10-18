package wanted.wantedpreonboardingbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.wantedpreonboardingbackend.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmpId(Long id);

}
