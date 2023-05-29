package com.github.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hewenji
 * @Date 2023/5/29 21:33
 */
public interface LogService {
    // 事务的传播行为
    @Transactional(propagation = Propagation.REQUIRES_NEW) // 外层事务失败了，不影响我的事务
    // @Transactional()
    void log(String out, String in, Double money);

    @Transactional(propagation = Propagation.REQUIRES_NEW) // 外层事务失败了，不影响我的事务
    void logFail(String out, String in, Double money);
}
