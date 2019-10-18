package com.wyfdc.go.multi.datasource.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @Author:
 */
@Configuration
@tk.mybatis.spring.annotation.MapperScan(basePackages = TestDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "testSqlSessionFactory")
public class TestDataSourceConfig {

  static final String PACKAGE = "com.wyfdc.go.multi.datasource.study.mapper.test";


  @Value("${spring.datasource.test.url}")
  private String url;

  @Value("${spring.datasource.test.username}")
  private String user;

  @Value("${spring.datasource.test.password}")
  private String password;

  @Value("${spring.datasource.test.driverClassName}")
  private String driverClass;


  @Bean(name = "testDataSource")
  public DataSource clusterDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName(driverClass);
    dataSource.setUrl(url);
    dataSource.setUsername(user);
    dataSource.setPassword(password);
    return dataSource;
  }

  @Bean(name = "testTransactionManager")
  public DataSourceTransactionManager clusterTransactionManager() {
    return new DataSourceTransactionManager(clusterDataSource());
  }

  @Bean(name = "testSqlSessionFactory")
  public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource)
      throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    return sessionFactory.getObject();
  }


}
