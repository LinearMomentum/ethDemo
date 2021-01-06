package com.example.demo.web.mapper;

import com.example.demo.web.tables.University;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UniversityMapper {

    @Insert("insert into university(name,idcode,ethaccount,quota) values (#{name},#{idcode},#{ethaccount},#{quota})")
    public void insertUniversity(University university);

    @Select("selet * from university where where systemaccount=#{systemaccount}")
    public University getUniversity(String systemaccount);
}
