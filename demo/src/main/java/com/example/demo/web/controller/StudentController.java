package com.example.demo.web.controller;

import com.example.demo.web.Encryption;
import com.example.demo.web.mapper.AdmittedMapper;
import com.example.demo.web.mapper.StudentMapper;
import com.example.demo.web.mapper.UniversityMapper;
import com.example.demo.web.service.TransactionServeice;
import com.example.demo.web.tables.Examinstitute;
import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import com.example.demo.web.tables.User;
import com.example.demo.web.util.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.CipherException;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;


@RestController

public class StudentController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UniversityMapper UniMapper;
    @Autowired
    AdmittedMapper addMapper;
    @Autowired
    private TransactionServeice transactionServeice;
    @GetMapping("/student")
    public Student getStudent(@RequestParam String idcard){
        return studentMapper.getStudentByIdCard(idcard);

    }
    @GetMapping("/student/score")
    public int getScore(@RequestParam String idcard) throws Exception {
        Student student=studentMapper.getStudentByIdCard(idcard);
        BigInteger bigInteger=transactionServeice.queryScore(student.getEthaccount());
        return bigInteger.intValue();
    }
    @PostMapping("/student/save")
    public void saveMajor(@RequestParam String idcard,@RequestParam String password){
        //interface

    }
    @GetMapping("/student/insert")
    public Student insertStudent(Student student) throws Exception {
        //int i=(int)(Math.random()*100000);
        //String s=Encryption.encryptPassword(String.valueOf(i)).substring(0,12);
        Account account = Account.createAccount();
        student.setEthaccount(account.getAddress());
        student.setEthpassword(account.getPrivateKey());
        transactionServeice.addScore(student.getEthaccount(), BigInteger.valueOf(student.getScore()));
        student.setPassword(Encryption.encryptPassword(student.getPassword()));
        transactionServeice.addRecord(student.getEthaccount(),student.getIdcard());
        student.setIdentify(0);
        studentMapper.inserStudent(student);
        return student;
    }
    @GetMapping("/student/update")
    public void updatePassword(Student student){
        studentMapper.updatePassword(student);
    }
    @GetMapping("/login")
    public User login(@RequestParam String idcard, @RequestParam String password) throws NoSuchAlgorithmException {
        System.out.println(idcard);
        System.out.println(password);
        password=Encryption.encryptPassword(password);
        System.out.println(studentMapper.login(idcard).getPassword().equals(password));
        Student student=studentMapper.getStudentByIdCard(idcard);
        if (student!=null){
            if(studentMapper.login(idcard).getPassword().equals(password))
                return student;
        }
        University university=UniMapper.getUniversity(idcard);
        if (university!=null){
            if (university.getSystempassword().equals(password)){
                return university;
            }
        }
        Examinstitute examinstitute=addMapper.getExaminstitute(idcard);
        if (examinstitute!=null){
            if (examinstitute.getEthpassword().equals(password))
                return examinstitute;
        }
        return null;
    }

}
