package com.github.service.impl;

import com.github.config.SpringConfig;
import com.github.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hewenji
 * @Date 2023/5/29 19:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void transfer() {

        // spring事务测试
        accountService.transfer("zhangsan", "lisi", 100D);

    }
}