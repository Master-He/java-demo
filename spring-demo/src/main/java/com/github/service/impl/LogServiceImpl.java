package com.github.service.impl;

import com.github.dao.LogDao;
import com.github.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hewenji
 * @Date 2023/5/29 21:33
 */
@Service
public class LogServiceImpl implements LogService {

    private LogDao logDao;

    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    @Override
    public void log(String out, String in, Double money) {
        logDao.log(out + "向" + in + "转了" + money + "元。");
    }

    @Override
    public void logFail(String out, String in, Double money) {
        logDao.log(out + "向" + in + "转账" + money + "元失败。");
    }
}
