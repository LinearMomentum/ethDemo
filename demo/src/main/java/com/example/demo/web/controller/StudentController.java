package com.example.demo.web.controller;

import com.example.demo.web.Encryption;
import com.example.demo.web.mapper.StudentMapper;
import com.example.demo.web.tables.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Student insertStudent(Student student) throws NoSuchAlgorithmException {
        String s=student.getPassword();
        student.setPassword(Encryption.encryptPassword(s));
        return studentMapper.inserStudent(student);
    }
    @GetMapping("/student/update")
    public Student updatePassword(Student student){
        return studentMapper.updatePassword(student);
    }

}
