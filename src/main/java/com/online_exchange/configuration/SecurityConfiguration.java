package com.online_exchange.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	RedirectConfiguration RedirectConfiguration;
	
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	  	//.antMatchers("/", "/home").permitAll()
	  	.antMatchers("/", "/home").access("hasRole('CLIENT')")
	  	.antMatchers("/exchanger/**").access("hasRole('EXCHANGER')")
	  	.antMatchers("/db/**").access("hasRole('EXCHANGER') and hasRole('ADMINISTRATOR')")
	  	//.and().formLogin().loginPage("/login")
	  	.and().formLogin().loginPage("/login").successHandler(RedirectConfiguration)
	  	.usernameParameter("ssoId").passwordParameter("password")
	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied");
                http.authorizeRequests().and().csrf().disable();//GODAWFUL THING SHOULD BE DISABLED AT ALL TIMES
	}

}
