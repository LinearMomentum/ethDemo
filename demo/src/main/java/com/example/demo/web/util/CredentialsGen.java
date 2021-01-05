package com.example.demo.web.util;

import org.web3j.crypto.Credentials;

public class CredentialsGen {
    public static Credentials getCredentialsFromPrivateKey(){
        return Credentials.create("5c779dc6d06ecf9541fb971eff859757f7ea58f34cbd467cd10a1e011c196388");
    }

    public static Credentials getCredentialsFromPrivateKey(String privateKey){
        return Credentials.create(privateKey);
    }
}


