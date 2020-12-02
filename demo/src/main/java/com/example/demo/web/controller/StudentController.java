package com.example.demo.web.controller;

import com.example.demo.web.Encryption;
import com.example.demo.web.mapper.StudentMapper;
import com.example.demo.web.tables.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;


@RestController

public class StudentController {
    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/student")
    public Student getStudent(@RequestParam String ethaccount){
        return studentMapper.getStudentByAccount(ethaccount);

    }
    @GetMapping("/student/insert")
    public String insertStudent(Student student) throws NoSuchAlgorithmException {
        int i=(int)(Math.random()*100000);
        String s=Encryption.encryptPassword(String.valueOf(i)).substring(0,12);
        student.setPassword(Encryption.encryptPassword(s));
        studentMapper.inserStudent(student);
        return s;
    }
    @GetMapping("/student/update")
    public void updatePassword(Student student){
        studentMapper.updatePassword(student);
    }
    @GetMapping("/student/login")
    public boolean login(@RequestParam String idcard,@RequestParam String password) throws NoSuchAlgorithmException {
        password=Encryption.encryptPassword(password);
        System.out.println(studentMapper.login(idcard).getPassword().equals(password));
        return studentMapper.login(idcard).getPassword().equals(password);
    }

}
