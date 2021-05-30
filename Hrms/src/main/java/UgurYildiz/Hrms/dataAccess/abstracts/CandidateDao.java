package UgurYildiz.Hrms.dataAccess.abstracts;




import org.springframework.data.jpa.repository.JpaRepository;

import UgurYildiz.Hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	boolean existsByemail(String email);
	boolean existsByidentityNumber(String identityNumber);

	
}
 