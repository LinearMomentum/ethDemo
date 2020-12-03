package com.example.demo.web.mapper;

import com.example.demo.web.tables.University;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UniversityMapper {

    @Insert("insert into university(name,idcode,ethaccount,quota) values (#{name},#{idcode},#{ethaccount},#{quota})")
    public University insertUniversity(University university);
}
