package com.example.demo.web.mapper;

import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdmittedMapper {
    @Insert("insert into Admitted(student,university) values(#{student},#{university})")
    public void InsertAdmitted(int student, int university);
}
