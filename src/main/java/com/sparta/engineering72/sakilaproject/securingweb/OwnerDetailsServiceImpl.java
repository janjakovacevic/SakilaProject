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
public class OwnerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffRepository.getStaffByUsername(username);
        if(staff == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(new BCryptPasswordEncoder().encode((staff.getFirstName() + staff.getLastName()).toLowerCase()));
        builder.roles("ADMIN");
        return builder.build();
    }
}
