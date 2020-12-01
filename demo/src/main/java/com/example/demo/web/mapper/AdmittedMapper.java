package com.example.demo.web.mapper;

import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdmittedMapper {
    @Update("update students set universityandmajor=#{universityandmajor} where id=#{id}")
    public void updateAdmitted(int universityandmajor, int id);
}
