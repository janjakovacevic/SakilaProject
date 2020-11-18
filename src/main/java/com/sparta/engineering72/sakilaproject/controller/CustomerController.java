package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String getAllCustomers(ModelMap modelMap){
        modelMap.addAttribute("customers", customerService.getAllCustomers());
        return "restricted/customers";
    }

    @GetMapping("/customer")
    public String getCustomer(ModelMap modelMap, Integer id){
        modelMap.addAttribute("customer", customerService.getCustomerByID(65));
        return "restricted/customer";
    }

}
