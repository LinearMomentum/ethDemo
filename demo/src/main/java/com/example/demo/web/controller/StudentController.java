package com.example.demo.web.controller;

import com.example.demo.web.Encryption;
import com.example.demo.web.mapper.AdmittedMapper;
import com.example.demo.web.mapper.StudentMapper;
import com.example.demo.web.mapper.UniversityMapper;
import com.example.demo.web.service.TransactionServeice;
import com.example.demo.web.tables.*;
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
        System.out.println(idcard+"  sssss");

        Student student= studentMapper.getStudentByIdCard(idcard);
        if (student.getUndergraduate1()!=0){
        university_major university_major=UniMapper.getUniversityAndMajorById(student.getUndergraduate1());
        University university=UniMapper.getUniversityById(university_major.getUniversityid());
        String majorName=UniMapper.getMajorNameByCode(university_major.getMajorid());
        student.setUniversity(university);
        student.setMajorName(majorName);}
        return student;

    }
//    @GetMapping("/student/name")
//    public String getStudentName(@){
//
//    }

    @GetMapping("/student/score")
    public int getScore(@RequestParam String idcard) throws Exception {
        Student student=studentMapper.getStudentByIdCard(idcard);
        BigInteger bigInteger=transactionServeice.queryScore(student.getEthaccount());
        return bigInteger.intValue();
    }
    @GetMapping("/student/submit")
    public void submitMajor(@RequestParam String idcard,@RequestParam String idcode,@RequestParam String name){
        //interface

        studentMapper.updateState(idcard);
        saveMajor(idcard,idcode,name);

    }
    @GetMapping("student/save")
    public void saveMajor(@RequestParam String idcard,@RequestParam String idcode,@RequestParam String name){
        University university= UniMapper.getUniversityById(idcode);
        int majorId=UniMapper.getMajorIdByName(name);
        university_major university_major=UniMapper.getUniversityAndMajor(university.getIdcode(),majorId);
        studentMapper.saveMajor(university_major.getId(),idcard);
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
//       password=Encryption.encryptPassword(password);
       // System.out.println(studentMapper.login(idcard).getPassword().equals(password));
        Student student=studentMapper.getStudentByIdCard(idcard);
        if (student!=null){
            password=Encryption.encryptPassword(password);
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
            password=Encryption.encryptPassword(password);
            if (examinstitute.getSystempassword().equals(password))
                return examinstitute;
        }
        return null;
    }

}
