package com.hst.devus.security;

import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@Builder
public class UserAuthenticationToken {

	private final Long userNo;
	private final String token;

}
