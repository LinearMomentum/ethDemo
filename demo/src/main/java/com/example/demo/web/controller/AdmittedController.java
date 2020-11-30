package com.example.demo.web.controller;


import com.example.demo.web.mapper.AdmittedMapper;
import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdmittedController {
    @Autowired
    AdmittedMapper admittedMapper;
    @GetMapping("admitted")
    public void insertAdmitted(int student, int university){
        admittedMapper.InsertAdmitted(student,university);
    }
}
