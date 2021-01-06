package com.example.demo.web.controller;


import com.example.demo.web.Encryption;
import com.example.demo.web.mapper.AdmittedMapper;
import com.example.demo.web.service.TransactionServeice;
import com.example.demo.web.tables.Examinstitute;
import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import com.example.demo.web.tables.university_major;
import com.example.demo.web.util.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.CipherException;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;

@RestController
public class AdmittedController {
    @Autowired
    AdmittedMapper admittedMapper;
    @Autowired
    private TransactionServeice transactionServeice;
    @GetMapping("/admitted/update")
    public void updateAdmitted(@RequestParam int universityandmajor,@RequestParam int id){
        admittedMapper.updateAdmitted(universityandmajor,id);
    }
    @GetMapping("institute/insert")
    public void insertInstitute(Examinstitute examinstitute) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, CipherException, NoSuchProviderException {
        examinstitute.setSystempassword(Encryption.encryptPassword(examinstitute.getSystempassword()));
        examinstitute.setIdentify(2);
        Account account = Account.createAccount();
        examinstitute.setEthaccount(account.getAddress());
        examinstitute.setEthpassword(account.getPrivateKey());
        admittedMapper.insertExam(examinstitute);
    }

    @GetMapping("/admitted")
    public List<university_major> admitted() throws Exception {
        List<university_major> majors=admittedMapper.admitted();
        LinkedList<university_major> majors1= new LinkedList(majors) ;
        for(university_major major:majors){
            int studentNumber=major.getStudentnum();
            if (studentNumber==0)
                continue;
            List<Student> students=admittedMapper.undergrate1(major.getMajorid());
            students.sort(Comparator.comparing(Student::getScore).reversed());
            if (students.size()<=major.getStudentnum()){
                major.setStudentnum(studentNumber-students.size());
                major.setScore(students.get(students.size()-1).getScore());
                for (Student student : students){
                    if (student.getUniversityandmajor()==0){
                        transactionServeice.volunteer(BigInteger.valueOf(major.getId()),student.getEthaccount());
                        admittedMapper.updateAdmitted(major.getId(),student.getId());
                    }
                }
            }
            else {
                major.setStudentnum(0);
                for (int i = 0; i <studentNumber ; i++) {
                    transactionServeice.volunteer(BigInteger.valueOf(major.getId()),students.get(i).getEthaccount());
                    admittedMapper.updateAdmitted(major.getId(),students.get(i).getId());
                    major.setScore(students.get(i).getScore());
                }
            }
        }
        for (int i=0;i<majors.size();i++){
            university_major major=majors.get(i);
            System.out.println(major.getScore()+" "+major.getStudentnum());
            admittedMapper.updateUniversityAndMajor(major.getStudentnum(),major.getId());
            try {
                transactionServeice.addMajor(BigInteger.valueOf(major.getId()), BigInteger.valueOf(Long.parseLong(major.getUniversityid())), BigInteger.valueOf(major.getMajorid()), BigInteger.valueOf(majors1.get(i).getStudentnum()), BigInteger.valueOf(major.getScore()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        transactionServeice.matriculate();

        return majors;
    }
}
