package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    // @Insert()
    void create(User user);

    List<User> findAll();

    @Delete("delete from users where id = #{id}")
    void delete(int id);

    int update(User user);

    @Select("select * from users where id = #{id}")
    User selectById(int id);

    @Update("update users set money=money+#{money} where name=#{name}")
    void inMoney(@Param("name") String name, @Param("money") Double money);

    @Update("update users set money=money-#{money} where name=#{name}")
    void outMoney(@Param("name") String name, @Param("money") Double money);

}