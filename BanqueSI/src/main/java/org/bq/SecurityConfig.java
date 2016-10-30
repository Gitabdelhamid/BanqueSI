package org.bq;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN", "DBA");
		auth.inMemoryAuthentication().withUser("user").password("123").roles("ET");
		auth.inMemoryAuthentication().withUser("prof").password("123").roles("PROF");
		// auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select
		// username as principal,"
		// + " password as credentials, true from users where username = ?")
		// .authoritiesByUsernameQuery("select users_username as principal,"
		// + " roles_role as role from users_roles where users_username = ?")
		// .rolePrefix("ROLE_");
	}

	// Cc'est la on ajoute les regles de la securite
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.csrf().disable().authorizeRequests().antMatchers("/css/**",
	// "/js/**", "/images/**").permitAll()
	// .anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/index.html")
	// .failureUrl("/login").permitAll().and().logout().invalidateHttpSession(true).logoutUrl("/logout")
	// .permitAll();
	// }

}
