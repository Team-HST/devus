package com.hst.devus.configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hst.devus.configuration.props.ApplicationProperties;
import com.hst.devus.exceptionhandling.model.ExceptionDescription;
import com.hst.devus.security.TokenAuthenticationFilter;
import com.hst.devus.utils.JsonUtils;

import lombok.RequiredArgsConstructor;

/**
 * @author dlgusrb0808@gmail.com
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final ApplicationProperties applicationProperties;
	private final TokenAuthenticationFilter tokenAuthenticationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
				.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.csrf()
				.disable()
			.formLogin()
				.disable()
			.httpBasic()
				.disable()
			.authorizeRequests()
				.antMatchers(applicationProperties.getSecurity().getMergedPublicPaths().toArray(new String[0]))
					.permitAll()
				.anyRequest()
					.authenticated()
				.and()
			.exceptionHandling()
				.authenticationEntryPoint(new RestAuthenticationEntryPoint())
		;
		http.addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	public static class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
			authException.printStackTrace();
			HttpStatus responseStatus = HttpStatus.UNAUTHORIZED;
			response.setStatus(responseStatus.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding(StandardCharsets.UTF_8.name());
			response.getWriter()
				.write(JsonUtils.serialize(
					ExceptionDescription.of(responseStatus.value(), authException.getClass().getName(),
						authException.getLocalizedMessage())));
		}

	}
}
