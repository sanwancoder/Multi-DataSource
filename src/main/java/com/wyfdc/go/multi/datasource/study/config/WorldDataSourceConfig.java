package com.wyfdc.go.multi.datasource.study.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@tk.mybatis.spring.annotation.MapperScan(basePackages = WorldDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "worldSqlSessionFactory")
public class WorldDataSourceConfig {

  static final String PACKAGE = "com.wyfdc.go.multi.datasource.study.mapper.world";
//    static final String MAPPER_LOCATION = "classpath:mapper/aa/*.xml";

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.username}")
  private String user;

  @Value("${spring.datasource.password}")
  private String password;

  @Value("${spring.datasource.driverClassName}")
  private String driverClass;

  @Bean(name = "worldDataSource")
  @Primary
  public DataSource masterDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName(driverClass);
    dataSource.setUrl(url);
    dataSource.setUsername(user);
    dataSource.setPassword(password);
    return dataSource;
  }

  @Bean(name = "worldTransactionManager")
  @Primary
  public DataSourceTransactionManager masterTransactionManager() {
    return new DataSourceTransactionManager(masterDataSource());
  }

  @Bean(name = "worldSqlSessionFactory")
  @Primary
  public SqlSessionFactory masterSqlSessionFactory(@Qualifier("worldDataSource") DataSource dataSource)
      throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    return sessionFactory.getObject();
  }

}
