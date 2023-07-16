package com.example.demo.dao;

import com.example.demo.pojo.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hewenji
 * @Date 2023/7/15 19:43
 */
@SpringBootTest
class LogDaoTest {

    @Autowired
    private LogDao logDao;

    @Test
    public void testGetLogDao() {
        // List<Log> logList = logDao.findAll();
        // for (Log log : logList) {
        //     System.out.println(log);
        // }
    }

}