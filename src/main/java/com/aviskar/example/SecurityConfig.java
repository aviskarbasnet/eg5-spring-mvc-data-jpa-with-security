package com.aviskar.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aviskar.example.model.User;
import com.aviskar.example.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				User user = SecurityConfig.this.userService.findOneByEmail(email);
				if (user == null)
					throw new UsernameNotFoundException("User with email [" + email + "] not found.");
				UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();
				return userBuilder.username(user.getEmail()).password(user.getPassword()).roles("USER").build();
			}
		};
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/static/**", "/login", "/sign-up").permitAll()
				.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login").permitAll()
		.and()
			.logout().permitAll().deleteCookies("JSESSIONID");
	}
}
