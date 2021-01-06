package com.example.demo.web.controller;

import com.example.demo.web.Encryption;
import com.example.demo.web.mapper.UniversityMapper;
import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class UniversityController {
    @Autowired
    UniversityMapper universityMapper;
    @GetMapping("/university/insert")
    public University insertUniversity(University university) throws NoSuchAlgorithmException {
        university.setSystempassword(Encryption.encryptPassword(university.getSystempassword()));
        university.setIdentify(1);
        universityMapper.insertUniversity(university);
        return university;
    }

}
