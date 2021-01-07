package com.example.demo.web.controller;

import com.example.demo.web.Encryption;
import com.example.demo.web.mapper.UniversityMapper;
import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import com.example.demo.web.tables.university_major;
import com.example.demo.web.util.Account;
import jnr.ffi.annotations.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.CipherException;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UniversityController {
    @Autowired
    UniversityMapper universityMapper;

    @GetMapping("/university/insert")
    public void insertUniversity(University university) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, CipherException, NoSuchProviderException {
        Account account = Account.createAccount();
        university.setEthaccount(account.getAddress());
        university.setEthpassword(account.getPrivateKey());
        university.setSystempassword(Encryption.encryptPassword(university.getSystempassword()));
        university.setIdentify(1);
        universityMapper.insertUniversity(university);
    }
    @GetMapping("/university/get")
    public List<University> getUniversities(){
        return universityMapper.getUniversities();
    }
    @GetMapping("/university/getMajors")
    public University getMajorsById(@RequestParam String idcode){
        University university=universityMapper.getUniversityByIdCode(idcode);
        List<Integer> majors=universityMapper.getMajorsByUniversity(university.getIdcode());
        for (Integer i:majors){
            university.getMajor().add(universityMapper.getMajorNameByCode(i));
        }
        return university;
    }
    @GetMapping("/university/getMajorsByAccount")
    public University getMajorsByAccount(@RequestParam String systemaccount){
        University university=universityMapper.getUniversityByAccount(systemaccount);
        List<Integer> majors=universityMapper.getMajorsByUniversity(university.getIdcode());
        for (Integer i:majors){
            university.getMajor().add(universityMapper.getMajorNameByCode(i));
        }
        return university;
    }
    @GetMapping("/university/getStudents")
    public List<Student> getStudents(@RequestParam String idcode){
        System.out.println("12345");
        List<university_major> majors=universityMapper.getMajorsByUniversityId(idcode);
        List<Student> students=new ArrayList<>();
        for (university_major major :majors){
            students.addAll(universityMapper.getStudentsByUniversity(major.getId()));
        }
        for (Student student:students){
            university_major university_major=universityMapper.getUniversityAndMajorById(student.getUndergraduate1());
            University university=universityMapper.getUniversityById(university_major.getUniversityid());
            String majorName=universityMapper.getMajorNameByCode(university_major.getMajorid());
            student.setUniversity(university);
            student.setMajorName(majorName);
        }
        return students;
    }
}
