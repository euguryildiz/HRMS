package UgurYildiz.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import UgurYildiz.Hrms.business.abstracts.CandidateService;
import UgurYildiz.Hrms.core.utilities.result.DataResult;
import UgurYildiz.Hrms.core.utilities.result.ErrorResult;
import UgurYildiz.Hrms.core.utilities.result.Result;
import UgurYildiz.Hrms.core.utilities.result.SuccessDataResult;
import UgurYildiz.Hrms.core.utilities.result.SuccessResult;
import UgurYildiz.Hrms.dataAccess.abstracts.CandidateDao;
import UgurYildiz.Hrms.entities.concretes.Candidate;
import UgurYildiz.Hrms.business.constants.Messages;


@Service
public class CandidateManager implements CandidateService {

	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao)
	{
		this.candidateDao = candidateDao;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>("All Employee List",this.candidateDao.findAll());

	}

	@Override
	public DataResult<Candidate> getBynationalIdentity(String nationalIdentity) {
		return null;
	}

	@Override
	public Result add(Candidate candidate) {
        if (candidate.getFirstName().isEmpty())
            return new ErrorResult(false,Messages.CANDIDATE_ERROR_NAME_IS_BLANK);
        if (candidate.getLastName().isEmpty())
            return new ErrorResult(false,Messages.CANDIDATE_ERROR_SURNAME_IS_BLANK);
        if (candidate.getEmail().isEmpty())
            return new ErrorResult(false,Messages.USER_ERROR_EMAIL_IS_BLANK);
        if (candidate.getPassword().isEmpty())
            return new ErrorResult(false,Messages.USER_ERROR_PASSWORD_IS_BLANK);
        if (candidate.getIdentityNumber().isEmpty())
            return new ErrorResult(false,Messages.CANDIDATE_ERROR_IDENTITY_NUMBER_IS_BLANK);
        if (this.candidateDao.existsByemail(candidate.getEmail()))
            return new ErrorResult(false,Messages.USER_ERROR_EMAIL_ALREADY_EXISTS);
        if (this.candidateDao.existsByidentityNumber(candidate.getIdentityNumber()))
            return new ErrorResult(false,Messages.CANDIDATE_ERROR_IDENTITY_NUMBER_ALREADY_EXISTS);

        this.candidateDao.save(candidate);
        return new SuccessResult(true,Messages.CANDIDATE_SUCCESS_ADDED);


	}

}
