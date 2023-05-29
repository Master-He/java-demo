package org.mybatis.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.example.pojo.Email;
import org.mybatis.example.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author hewenji
 * @Date 2023/5/28 21:37
 * 和UserMapper.xml 相同目录，且相同路径
 */
public interface UserMapper {
    List<User> selectAll();

    List<User> selectAllWithResultMap();


    User selectOne(int id);

    // 注解开发，但是只能做一些简单的操作， 复杂的操作用xml
    /*
    * @Select
    * @Insert
    * @Update
    * @Delete
    * */
    @Select("select * from users where id=1")
    User selectFirst();

    /**
     * 多条件查询
     * 1. 散装参数
     * 2. 对象参数
     * 3. map参数
     */
    List<User> selectRange(@Param("startID") int startID, @Param("endID")int endID);
    List<User> selectByEmail(Email email);
    List<User> selectByName(Map map);

    /*
        动态条件查询
        有些条件有时候有，有时候为空

        if
        choose(when, otherwise)
        trim(where, set)
        foreach

        参考官方文档： https://mybatis.org/mybatis-3/zh/dynamic-sql.html
    */
    // 多条件动态查询
    List<User> selectByNameEmail(@Param("name")String name, @Param("email")String email);
    // 单条件动态查询
    List<User> selectOneDynamic(Map map);


    // 添加
    void add(User user);

    // 修改, 返回影响行数
    int updateName(User user);
    // 动态修改，有些字段不存在
    int updateDynamic(User user);

    // 删除
    void deleteById(int id);
    // 批量删除, 注意集合要加@Param
    void deleteByIds(@Param("ids") int[] ids);

    // 扩展： mybatis参数传递
    /*
    1. 单个参数：
        1. pojo类型
        2. map集合
        3. collection， 封装成map集合， 可以通过@Param注解修改arg键名
            map.put("arg0", collection集合);
            map.put("collection", collection集合);
        4. List， 封装成map集合， 可以通过@Param注解修改arg键名
            map.put("arg0", list集合);
            map.put("collection", list集合);
            map.put("list", list集合);
        5. Array， 封装成map集合， 可以通过@Param注解修改arg键名
            map.put("arg0", 数组);
            map.put("array", 数组);
        6. 其他类型
    2. 多个参数： mybatis会帮你封装成一个map集合， 可以通过@Param注解修改arg键名
        假如有两个参数
        map.put("arg0", 值0)
        map.put("arg1", 值1)
        map.put("param0", 值0)
        map.put("param1", 值1)


    mybatis 提供了 ParamNameResolver 类来进行参数封装,  getNamedParams()对多个参数封装成map集合
    */


    // mybatis缓存
    /*
    * 1. 默认开启一级缓存， sqlsession级别的缓存，也称本地会话， sqlsession如果close就没了
    * 2. 二级缓存需要手动开启，手动配置， 它基于namespace(也就是一个接口对应一个缓存)
    *    mybatis定义了缓存接口Cache, 通过实现Cache接口来定义二级缓存
    *
    * */
}
