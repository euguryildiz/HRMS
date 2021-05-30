package UgurYildiz.Hrms.business.abstracts;

import java.util.List;

import UgurYildiz.Hrms.core.utilities.result.DataResult;
import UgurYildiz.Hrms.core.utilities.result.Result;
import UgurYildiz.Hrms.entities.concretes.Candidate;


public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getBynationalIdentity(String nationalIdentity);
	Result add(Candidate candidate);
}
