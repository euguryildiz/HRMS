package UgurYildiz.Hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UgurYildiz.Hrms.business.abstracts.EmployerService;
import UgurYildiz.Hrms.business.constants.Messages;
import UgurYildiz.Hrms.core.utilities.result.DataResult;
import UgurYildiz.Hrms.core.utilities.result.ErrorResult;
import UgurYildiz.Hrms.core.utilities.result.Result;
import UgurYildiz.Hrms.core.utilities.result.SuccessDataResult;
import UgurYildiz.Hrms.core.utilities.result.SuccessResult;
import UgurYildiz.Hrms.dataAccess.abstracts.EmployerDao;
import UgurYildiz.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(Messages.EMPLOYER_SUCCESS_DATA_LISTED,employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {

		
		if(employer.getCompanyName().isEmpty())
			return new ErrorResult(false,Messages.EMPLOYER_ERROR_COMPANY_NAME_IS_BLANK);
		if(employer.getEmail().isEmpty())
			return new ErrorResult(false,Messages.EMPLOYER_ERROR_EMAIL_IS_BLANK);
		if(employer.getWebAddress().isEmpty())
			return new ErrorResult(false,Messages.EMPLOYER_ERROR_WEBSITE_IS_BLANK);
		if(employer.getPhoneNumber().isEmpty())
			return new ErrorResult(false,Messages.EMPLOYER_ERROR_TELEPHONE_IS_BLANK);
		if(!checkDomain(employer.getEmail(),employer.getWebAddress()))
			return new ErrorResult(false,Messages.EMPLOYER_ERROR_EMAIL_MAIL_EXTENSION);
		 if(this.employerDao.existsByemail(employer.getEmail()))
			 return new ErrorResult(false, Messages.EMPLOYER_ERROR_EMAIL_ALREADY_EXISTS);
		 employerDao.save(employer);
		 return new SuccessResult(true,Messages.EMPLOYER_SUCCESS_ADDED);
	}
	
	
	
	private boolean checkDomain(String email, String website) {
		String websiteDomain;
		if (website.contains("www")) {
			int domainStartIndex = website.indexOf("www.");
			websiteDomain = website.substring(domainStartIndex + 4);
		} else {
			websiteDomain = website;
		}
		String emailDomain = email.substring(email.indexOf('@') + 1);
		if (emailDomain.equals(websiteDomain)) {
			return true;
		}
		return false;
	}

}
