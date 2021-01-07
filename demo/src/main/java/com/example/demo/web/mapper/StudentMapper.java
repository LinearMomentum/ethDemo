package com.example.demo.web.mapper;
import com.example.demo.web.tables.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from students where idcard=#{idcard}")
    public Student getStudentByIdCard(String idcard);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into students(name,idcard,ethaccount,password,score,ethpassword,math,chinese,english,integration) values (#{name},#{idcard},#{ethaccount},#{password},#{score},#{ethpassword},#{math},#{chinese},#{english},#{integration})")
    public void inserStudent(Student student);

    @Update("update students set password=#{password} where id=#{id}")
    public void updatePassword(Student student);

    @Select("select * from students where idcard=#{idcard}")
    public Student login(String idcard);
    @Update("update students set state=1 where idcard=#{idcard}")
    public void updateState(String idcard);

    @Update("update students set undergraduate1=#{0} where idcard=#{1}")
    public void saveMajor(int undergraduate1,String idcard);
}
