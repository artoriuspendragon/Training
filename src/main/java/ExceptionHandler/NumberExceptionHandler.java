package ExceptionHandler;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class NumberExceptionHandler {
	public String handleNumberFormatException(NumberFormatException e) {
	//add error for view here
		return "«Î ‰»Î ˝◊÷£°";
	}
}
