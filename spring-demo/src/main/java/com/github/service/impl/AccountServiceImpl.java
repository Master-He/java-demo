package com.github.service.impl;

import com.github.dao.UserDao;
import com.github.service.AccountService;
import com.github.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hewenji
 * @Date 2023/5/29 19:07
 */
@Service
public class AccountServiceImpl implements AccountService {

    private UserDao userDao;
    private LogService logService;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void transfer(String user1, String user2, Double money) {
        // user1 给 user2转钱

        try {
            userDao.outMoney(user1, money);
            // int a = 1/0;
            userDao.inMoney(user2, money);
        } catch (Exception e) {
            logService.logFail(user1, user2, money);
            throw e;
        }
        logService.log(user1, user2, money);
    }
}
