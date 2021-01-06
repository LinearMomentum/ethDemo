package com.example.demo.web.mapper;

import com.example.demo.web.tables.Examinstitute;
import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import com.example.demo.web.tables.university_major;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdmittedMapper {
    @Update("update students set universityandmajor=#{0} where id=#{1}")
    public void updateAdmitted(int universityandmajor, int id);

    @Select("select * from university_major")
    public List<university_major> admitted();
    @Select("select * from students where undergraduate1=#{major} and universityandmajor is null")
    public List<Student> undergrate1(int major);

    @Update("update universityandmajor set studentnum=#{0} where id=#{1}")
    public void updateUniversityAndMajor(int studentnum,int id);
    @Select("select * from students where systemaccount=#{systemaccount}")
    public Examinstitute getExaminstitute(String systemaccount);

}
