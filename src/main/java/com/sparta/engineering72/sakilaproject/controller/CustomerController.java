package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
//
//    @GetMapping("/customer")
//    public String getCustomer(ModelMap modelMap, Integer id){
//        Optional<Customer> customer = customerService.getCustomerByID(id);
//        modelMap.addAttribute("customer", customer);
//        return "customer";
//    }

}
