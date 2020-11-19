package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.*;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import com.sparta.engineering72.sakilaproject.services.FilmService;
import com.sparta.engineering72.sakilaproject.services.InventoryService;
import com.sparta.engineering72.sakilaproject.services.RentalService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;
    private RentalService rentalService;
    private InventoryService inventoryService;
    private FilmService filmService;

    @Autowired
    public CustomerController(CustomerService customerService, RentalService rentalService, InventoryService inventoryService, FilmService filmService) {
        this.customerService = customerService;
        this.rentalService = rentalService;
        this.inventoryService = inventoryService;
        this.filmService = filmService;
    }

    @GetMapping("/customer")
    public String currentUser(ModelMap modelMap, HttpServletRequest request) {
        String email = request.getRemoteUser();
        Customer customer = customerService.getCustomerByEmail(email);
        List<Order> ordersList = new ArrayList<>();
        if(customer != null){
            List<Rental> customersRentals = rentalService.getRentalsByCustomer(customer.getCustomerId());
            for(Rental rental : customersRentals){
                int inventoryId = rental.getInventoryId();
                Inventory inventory = inventoryService.getInventoriesById(inventoryId);
                Film film = filmService.getFilmByID(inventory.getFilmId());
                Order order = new Order(customer, film, rental);
                ordersList.add(order);
            }
        }
        modelMap.addAttribute("orders", ordersList);
        modelMap.addAttribute("customer", customer);
        return "customer/customer";
    }

}
