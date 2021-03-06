package com.hst.devus.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hst.devus.configuration.props.ApplicationProperties;
import com.hst.devus.content.user.entity.User;
import com.hst.devus.content.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dlgusrb0808@gmail.com
 */
@RequiredArgsConstructor
@Slf4j
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private final PathMatcher matcher = new AntPathMatcher();
	private final ApplicationProperties applicationProperties;
	private final UserService userService;
	private final AuthenticationTokenProvider authenticationTokenProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws IOException, ServletException {
		String token = getTokenFromRequest(request);
		if (authenticationTokenProvider.validateToken(token)) {
			Long userNo = authenticationTokenProvider.getUserNoFromToken(token);
			User user = userService.loadUserByUsername(String.valueOf(userNo));
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
				user.getPassword(), user.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} else {
			log.error(String.format("Token Authentication failed.%sClient IP: %s%sEndpoint: %s%sRequested token: %s",
				System.lineSeparator(), request.getRemoteAddr(), System.lineSeparator(), request.getRequestURI(),
				System.lineSeparator(), token));
		}
		filterChain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
		for (String publicPath : applicationProperties.getSecurity().getMergedPublicPaths()) {
			if (matcher.match(publicPath, requestPath)) {
				return true;
			}
		}
		return false;
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

}
