package com.sparta.engineering72.sakilaproject.securingweb;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.entities.Staff;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import com.sparta.engineering72.sakilaproject.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StaffService staffService;

    @Override
    protected void configure(HttpSecurity http) throws Exception { //Defines which URL paths should be secured and which should not
        http
                .authorizeRequests()
                .antMatchers(
                "/",
                            "/home",
                            "/webjars/**",
                            "/css/**",
                            "/films/**",
                            "/actors/**",
                            "/categories/**"
                            ).permitAll() //Do not require authentication
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
        return new InMemoryUserDetailsManager(getUserDetailsList());
    }

    private List<UserDetails> getUserDetailsList() {
        List<Customer> customers = customerService.getAllCustomers();
        List<UserDetails> users = new ArrayList<>();
        List<Staff> staff = staffService.getAllStaff();

        UserDetails user;

        for (Customer customer : customers) {
            user =
                    User.builder()
                            .username(customer.getEmail())
                            .password(String.valueOf(customer.getCustomerId()))
                            .roles("USER")
                            .build();
            users.add(user);
        }

        for (Staff staffMember : staff) {
            user =
                    User.builder()
                            .username(staffMember.getUsername())
                            .password(staffMember.getPassword())
                            .roles("ADMIN")
                            .build();
            users.add(user);
        }

        return users;
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
        List<Staff> staff = staffService.getAllStaff();

        for (Customer customer : customers) {
            auth.inMemoryAuthentication()
                    .withUser(customer.getEmail()).password("{noop}"+customer.getCustomerId()+"").roles("USER");
        }

        for (Staff staffMember : staff) {
            auth.inMemoryAuthentication()
                    .withUser(staffMember.getUsername()).password("{noop}"+staffMember.getPassword()+"").roles("ADMIN");
        }
    }
}