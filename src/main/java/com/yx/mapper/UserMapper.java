package com.yx.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.File;
import java.util.List;

/**
 * @author YinXiong
 */
@Mapper
public interface UserMapper {

    /**
     * 获取用户列表
     * @return user
     */
    @Select("SELECT * FROM user")
    public List<User> list();

    /**
     * 通过id获取用户信息
     * @param id
     * @return user
     */
    @Select("SELECT * FROM user WHERE id=#{id}")
    public User getById(Integer id);

    /**
     * 用户认证
     * @param username
     * @param password
     * @return int
     */
    @Select("select count(*) from user where username=#{username} and password=#{password}")
    public int verifyLoginUser(String username, String password);

    /**
     * 通过id删除用户
     * @param id
     */
    @Delete("DELETE FROM user WHERE id=#{id}")
    public void deleteById(Integer id);

    /**
     * Options 注解说明id是自增类型的，插入后自动返回值到实体类的id
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    public int insert(User user);

    /**
     * 更新用户密码
     * @param user
     */
    @Update("UPDATE user SET password=#{password} WHERE id=#{id}")
    public void updatePassword(User user);

    /**
     * 获取用户的文件列表
     * @param username
     * @return file
     */
    @Select("select filename,filetype from file where username=#{username}")
    File getFileByUserName(String username);
}