package com.example.demo.web.controller;

import com.example.demo.web.contract.Matriculate;
import com.example.demo.web.model.BlockchainTransaction;
import com.example.demo.web.service.BlockchainService;
import com.example.demo.web.service.TransactionServeice;
import com.example.demo.web.util.CredentialsGen;
import org.springframework.web.bind.annotation.*;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.gas.StaticGasProvider;


import java.math.BigInteger;
import java.util.List;

@RestController
public class TransactionController {

    private final BlockchainService service;
    private final TransactionServeice transactionServeice;



    public TransactionController(BlockchainService service, TransactionServeice transactionServeice) {
        this.service = service;
        this.transactionServeice = transactionServeice;
    }

    @PostMapping("/transaction3")
    public BlockchainTransaction execute(@RequestBody BlockchainTransaction transaction) throws Exception {
        return transactionServeice.process3(transaction);
    }
//
    @PostMapping("/transaction2")
    public BlockchainTransaction execute2(@RequestBody BlockchainTransaction transaction) throws Exception {
        return transactionServeice.process2(transaction);
    }

    @PostMapping("/transaction4")
    public BlockchainTransaction execute4(@RequestBody BlockchainTransaction transaction) throws Exception {
        return transactionServeice.process4(transaction);
    }

    @GetMapping("/scoresdeploy")
    public void execute4() throws Exception {
        transactionServeice.scoresDeploy();
    }

    @PostMapping("/addScore")
    public void addScore(@RequestParam("addr") String addr, @RequestParam("score") long score) throws Exception {
        System.out.println(addr+" "+score);
        transactionServeice.addScore(addr, BigInteger.valueOf(score));
//        return Bool.DEFAULT;
    }

    @PostMapping("/addScore2")
    public void addScore2(@RequestParam("addr") String addr, @RequestParam("score") long score) throws Exception {
        System.out.println(addr+" "+score);
        transactionServeice.addScore2(addr, score);
//        return Bool.DEFAULT;
    }

    @PostMapping("/queryScore")
    public BigInteger queryScore(@RequestParam("addr") String addr) throws Exception {
        return transactionServeice.queryScore(addr);
    }

    @GetMapping("/matriculateDeploy")
    public void matriculateDeploy() throws Exception {
        transactionServeice.matriculateDeploy();
    }

    @PostMapping("/volunteer")
    public void volunteer(@RequestParam("id") long id, @RequestParam("addr") String addr) throws Exception {
        transactionServeice.volunteer(BigInteger.valueOf(id), addr);
    }

    @PostMapping("/addMajor")
    public void addMajor(@RequestParam("id") long id, @RequestParam("uid") long uid, @RequestParam("mid") long mid, @RequestParam("num") long num, @RequestParam("score") long score) throws Exception {
        transactionServeice.addMajor(BigInteger.valueOf(id), BigInteger.valueOf(uid), BigInteger.valueOf(mid), BigInteger.valueOf(num), BigInteger.valueOf(score));
    }

    @PostMapping("/queryMajor")
    public Tuple4<BigInteger, BigInteger, BigInteger, BigInteger> queryMajor(@RequestParam("id") long id) throws Exception {
        return transactionServeice.queryMajor(BigInteger.valueOf(id));
    }

    @GetMapping("/matriculate")
    public void matriculate() throws Exception {
        transactionServeice.matriculate();
    }

    @PostMapping("/matriculatedList")
    public List matriculatedList(@RequestParam("id") long id) throws Exception {
        return transactionServeice.matriculatedList(BigInteger.valueOf(id));
    }

    @PostMapping("/matriculatedMajor")
    public long matriculatedMajor(String addr) throws Exception {
        return transactionServeice.matriculatedMajor(addr).longValue();
    }







}
