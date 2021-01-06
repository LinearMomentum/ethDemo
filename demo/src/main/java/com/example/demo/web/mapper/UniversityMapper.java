package com.example.demo.web.mapper;

import com.example.demo.web.tables.Student;
import com.example.demo.web.tables.University;
import com.example.demo.web.tables.university_major;
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

    @Select("select * from university where idcode=#{idcode}")
    public University getUniversityById(String idcode);

    @Select("select code from major where name=#{name}")
    public int getMajorIdByName(String name);

    @Select("select id from university_major where universityid=#{0} and majorid=#{1}")
    public university_major getUniversityAndMajor(String universityid,int majorid);

    @Select("select * from university_major where id=#{id}")
    public university_major getUniversityAndMajorById(int id);

    @Select("select name from major where code=#{code}")
    public String getMajorNameByCode(int code);

    @Select("select * from university where idcode=#{idcode}")
    public University getUniversityByIdCode(String idcode);

    @Select("select majorid from university_major where universityid=#{0}")
    public List<Integer> getMajorsByUniversity(String universityid);

    @Select("select * from students where undergraduate1=#{0}")
    public List<Student> getStudentsByUniversity(int undergraduate1);

    @Select("select * from university_major where universityid=#{0}")
    public List<university_major> getMajorsByUniversityId(String universityid);

}
