package com.pal.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		UserBuilder users = User.withDefaultPasswordEncoder();
//
//		auth.inMemoryAuthentication().withUser(users.username("sanjeet").password("pal").roles("Employee","MANAGER"));
//		auth.inMemoryAuthentication().withUser(users.username("sagar").password("negi").roles("Employee"));
//		auth.inMemoryAuthentication().withUser(users.username("saurab").password("sparrow").roles("Employee","ADMIN"));
//		

		auth.jdbcAuthentication().dataSource(securityDataSource);
		//password john:fun123
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}
}
