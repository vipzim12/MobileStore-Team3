package com.team3.app.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	  public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
	    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
	    jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
	    return jwtAuthenticationTokenFilter;
	  }
	  @Bean
	  public RestAuthenticationEntryPoint restServicesEntryPoint() {
	    return new RestAuthenticationEntryPoint();
	  }
	  @Bean
	  public CustomAccessDeniedHandler customAccessDeniedHandler() {
	    return new CustomAccessDeniedHandler();
	  }
	  @Bean
	  @Override
	  protected AuthenticationManager authenticationManager() throws Exception {
	    return super.authenticationManager();
	  }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
 
		http.csrf().disable();
		http.cors().and().authorizeRequests()
		.mvcMatchers("/auth/login").permitAll()
		.mvcMatchers("/pages/user/select").hasAuthority("ADMIN")
		.mvcMatchers("/pages/user/select/**").hasAnyAuthority("ADMIN","EMPLOYEE","USER")
		.mvcMatchers("/pages/user/insert").hasAuthority("ADMIN")
		.mvcMatchers("/pages/user/edit").hasAuthority("ADMIN")
		.mvcMatchers("/pages/user/delete/{id}").hasAuthority("ADMIN")
        .mvcMatchers("/pages/banner/**").hasAuthority("ADMIN");
        http.mvcMatcher("/pages/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
        .and().addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
 
    }

}
