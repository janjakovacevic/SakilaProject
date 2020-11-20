package com.sparta.engineering72.sakilaproject.entites;

import com.sparta.engineering72.sakilaproject.controller.CustomerController;
import com.sparta.engineering72.sakilaproject.controller.MainController;
import com.sparta.engineering72.sakilaproject.services.CategoryService;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import com.sparta.engineering72.sakilaproject.services.FilmCategoryService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SakilaprojectApplicationTests {


        @Test
        public void MainController1() {
            MainController mainController = new MainController();
            String result = mainController.home();
            assertEquals(result, "home");
        }



        @Test
         public void MainController2() {
        MainController mainController = new MainController();
        String result = mainController.account();
        assertEquals(result, "account");
         }
        @Test
    public void MainController3() {
        MainController mainController = new MainController();
        String result = mainController.login();
        assertEquals(result, "login");
    }


    }


