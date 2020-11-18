package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.respositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByID(int id){
        return customerRepository.findById(id);
    }

}
