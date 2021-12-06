package com.zjrcu.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zjrcu.Dao.User;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    public List<User> list();

    @Select("SELECT * FROM user WHERE id=#{id}")
    public User getById(Integer id);

    @Delete("DELETE FROM user WHERE id=#{id}")
    public int deleteById(Integer id);

    // Options 注解说明id是自增类型的，插入后自动返回值到实体类的id
    @Options(useGeneratedKeys=true, keyProperty="id")
    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    public int insert(User user);

    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    public int updatePassword(User user);
}