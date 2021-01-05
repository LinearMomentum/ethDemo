package com.example.demo.web.controller;


import com.example.demo.web.mapper.AdmittedMapper;
import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import com.example.demo.web.tables.university_major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class AdmittedController {
    @Autowired
    AdmittedMapper admittedMapper;
    @GetMapping("/admitted")
    public void insertAdmitted(@RequestParam int universityandmajor,@RequestParam int id){
        admittedMapper.updateAdmitted(universityandmajor,id);
    }
    @GetMapping("/admitted")
    public List<university_major> admitted(){
        List<university_major> majors=admittedMapper.admitted();
        for(university_major major:majors){
            int studentNumber=major.getStudentnum();
            if (studentNumber==0)
                continue;
            List<Student> students=admittedMapper.undergrate1(major.getMajorid());
            students.sort(Comparator.comparing(Student::getScore).reversed());
            if (students.size()<=major.getStudentnum()){
                major.setStudentnum(studentNumber-students.size());
                major.setScore(students.get(students.size()-1).getScore());
            }
            else {
                major.setStudentnum(0);
                for (int i = 0; i <studentNumber ; i++) {
                    admittedMapper.updateAdmitted(major.getId(),students.get(i).getId());
                    major.setScore(students.get(i).getScore());
                }
            }
        }
        for (university_major major :majors){
            System.out.println(major.getScore()+" "+major.getStudentnum());
        }
        return majors;
    }
}
