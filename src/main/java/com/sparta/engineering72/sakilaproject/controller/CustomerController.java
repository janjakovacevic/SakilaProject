package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @GetMapping("/customers")
//    public String getAllCustomers(ModelMap modelMap){
//        modelMap.addAttribute("customers", customerService.getAllCustomers());
//        return "restricted/customers";
//    }
//
//    @GetMapping("/customer")
//    public String getCustomer(ModelMap modelMap, Integer id){
//        modelMap.addAttribute("customer", customerService.getCustomerByID(65));
//        return "restricted/customer";
//    }

    @GetMapping("/customer")
    public String currentUser(ModelMap modelMap, HttpServletRequest request) {
        String email = request.getRemoteUser();
        Customer customer = customerService.getCustomerByEmail(email);
        modelMap.addAttribute("customer", customer);
        return "/customer";
    }

}
