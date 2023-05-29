package com.github.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author hewenji
 * @Date 2023/5/29 21:34
 */
public interface LogDao {

    @Insert("insert into log(info,createDate) values(#{info},now())")
    void log(@Param("info") String info);

}
