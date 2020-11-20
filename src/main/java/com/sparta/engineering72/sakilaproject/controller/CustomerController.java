package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.*;
import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import com.sparta.engineering72.sakilaproject.services.FilmService;
import com.sparta.engineering72.sakilaproject.services.InventoryService;
import com.sparta.engineering72.sakilaproject.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
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

    @GetMapping("/owner/customers")
    public String getCustomers(ModelMap modelMap) {
        modelMap.addAttribute("customers", customerService.getAllCustomers());
        return "owner/customers";
    }

    @GetMapping("/owner/view/customers/{id}")
    public String showUsersRentalHistory(ModelMap modelMap,
                                         @PathVariable(name = "id") int id) {
        Customer customer = customerService.getCustomerByID(id);
        List<Order> ordersList = new ArrayList<>();
        if (customer != null) {
            List<Rental> customersRentals = rentalService.getRentalsByCustomer(id);
            for (Rental rental : customersRentals) {
                int inventoryId = rental.getInventoryId();
                Inventory inventory = inventoryService.getInventoriesById(inventoryId);
                Film film = filmService.getFilmByID(inventory.getFilmId());
                Order order = new Order(customer, film, rental);
                ordersList.add(order);
            }
        }
        modelMap.addAttribute("history", ordersList);
        modelMap.addAttribute("customer", customer);
        return "owner/customerDetails";
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
