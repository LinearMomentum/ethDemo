package com.example.demo.web.service;

import org.junit.jupiter.api.Test;
import org.web3j.abi.datatypes.Address;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple4;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionServiceTest {
    TransactionServeice transactionServeice = new TransactionServeice(Web3j.build(new HttpService("http://127.0.0.1:7545")));

    @Test
    public void deploy() throws Exception {
        transactionServeice.matriculateDeploy();
        transactionServeice.scoresDeploy();
        transactionServeice.recordDeploy();
    }

    @Test
    public void scoreTest() throws Exception {
        int value = 200;

        transactionServeice.addScore("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A6", BigInteger.valueOf(value));
        int res = transactionServeice.queryScore("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A6").intValue();
        assertEquals(value, res);
    }

    @Test
    public void RecordTest() throws Exception {
//        transactionServeice.recordDeploy();
        String value = "200";
        transactionServeice.addRecord("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A6", value);
        String res = transactionServeice.queryId("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A6");
        assertEquals(value, res);
    }

    @Test
    public void majorTest() throws Exception {
        long var1 = 1, var2 = 2, var3 = 3, var4 = 4, var5 = 5;
        transactionServeice.addMajor(BigInteger.valueOf(var1),BigInteger.valueOf(var2),BigInteger.valueOf(var3),BigInteger.valueOf(var4),BigInteger.valueOf(var5));
        Tuple4<BigInteger, BigInteger, BigInteger, BigInteger> tuple4 = transactionServeice.queryMajor(BigInteger.valueOf(var1));
        assertEquals(tuple4,new Tuple4<>(BigInteger.valueOf(var2),BigInteger.valueOf(var3),BigInteger.valueOf(var4),BigInteger.valueOf(var5)));
    }

    @Test
    public void matriculateTest() throws Exception {
        long value = 100;
        long var1 = 1, var2 = 2, var3 = 3, var4 = 4, var5 = 103;
        transactionServeice.addMajor(BigInteger.valueOf(var1),BigInteger.valueOf(var2),BigInteger.valueOf(var3),BigInteger.valueOf(var4),BigInteger.valueOf(var5));
        transactionServeice.addScore("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A6", BigInteger.valueOf(value));
        transactionServeice.addScore("0x4AADa8c53baB34731c7c9F4906A77BD3789c0FbE", BigInteger.valueOf(value+1));
        transactionServeice.addScore("0x181dF4b253C410Cc2cF85FdfD611954043322b22", BigInteger.valueOf(value+2));
        transactionServeice.volunteer(BigInteger.valueOf(var1),"0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A6");
        transactionServeice.volunteer(BigInteger.valueOf(var1),"0x4AADa8c53baB34731c7c9F4906A77BD3789c0FbE");
        transactionServeice.volunteer(BigInteger.valueOf(var1),"0x181dF4b253C410Cc2cF85FdfD611954043322b22");
        transactionServeice.setScoresContractAddress();
        transactionServeice.matriculate();
        List list = transactionServeice.matriculatedList(BigInteger.valueOf(var1));
        BigInteger major = transactionServeice.matriculatedMajor("0x181dF4b253C410Cc2cF85FdfD611954043322b22");
        for(Object i:list){
            System.out.println(i);
//            System.out.println(list.get(2));
        }
        System.out.println(major);




    }

//    @Test
//    public void matriculateTest2() throws Exception {
//        long value = 100;
//        long var1 = 2, var2 = 2, var3 = 3, var4 = 2, var5 = 101;
//        transactionServeice.addMajor(BigInteger.valueOf(var1),BigInteger.valueOf(var2),BigInteger.valueOf(var3),BigInteger.valueOf(var4),BigInteger.valueOf(var5));
//        transactionServeice.addScore("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A6", BigInteger.valueOf(value));
//        transactionServeice.addScore("0x4AADa8c53baB34731c7c9F4906A77BD3789c0FbE", BigInteger.valueOf(value+1));
//        transactionServeice.addScore("0x181dF4b253C410Cc2cF85FdfD611954043322b22", BigInteger.valueOf(value+2));
//
//        transactionServeice.volunteer(BigInteger.valueOf(var1),"0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A6");
//        transactionServeice.volunteer(BigInteger.valueOf(var1),"0x4AADa8c53baB34731c7c9F4906A77BD3789c0FbE");
//        transactionServeice.volunteer(BigInteger.valueOf(var1),"0x181dF4b253C410Cc2cF85FdfD611954043322b22");
//
//        transactionServeice.matriculate();
//        List<String> list = transactionServeice.matriculatedList(BigInteger.valueOf(var1));
//        for(String i:list){
//            System.out.println(i);
////            System.out.println(list.get(2));
//        }
//
//
//
//
//    }

    @Test
    public void test() throws Exception {
        transactionServeice.addScore("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A9",BigInteger.valueOf(100));
        System.out.println(transactionServeice.queryScore("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2A9"));
        System.out.println(transactionServeice.queryScore("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2AA"));
        System.out.println(transactionServeice.queryScore("0xb7f00eE5026e79709EA680CF63B83BACf6a0A2AB"));
    }
}
