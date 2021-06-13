package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.auth.handler.LoginSuccessHandler;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;
@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	protected void configure(HttpSecurity http) throws Exception{
		try {
			http.authorizeRequests()
				.antMatchers("/departamento/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/provincia/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/transporte/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/hotel/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/restaurante/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/alojamiento/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/alquilerAuto/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/turista/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_TURISTA')")
				.antMatchers("/reservaviaje/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_TURISTA')")
				.antMatchers("/comentario/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_TURISTA')")
				.antMatchers("/welcome/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_TURISTA')").and()
				.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/welcome/bienvenido")
				.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
				
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}
