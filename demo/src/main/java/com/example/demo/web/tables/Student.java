package com.example.demo.web.tables;


public class Student extends User{
    private int id;
    private String name;
    private String idcard;
    private String ethaccount;
    private String undergraduate1;
    private String undergraduate2;
    private String undergraduate3;
    private String undergraduate4;
    private String undergraduate5;
    private String undergraduate6;
    private String password;
    private String ethpassword;
    private int math;
    private int integration;
    private int chinese;
    private int english;

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getIntegration() {
        return integration;
    }

    public void setIntegration(int integration) {
        this.integration = integration;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public Student() {
        setIdentify(0);
    }

    public String getEthpassword() {
        return ethpassword;
    }

    public void setEthpassword(String ethpassword) {
        this.ethpassword = ethpassword;
    }


    public int getUniversityandmajor() {
        return universityandmajor;
    }

    public void setUniversityandmajor(int universityandmajor) {
        this.universityandmajor = universityandmajor;
    }

    private int universityandmajor;
    private int score;
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getEthaccount() {
        return ethaccount;
    }

    public void setEthaccount(String ethaccount) {
        this.ethaccount = ethaccount;
    }

    public String getUndergraduate1() {
        return undergraduate1;
    }

    public void setUndergraduate1(String undergraduate1) {
        this.undergraduate1 = undergraduate1;
    }

    public String getUndergraduate2() {
        return undergraduate2;
    }

    public void setUndergraduate2(String undergraduate2) {
        this.undergraduate2 = undergraduate2;
    }

    public String getUndergraduate3() {
        return undergraduate3;
    }

    public void setUndergraduate3(String undergraduate3) {
        this.undergraduate3 = undergraduate3;
    }

    public String getUndergraduate4() {
        return undergraduate4;
    }

    public void setUndergraduate4(String undergraduate4) {
        this.undergraduate4 = undergraduate4;
    }

    public String getUndergraduate5() {
        return undergraduate5;
    }

    public void setUndergraduate5(String undergraduate5) {
        this.undergraduate5 = undergraduate5;
    }

    public String getUndergraduate6() {
        return undergraduate6;
    }

    public void setUndergraduate6(String undergraduate6) {
        this.undergraduate6 = undergraduate6;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
