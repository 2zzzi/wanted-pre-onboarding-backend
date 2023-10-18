package wanted.wantedpreonboardingbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.wantedpreonboardingbackend.entity.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByCompanyId(Long id);
}
