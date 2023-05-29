package com.github.service;

import com.github.pojo.User;

/**
 * @author hewenji
 * @Date 2023/5/29 15:00
 */
public interface UserService {
    void create(User user);
    void delete(int id);
    int update(User user);
    User selectById(int id);
}
