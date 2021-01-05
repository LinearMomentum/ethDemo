package com.example.demo.web.util;

import org.web3j.crypto.*;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Account {
    private String address;
    private String privateKey;

    public Account(String address, String privateKey) {
        this.address = address;
        this.privateKey = privateKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public static Account createAccount() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, CipherException {

        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        BigInteger privateKeyInDec = ecKeyPair.getPrivateKey();
        String privateKey = privateKeyInDec.toString(16);
        WalletFile aWallet = Wallet.createLight("1848252061", ecKeyPair);
        String address = aWallet.getAddress();
        if (address.startsWith("0x")) {
            address = address.substring(2).toLowerCase();
        } else {
            address = address.toLowerCase();
        }
        address = "0x" + address;
        privateKey = "0x" + privateKey;
        return new Account(address, privateKey);

    }

}
