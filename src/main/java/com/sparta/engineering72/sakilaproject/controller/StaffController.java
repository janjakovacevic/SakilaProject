package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.entities.Staff;
import com.sparta.engineering72.sakilaproject.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StaffController {

    private StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    @GetMapping("/owner")
    public String currentUser(ModelMap modelMap, HttpServletRequest request) {
        String username = request.getRemoteUser();
        Staff staff = staffService.getStaffByUsername(username);
        modelMap.addAttribute("staff", staff);
        return "/owner/owner";
    }
}
