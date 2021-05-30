package UgurYildiz.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UgurYildiz.Hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{
	JobPosition findByJobTitle(String name);
}
