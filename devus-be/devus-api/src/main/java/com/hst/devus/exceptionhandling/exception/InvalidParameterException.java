package com.hst.devus.exceptionhandling.exception;

import org.springframework.http.HttpStatus;

import com.hst.devus.exceptionhandling.model.BusinessExceptionStatus;

/**
 * @author dlgusrb0808@gmail.com
 */
public class InvalidParameterException extends ApplicationException {

	public InvalidParameterException(BusinessExceptionStatus exceptionStatus) {
		super(HttpStatus.BAD_REQUEST, exceptionStatus);
	}

}
