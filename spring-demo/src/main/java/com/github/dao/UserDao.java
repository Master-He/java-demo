package com.github.dao;

import com.github.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {

    void create(User user);

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