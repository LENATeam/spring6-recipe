package com.apress.spring6recipes.board.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class TodoSecurityConfig {

		@Bean
		public UserDetailsManager userDetailsService() {
				var user = User.withDefaultPasswordEncoder().username("user").password("user").authorities("USER").build();
				var admin = User.withDefaultPasswordEncoder().username("admin").password("admin").authorities("USER", "ADMIN").build();
				return new InMemoryUserDetailsManager(user, admin);
		}

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http)
						throws Exception {
				http.csrf().csrfTokenRepository(csrfTokenRepository());
				http.formLogin(Customizer.withDefaults());
				http.authorizeHttpRequests(auth -> auth
					.requestMatchers(new AntPathRequestMatcher("/todos", "GET")).hasAuthority("USER")
					.requestMatchers(new AntPathRequestMatcher("/todos/*", "GET")).hasAuthority("USER")
					.requestMatchers(new AntPathRequestMatcher("/todos/*", "DELETE")).hasAuthority("ADMIN"));
				return http.build();
		}

		private CookieCsrfTokenRepository csrfTokenRepository() {
				return new CookieCsrfTokenRepository();
		}
}
