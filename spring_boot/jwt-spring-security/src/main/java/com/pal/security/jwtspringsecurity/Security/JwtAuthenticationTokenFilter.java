package com.pal.security.jwtspringsecurity.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.pal.security.jwtspringsecurity.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{
	
	public JwtAuthenticationTokenFilter() {
		super("/rest/**");
	}
	
//	
//	private AuthenticationManager authenticationManager;
//	private JwtSuccessHandler authenticationSuccessHandler;
//	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
//		// TODO Auto-generated method stub
//		this.authenticationManager=authenticationManager;
//		
//	}
//	public void setAuthenticationManager(JwtSuccessHandler jwtSuccessHandler) {
//		// TODO Auto-generated method stub
//		this.authenticationSuccessHandler=authenticationSuccessHandler;
//	}

	


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String  header=request.getHeader("Authorisation");
		if(header==null||!header.startsWith("Token ")) {
			throw new RuntimeException("Jwt Token is missing");
		}
		
		String authentication=header.substring(6);
		JwtAuthenticationToken token =new JwtAuthenticationToken(authentication);
		
		
		return getAuthenticationManager().authenticate(token);
		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.successfulAuthentication(request, response, chain, authResult);
		
		chain.doFilter(request, response);
		
	}
	
	
	
}
