package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/*  @Configuration：@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
                    这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
                    并用于构建bean定义，初始化Spring容器。
*
*
*
* */

@Configuration
@MapperScan(basePackages = "com.example.db1.dao",sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSource1Config {

    /*
     * 生成数据源. @Primary注解声明为默认数据源
     * 多数据源的使用
     * */
    @Bean(name = "db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.db1")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /*
     * 创建SqlSessionFactory
     * */
    @Bean(name = "db1SqlSessionFactory") @Primary

    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    /*
     * 配置事务管理
     * */
    @Bean(name = "db1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);

    }
     @Bean(name = "db1SqlSessionTemplate")
     @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {

        return new SqlSessionTemplate(sqlSessionFactory);

    }
}

