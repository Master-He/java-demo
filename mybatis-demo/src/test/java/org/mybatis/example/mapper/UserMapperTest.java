package org.mybatis.example.mapper;

import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.pojo.Email;
import org.mybatis.example.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author hewenji
 * @Date 2023/5/29 1:00
 */
public class UserMapperTest extends TestCase {
    private static SqlSession sqlSession;
    private static UserMapper userMapper;
    private static SqlSessionFactory sqlSessionFactory;

    @Override
    public void setUp() throws Exception {
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);  // 这里用设置自动提交， insert才会生效
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public void tearDown() throws Exception {
        sqlSession.close();
    }


    public void testSelectAll() {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }

        List<User> users1 = userMapper.selectAllWithResultMap();
        for (User user : users1) {
            System.out.println(user);
        }
    }

    public void testSelectOne() {
        User user = userMapper.selectOne(1);
        System.out.println(user);
    }

    public void testSelectRange() {
        List<User> users = userMapper.selectRange(2, 3);
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void testSelectByEmail() {
        Email email = new Email();
        email.setEmail("lisi@sina.com");
        List<User> users = userMapper.selectByEmail(email);
        for (User user : users) {
            System.out.println(user);
        }
    }


    public void testSelectByName() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "zhangsan");
        List<User> users = userMapper.selectByName(map);
        for (User user : users) {
            System.out.println(user);
        }
    }


    public void testSelectByNameEmail() {
        List<User> users = userMapper.selectByNameEmail("zhangsan", null);
        for (User user : users) {
            System.out.println(user);
        }

        List<User> users2 = userMapper.selectByNameEmail("zhangsan", "zs@sina.com");
        for (User user : users2) {
            System.out.println(user);
        }

        List<User> users3 = userMapper.selectByNameEmail(null, "zs@sina.com");
        for (User user : users3) {
            System.out.println(user);
        }

        List<User> users4 = userMapper.selectByNameEmail(null, null);
        for (User user : users4) {
            System.out.println(user);
        }

    }

    public void testSelectOneDynamic() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "lisi");
        List<User> users = userMapper.selectOneDynamic(map);
        for (User user : users) {
            System.out.println(user);
        }

        Map<String, String> map2 = new HashMap<>();
        map2.put("email", "wangwu@sina.com");
        List<User> users2 = userMapper.selectOneDynamic(map2);
        for (User user : users2) {
            System.out.println(user);
        }

        Map<String, String> map3 = new HashMap<>();
        List<User> users3 = userMapper.selectOneDynamic(map3);
        for (User user : users3) {
            System.out.println(user);
        }
    }

    public void testAdd() throws IOException {
        User user = new User();
        user.setName("F");
        user.setPassword("123");
        user.setEmail("c@qq.com");
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setMoney(1002);
        userMapper.add(user);

        System.out.println("返回的id： " + user.getId());
        // sqlSession.commit();  // 如果没有设置自动提交，则需要执行commit()方法
    }

    public void testUpdateName() throws IOException {
        User user = userMapper.selectOne(11);
        user.setName("hhhwwwjjj");
        int count = userMapper.updateName(user);
        System.out.println("影响行数：" + count);
    }

    public void testUpdateDynamic() {
        User user = new User();
        user.setName("qwer");
        user.setId(11);
        int count = userMapper.updateDynamic(user);
        System.out.println("影响行数：" + count);

        User user2 = new User();
        user2.setMoney(999);
        user2.setId(11);
        count = userMapper.updateDynamic(user2);
        System.out.println("影响行数：" + count);
    }

    public void testDeleteById() {
        userMapper.deleteById(12);
    }

    public void testDeleteByIds() {
        userMapper.deleteByIds(new int[]{8,9,10});
    }

    public void testCache() {
        // 一级缓存测试（默认开启的，session关闭后失效）， 开启logback debug, 然后查看session是不是只查了一次
        User user = userMapper.selectOne(1);
        System.out.println(user);

        User user1 = userMapper.selectOne(1);
        System.out.println(user);

        System.out.println(user==user1);
    }

    public void testSecondCache() throws IOException {
        User user = userMapper.selectOne(1);
        System.out.println(user);
        sqlSession.close(); // session关闭后一级缓存会丢到二级缓存， 二级缓存才会生效

        // 重新开启session,命中缓存， 日志打印: Cache Hit Ratio [org.mybatis.example.mapper.UserMapper]: 0.5
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);

        User user1 = userMapper.selectOne(1);
        System.out.println(user);

        System.out.println(user==user1);  // true


    }
}