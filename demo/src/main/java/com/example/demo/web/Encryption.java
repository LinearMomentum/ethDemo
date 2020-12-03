package com.example.demo.web;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    public static String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            String tmp = Integer.toHexString(b & 0xff);
            if (tmp.length() == 1)
                tmp = "0" + tmp;
            result.append(tmp);
        }

        return result.toString();
    }
}
