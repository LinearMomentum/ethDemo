package com.example.demo.web.tables;

public class university_major {
    private int id;
    private String universityid;
    private int majorid;
    private int studentnum;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniversityid() {
        return universityid;
    }

    public void setUniversityid(String universityid) {
        this.universityid = universityid;
    }

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

    public int getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(int studentnum) {
        this.studentnum = studentnum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
