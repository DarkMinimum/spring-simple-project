package ua.darkminimum.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.darkminimum.entities.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
}
