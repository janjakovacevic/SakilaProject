package com.sparta.engineering72.sakilaproject.entites;

import com.sparta.engineering72.sakilaproject.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SakilaprojectApplicationTests {


        @Test
        public void MainController1() {
            MainController mainController = new MainController();
            String result = mainController.home();
            assertEquals(result, "home");
        }

         public void MainController2() {
        MainController mainController = new MainController();
        String result = mainController.account();
        assertEquals(result, "account");
         }

    public void MainController3() {
        MainController mainController = new MainController();
        String result = mainController.login();
        assertEquals(result, "login");
    }
    }


