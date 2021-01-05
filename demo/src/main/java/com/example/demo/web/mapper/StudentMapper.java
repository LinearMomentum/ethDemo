package com.example.demo.web.mapper;
import com.example.demo.web.tables.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from students where idcard=#{idcard}")
    public Student getStudentByIdCard(String idcard);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into students(name,idcard,ethaccount,password,score,ethpassword) values (#{name},#{idcard},#{ethaccount},#{password},#{score},#{ethpassword})")
    public void inserStudent(Student student);

    @Update("update students set passowrd=#{password} where id=#{id}")
    public void updatePassword(Student student);

    @Select("select * from students where idcard=#{idcard}")
    public Student login(String idcard);
}
