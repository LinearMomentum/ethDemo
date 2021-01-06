package com.example.demo.web.controller;

import com.example.demo.web.Encryption;
import com.example.demo.web.mapper.UniversityMapper;
import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import com.example.demo.web.util.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.CipherException;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

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

}
