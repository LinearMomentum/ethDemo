package com.example.demo.web.service;

import com.example.demo.web.controller.StudentController;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class ControllerTest {

    @Test
    public void test1() throws NoSuchAlgorithmException {
        StudentController studentController = new StudentController();
        studentController.login("8","8");
    }
}
