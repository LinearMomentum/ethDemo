package com.example.demo.web.controller;

import com.example.demo.web.model.BlockchainTransaction;
import com.example.demo.web.service.BlockchainService;
import com.example.demo.web.service.TransactionServeice;
import org.springframework.web.bind.annotation.*;


import java.math.BigInteger;

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
        transactionServeice.addScore(addr, score);
//        return Bool.DEFAULT;
    }

    @PostMapping("/queryScore")
    public BigInteger queryScore(@RequestParam("addr") String addr) throws Exception {
        return transactionServeice.queryScore(addr);
    }

}
