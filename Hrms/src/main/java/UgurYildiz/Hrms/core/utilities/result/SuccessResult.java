package UgurYildiz.Hrms.core.utilities.result;

public class SuccessResult extends Result {

	public SuccessResult(boolean success) {
		super(true);
	}
	
	public SuccessResult(boolean success, String message) {
		super(true,message);
	}

}
