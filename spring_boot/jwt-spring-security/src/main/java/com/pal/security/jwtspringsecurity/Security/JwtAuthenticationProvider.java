package com.pal.security.jwtspringsecurity.Security;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.pal.security.jwtspringsecurity.model.JwtAuthenticationToken;
import com.pal.security.jwtspringsecurity.model.JwtUser;
import com.pal.security.jwtspringsecurity.model.JwtUserDetails;
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{


	@Autowired
	private JwtValidator validator;
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken)
			throws AuthenticationException {
		
		JwtAuthenticationToken jwtAuthenticationToken=(JwtAuthenticationToken) usernamepasswordauthenticationtoken;
		String token=jwtAuthenticationToken.getToken();
		JwtUser jwtuser=validator.validate(token);
		if(jwtuser==null) {
			throw new RuntimeException("JwtToken is not incorrect");
		}
		List<GrantedAuthority> grantAuthorities=AuthorityUtils.commaSeparatedStringToAuthorityList(jwtuser.getRole());
		return new JwtUserDetails(jwtuser.getUsername(),token,
				jwtuser.getId(),
				grantAuthorities);
		
		
	}

}
