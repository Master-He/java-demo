package com.github.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author hewenji
 * @Date 2023/5/29 14:12
 */
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        // org.mybatis.spring 提供了 SqlSessionFactoryBean， 用来创建SqlSessionFactory
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        /*
            数据源和连接池 分类
            1. C3P0
            2. DBCP  mybatis默认的
            3. HikariCP
            4. Proxool
            5. Druid  // 用这个
            6. org.springframework.jdbc.datasource.DriverManagerDataSource
        */
        sqlSessionFactoryBean.setDataSource(dataSource);
        // sqlSessionFactoryBean.setTypeAliasesPackage("com.github.dao");  // 就可以用简化名了

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        /*
        mapperScannerConfigurer是mybatis-spring提供的一个转换器，可以将映射接口转换为Spring容器中的Bean
        这里将com.github.dao包下的UserDao转换成Spring 容器中的 Bean
        然后就可以直接在service层直接 注入 UserDao了

        */
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.github.dao");
        return msc;
    }

}
