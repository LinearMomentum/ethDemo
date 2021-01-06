package com.example.demo.web.tables;

public class University extends User{
    private int id;
    private String name;
    private String idcode;
    private String ethaccount;

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
