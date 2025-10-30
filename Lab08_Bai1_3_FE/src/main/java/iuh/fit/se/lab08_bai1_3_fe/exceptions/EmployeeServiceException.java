package iuh.fit.se.lab08_bai1_3_fe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeServiceException extends RuntimeException {

	public EmployeeServiceException(String message) {
		super(message);
	}
}
