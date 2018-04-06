package com.marcin.product.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select app_username as login, user_password as password, true as enabled from app_user where app_username=?")
        .authoritiesByUsernameQuery("select app_username as login, authority as 'ROLE_USER' from app_user where app_username=?");
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//		.withUser(users.username("marcin").password("pass").roles("USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/","/loginForm").permitAll().and().formLogin().loginPage("/loginForm");
//		http.authorizeRequests().anyRequest().authenticated()
//			.and().formLogin()
//			.loginPage("/loginForm")
//			.loginProcessingUrl("/verifyUserData")
//			.defaultSuccessUrl("/main")
//			.permitAll();
	}

	
}
