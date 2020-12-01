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

    @GetMapping("/student/{ethaccount}")
    public Student getStudent(@PathVariable("ethaccount") String ethaccount){
        return studentMapper.getStudentByAccount(ethaccount);

    }
    @GetMapping("/student/insert")
    public void insertStudent(Student student) throws NoSuchAlgorithmException {
        String s=student.getPassword();
        student.setPassword(Encryption.encryptPassword(s));
        studentMapper.inserStudent(student);
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
