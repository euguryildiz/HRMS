package UgurYildiz.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UgurYildiz.Hrms.business.abstracts.JobPositionService;
import UgurYildiz.Hrms.core.utilities.result.DataResult;
import UgurYildiz.Hrms.core.utilities.result.ErrorResult;
import UgurYildiz.Hrms.core.utilities.result.Result;
import UgurYildiz.Hrms.core.utilities.result.SuccessDataResult;
import UgurYildiz.Hrms.core.utilities.result.SuccessResult;
import UgurYildiz.Hrms.dataAccess.abstracts.JobPositionDao;
import UgurYildiz.Hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>("Job Position List",this.jobPositionDao.findAll());
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(getByjobTitle(jobPosition.getJobTitle()).getData() != null) {
			return new ErrorResult(false, "This already exists");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(true, "Job Position Added");
	}

	@Override
	public DataResult<JobPosition> getByjobTitle(String jobTitle) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByJobTitle(jobTitle));

	}

}
