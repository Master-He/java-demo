package com.example.demo.dao;

import com.example.demo.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hewenji
 * @Date 2023/7/15 19:40
 */
@Mapper
@Repository
public interface LogDao {

    @Select("select * from log")
    public List<Log> findAll();

}
