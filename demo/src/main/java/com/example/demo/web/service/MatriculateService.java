package com.example.demo.web.service;

import com.example.demo.web.contract.Matriculate;
import com.example.demo.web.util.CredentialsGen;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Service
public class MatriculateService {
    private final Admin admin = Admin.build(new HttpService("http://127.0.0.1:7545/"));;
    private final Web3j web3j;
    String contractAddress = "0x0a436dc44515aca22ad016dc76cce5f34acfe331";

    public MatriculateService(Web3j web3j) {
        this.web3j = web3j;
    }

    public void matriculateDeploy() throws Exception {
        Credentials credentials = CredentialsGen.getCredentialsFromPrivateKey();

        String contractAddress = Matriculate.deploy(web3j, credentials, new StaticGasProvider(BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L))).send().getContractAddress();
        this.contractAddress = contractAddress;
        System.out.println("contract address:" + contractAddress);
    }

    public void volunteer(BigInteger id, String addr) throws Exception {
        Credentials credentials = CredentialsGen.getCredentialsFromPrivateKey();
        Matriculate matriculate = Matriculate.load(this.contractAddress,web3j, credentials, new StaticGasProvider(BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L)));
        matriculate.volunteer(id, addr);
    }

    public void addMajor(BigInteger id, BigInteger uid, BigInteger mid, BigInteger num, BigInteger score){
        Credentials credentials = CredentialsGen.getCredentialsFromPrivateKey();
        Matriculate matriculate = Matriculate.load(this.contractAddress,web3j, credentials, new StaticGasProvider(BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L)));
        matriculate.addMajor(id, uid, mid, num, score);
    }

    public Tuple4<BigInteger, BigInteger, BigInteger, BigInteger> queryMajor(BigInteger id) throws Exception {
        Credentials credentials = CredentialsGen.getCredentialsFromPrivateKey();
        Matriculate matriculate = Matriculate.load(this.contractAddress,web3j, credentials, new StaticGasProvider(BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L)));
        return matriculate.queryMajor(id).send();
    }




}
