package com.sparta.engineering72.sakilaproject.securingweb;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.respositories.CustomerRepository;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerService customerService;

    @Override
    protected void configure(HttpSecurity http) throws Exception { //Defines which URL paths should be secured and which should not
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/webjars/**", "/css/**").permitAll() //Do not require authentication
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
    public UserDetailsService userDetailsService() { //In-memory user store

        List<Customer> customers = customerService.getAllCustomers();
        List<UserDetails> users = new ArrayList<>();

        UserDetails user =
                User.builder()
                        .username("user")
                        .password("password")
                        .roles("ADMIN")
                        .build();

        users.add(user);

        for (Customer customer : customers) {
            user =
                    User.builder()
                            .username(customer.getEmail())
                            .password(String.valueOf(customer.getCustomerId()))
                            .roles("USER")
                            .build();
            users.add(user);
        }

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        List<Customer> customers = customerService.getAllCustomers();

        for (Customer customer : customers) {
            auth.inMemoryAuthentication()
                    .withUser(customer.getEmail()).password("{noop}"+customer.getCustomerId()+"").roles("USER")
                    .and()
                    .withUser("admin").password("{noop}password").roles("ADMIN");
        }
    }


}