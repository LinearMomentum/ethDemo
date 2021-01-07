package com.example.demo.web.util;

import org.web3j.crypto.Credentials;

public class CredentialsGen {
    public static Credentials getCredentialsFromPrivateKey(){
        return Credentials.create("a06f738cacdbdbe692456f5779a2018167d74cd152dd809ade3616a16e940a15");
    }

    public static Credentials getCredentialsFromPrivateKey(String privateKey){
        return Credentials.create(privateKey);
    }
}


