package com.sparta.engineering72.sakilaproject.securingweb;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.respositories.CustomerRepository;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.getCustomerByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(email);
        builder.password(new BCryptPasswordEncoder().encode((customer.getFirstName() + customer.getLastName()).toLowerCase()));
        builder.roles("USER");
        return builder.build();
    }
}
