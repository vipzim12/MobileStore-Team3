package com.team3.app.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {
	private final static String TOKEN_HEADER = "authorization";
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserDetailsService userService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(TOKEN_HEADER);
		if (jwtService.validateTokenLogin(authToken)) {
			String username = jwtService.getUsernameFromToken(authToken);
			UserDetails user = userService.loadUserByUsername(username);
			if (user != null) {
				boolean enabled = true;
				boolean accountNonExpired = true;
				boolean credentialsNonExpired = true;
				boolean accountNonLocked = true;
				UserDetails userDetail = new User(username, user.getPassword(), enabled, accountNonExpired,
						credentialsNonExpired, accountNonLocked, user.getAuthorities());
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail,
						null, userDetail.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			System.out.println("\nInformation about " + jwtService.getUsernameFromToken(authToken) + "'s connection");
			Enumeration<String> a = httpRequest.getHeaderNames();
			while (a.hasMoreElements()) {
				String x = a.nextElement();
				System.out.println(x + " : " + httpRequest.getHeader(x));
			}
			System.out.println("\n");
		}
		chain.doFilter(request, response);
	}
}
