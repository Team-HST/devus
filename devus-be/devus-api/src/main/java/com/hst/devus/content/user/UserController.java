package com.hst.devus.content.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hst.devus.configurations.ApplicationProperties;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
public class UserController {

	@Autowired
	private ApplicationProperties applicationProperties;

	@Value("${app.security.token-secret}")
	private String aa;

	@GetMapping
	public Object greeting() {
		return "adskdsalkmasdlkm" + applicationProperties.getSecurity();
	}

}
