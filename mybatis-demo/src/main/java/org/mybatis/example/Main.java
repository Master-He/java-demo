package org.mybatis.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.mapper.UserMapper;
import org.mybatis.example.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hewenji
 * @Date 2023/5/28 21:01
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {

            UserMapper userMapper = session.getMapper(UserMapper.class);

            List<User> users = userMapper.selectAll();
            for (User user : users) {
                System.out.println(user);
            }

            User user = userMapper.selectOne(1);
            System.out.println(user);

            User user1 = userMapper.selectFirst();
            System.out.println(user1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 其他测试可以看 org.mybatis.example.mapper.UserMapperTest
    }
}
