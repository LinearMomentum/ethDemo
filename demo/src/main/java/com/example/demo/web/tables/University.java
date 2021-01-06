package com.example.demo.web.tables;

public class University extends User{
    private int id;
    private String name;
    private String idcode;
    private String ethaccount;
    private String systemaccount;
    private String systempassword;

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

    public University() {
        setIdentify(1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public String getEthaccount() {
        return ethaccount;
    }

    public void setEthaccount(String ethaccount) {
        this.ethaccount = ethaccount;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    private int quota;
}
