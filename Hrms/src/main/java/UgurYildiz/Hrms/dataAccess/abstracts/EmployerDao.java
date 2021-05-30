package UgurYildiz.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UgurYildiz.Hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	boolean existsByemail(String email);

}
