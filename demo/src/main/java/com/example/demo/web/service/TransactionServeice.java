package com.example.demo.web.service;

import com.example.demo.web.contract.Helloworld;
import com.example.demo.web.contract.Scores;
import com.example.demo.web.model.BlockchainTransaction;
import com.example.demo.web.util.CredentialsGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;


@Service
public class TransactionServeice {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServeice.class);
    private final Admin admin = Admin.build(new HttpService("http://127.0.0.1:7545/"));;
    private final Web3j web3j;
    String contractAddress = "0x136612E549715CFC2583f80c995d06F6BACEa968";
//    String contractAddress2 = "0x12180cF141b3B57B5c878D46cA531dEa27C6FBD5";
    String contractAddress2 = "0x0a436dc44515aca22ad016dc76cce5f34acfe331";





    public TransactionServeice(Web3j web3j) {
        this.web3j = web3j;
    }


    public BlockchainTransaction process(BlockchainTransaction trx) throws IOException{

        EthAccounts accounts = web3j.ethAccounts().send();
        PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(accounts.getAccounts().get(trx.getFromId()),"1848252061").send();
        if(personalUnlockAccount == null || personalUnlockAccount.accountUnlocked()){
            EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(accounts.getAccounts().get(trx.getFromId()), DefaultBlockParameterName.LATEST).send();

            Transaction transaction = Transaction.createEtherTransaction(
                    accounts.getAccounts().get(trx.getFromId()), transactionCount.getTransactionCount(), BigInteger.valueOf(trx.getValue()),
                    BigInteger.valueOf(21_000), accounts.getAccounts().get(trx.getToId()), BigInteger.valueOf(trx.getValue()));

            EthSendTransaction response = web3j.ethSendTransaction(transaction).send();

            if (response.getError() != null) {
                trx.setAccepted(false);
                LOGGER.info("Tx rejected: {}", response.getError().getMessage());
                return trx;
            }

            trx.setAccepted(true);
            String txHash = response.getTransactionHash();
            LOGGER.info("Tx hash: {}", txHash);

            trx.setId(txHash);
            EthGetTransactionReceipt receipt = web3j.ethGetTransactionReceipt(txHash).send();

            receipt.getTransactionReceipt().ifPresent(transactionReceipt -> LOGGER.info("Tx receipt:  {}", transactionReceipt.getCumulativeGasUsed().intValue()));
        }



        return trx;
    }

    public BlockchainTransaction process2(BlockchainTransaction trx) throws Exception {
        Credentials credentials = CredentialsGen.getCredentialsFromPrivateKey();
        String contractAddress = Helloworld.deploy(web3j, credentials, BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L)).send().getContractAddress();
        this.contractAddress = contractAddress;
        System.out.println("contract address:" + contractAddress);

        return trx;
    }



    public BlockchainTransaction process3(BlockchainTransaction trx) throws Exception {
        TransactionManager transactionManager = new RawTransactionManager(web3j, CredentialsGen.getCredentialsFromPrivateKey());
        Transfer transfer  = new Transfer(web3j, transactionManager);
        EthAccounts accounts = web3j.ethAccounts().send();
        System.out.println(accounts.getAccounts().get(trx.getToId()));
        TransactionReceipt transactionReceipt = transfer.sendFunds(
                accounts.getAccounts().get(trx.getToId()),
                BigDecimal.ONE,
                Convert.Unit.ETHER,
                BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L)
        ).send();


        return trx;
    }

    public BlockchainTransaction process4(BlockchainTransaction trx) throws Exception {
        Credentials credentials = CredentialsGen.getCredentialsFromPrivateKey();
        Helloworld helloworld = Helloworld.load(this.contractAddress,web3j, credentials, BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L));

        System.out.println(helloworld.show().send());

        return trx;
    }

    public void scoresDeploy() throws Exception {
        Credentials credentials = CredentialsGen.getCredentialsFromPrivateKey();
        String contractAddress = Scores.deploy(web3j, credentials, BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L)).send().getContractAddress();
        this.contractAddress = contractAddress;
        System.out.println("contract address:" + contractAddress);


    }

    public Boolean addScore(String addr, long score) throws Exception {
        Credentials credentials = CredentialsGen.getCredentialsFromPrivateKey();
        Scores scores = Scores.load(this.contractAddress2,web3j, credentials, BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L));
        Boolean b = scores.addScore(addr,score).send();
        System.out.println(scores.addScore(addr,score).send());

        return b;
    }

    public BigInteger queryScore(String addr) throws Exception {
        Credentials credentials = CredentialsGen.getCredentialsFromPrivateKey();
        Scores scores = Scores.load(this.contractAddress2,web3j, credentials, BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(6721975L));
        BigInteger score = scores.queryScore(addr).send();
        System.out.println(score.longValue());

        return score;
    }



    private String contractDeploy(Web3j web3j, Credentials credentials) throws Exception {
        return Helloworld.deploy(web3j, credentials, BigInteger.valueOf(200000), BigInteger.valueOf(20000000))
                .send()
                .getContractAddress();
    }

}