package com.sparta.engineering72.sakilaproject.securingweb;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.entities.Staff;
import com.sparta.engineering72.sakilaproject.respositories.CustomerRepository;
import com.sparta.engineering72.sakilaproject.respositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AnyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String anyUsername) throws UsernameNotFoundException {
//        Customer customer = customerRepository.getCustomerByEmail(anyUsername);
//        Staff staff = staffRepository.getStaffByUsername(anyUsername);
//
//        if(customer == null && staff == null) {
//            throw new UsernameNotFoundException("Could not find user");
//        } else {
//            User.UserBuilder builder = null;
//            if(customer == null && staff != null){
//                builder = org.springframework.security.core.userdetails.User.withUsername(anyUsername);
//                builder.password(new BCryptPasswordEncoder().encode((staff.getFirstName() + staff.getLastName()).toLowerCase()));
//                builder.roles("ADMIN");
//                return builder.build();
//            }
////            if(staff == null && customer != null){
////                builder = org.springframework.security.core.userdetails.User.withUsername(anyUsername);
////                builder.password(new BCryptPasswordEncoder().encode((customer.getFirstName() + customer.getLastName()).toLowerCase()));
////                builder.roles("USER");
////                return builder.build();
////            }
//            else{
//                builder = org.springframework.security.core.userdetails.User.withUsername(anyUsername);
//                builder.password(new BCryptPasswordEncoder().encode((customer.getFirstName() + customer.getLastName()).toLowerCase()));
//                builder.roles("USER");
//                return builder.build();
//            }
//        }

        return null;
    }
}
