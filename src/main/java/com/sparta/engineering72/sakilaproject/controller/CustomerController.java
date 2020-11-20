package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public String currentUser(ModelMap modelMap, HttpServletRequest request) {
        String email = request.getRemoteUser();
        Customer customer = customerService.getCustomerByEmail(email);
        modelMap.addAttribute("customer", customer);
        return "customer/customer";
    }

    @RequestMapping("/newCustomer")
    public String showNewProductPage(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

//        filmService.getAllSpecialFeatures

//        String releaseYear = "";
//        model.addAttribute("releaseYear", releaseYear);
//        LocalDate localDate = LocalDate.parse(releaseYear);
//        film.setReleaseYear(localDate);

        return "/owner/create-new-customer";
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("film") Customer customer, Model model) {
//        customer.setLastUpdate(Timestamp.from(Instant.now()));
//        customer.getCreateDate(LocalDate.now().getYear()); //Fixme make it a choice
//        //Fixme set store_id; address_id

        customerService.save(customer);

        return "redirect:/newCustomer";
    }

}
