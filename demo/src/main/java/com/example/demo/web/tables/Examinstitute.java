package com.example.demo.web.tables;

public class Examinstitute extends User{
    private int id;
    private String ethaccount;
    private String ethpassword;
    private String systemaccount;
    private String systempassword;

    public Examinstitute() {
        setIdentify(2);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEthpassword() {
        return ethpassword;
    }

    public void setEthpassword(String ethpassword) {
        this.ethpassword = ethpassword;
    }

    public String getSystemaccount() {
        return systemaccount;
    }

    public void setSystemaccount(String systemaccount) {
        this.systemaccount = systemaccount;
    }

    public String getSystempassword() {
        return systempassword;
    }

    public void setSystempassword(String systempassword) {
        this.systempassword = systempassword;
    }

    public String getEthaccount() {
        return ethaccount;
    }

    public void setEthaccount(String ethaccount) {
        this.ethaccount = ethaccount;
    }
}
