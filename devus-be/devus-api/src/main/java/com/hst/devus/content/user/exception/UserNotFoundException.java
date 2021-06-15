package com.hst.devus.content.user.exception;

import com.hst.devus.content.user.type.UserOauthType;
import com.hst.devus.exceptionhandling.exception.NotFoundException;

/**
 * @author dlgusrb0808@gmail.com
 */
public class UserNotFoundException extends NotFoundException {

	public UserNotFoundException(Long invalidUserNo) {
		super(UserBusinessExceptionStatus.USER_NOT_FOUND);
		addAttribute("userNo", invalidUserNo);
	}

	public UserNotFoundException(String invalidUsname) {
		super(UserBusinessExceptionStatus.USER_NOT_FOUND);
		addAttribute("usname", invalidUsname);
	}

	public UserNotFoundException(String email, UserOauthType oAuthType) {
		super(UserBusinessExceptionStatus.USER_NOT_FOUND);
		addAttribute("email", email);
		addAttribute("oAuthType", oAuthType);
	}
}
