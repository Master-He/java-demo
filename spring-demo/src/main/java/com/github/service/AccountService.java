package com.github.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author hewenji
 * @Date 2023/5/29 19:05
 */
public interface AccountService {
    // 转账
    // 规范是写在接口上, 而已要告诉SpringConfig你开启了事务
    // 注意，有些异常发生后是不会回滚的，需要设置
    @Transactional(rollbackFor = {IOException.class})
    void transfer(String user1, String user2, Double money);
}
