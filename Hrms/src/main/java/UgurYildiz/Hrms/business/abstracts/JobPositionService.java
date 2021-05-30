package UgurYildiz.Hrms.business.abstracts;
import java.util.List;

import UgurYildiz.Hrms.core.utilities.result.DataResult;
import UgurYildiz.Hrms.core.utilities.result.Result;
import UgurYildiz.Hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
    DataResult<JobPosition> getByjobTitle(String jobTitle);

}
