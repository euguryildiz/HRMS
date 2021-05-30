package UgurYildiz.Hrms.business.abstracts;

import java.util.List;

import UgurYildiz.Hrms.core.utilities.result.DataResult;
import UgurYildiz.Hrms.core.utilities.result.Result;
import UgurYildiz.Hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer candidate);
}
