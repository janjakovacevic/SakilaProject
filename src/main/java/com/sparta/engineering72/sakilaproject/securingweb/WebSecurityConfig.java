package com.sparta.engineering72.sakilaproject.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity //Enables Spring Security’s web security support and provide the Spring MVC integration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception { //Defines which URL paths should be secured and which should not
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll() //Do not require authentication
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll() //Custom login page; Everyone is allowed to view
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() { //In-memory user store with a single user
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}