package com.example.demo.web.mapper;
import com.example.demo.web.tables.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {
    @Select("select * from department where ethaccount=#{ethaccount}")
    public Student getStudentByAccount(String ethaccount);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into students(name,idcard,ethaccount,password,score) values (#{name},#{idcard},#{ethaccount},#{password},#{score})")

    public Student inserStudent(Student student);
    @Update("update students set passowrd=#{password} where id=#{id}")
    public Student updatePassword(Student student);
}
