package com.example.demo.web.mapper;

import com.example.demo.web.tables.University;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UniversityMapper {

    @Insert("insert into university(name,idcode,ethpassword,systemaccount,systempassword,ethaccount,quota) " +
            "values (#{name},#{idcode},#{ethpassword},#{systemaccount},#{systempassword},#{ethaccount},#{quota})")
    public void insertUniversity(University university);

    @Select("select * from university where systemaccount=#{systemaccount}")
    public University getUniversity(String systemaccount);

    @Select("select * from university")
    public List<University> getUniversities();

}
