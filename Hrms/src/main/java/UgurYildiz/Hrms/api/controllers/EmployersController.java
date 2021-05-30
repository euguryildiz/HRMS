package UgurYildiz.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UgurYildiz.Hrms.business.abstracts.EmployerService;
import UgurYildiz.Hrms.core.utilities.result.DataResult;
import UgurYildiz.Hrms.core.utilities.result.Result;
import UgurYildiz.Hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService)
	{
		super();
		this.employerService = employerService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getall(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
	
}
