package com.wyfdc.go.multi.datasource.study.mapper.world;

import static org.junit.jupiter.api.Assertions.*;

import com.alibaba.fastjson.JSON;
import com.wyfdc.go.multi.datasource.study.StudyApplication;
import com.wyfdc.go.multi.datasource.study.entity.po.CityPO;
import com.wyfdc.go.multi.datasource.study.entity.po.UserPO;
import com.wyfdc.go.multi.datasource.study.mapper.test.UserMapper;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author:   
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudyApplication.class )//这里是启动类
public class CityMapperTest {

  @Autowired
  private CityMapper cityMapper;

  @Autowired
  private UserMapper userMapper;

  @BeforeEach
  void setUp() {
    System.out.println("=====================================");
  }

  @AfterEach
  void tearDown() {
    System.out.println("=====================================");
  }

  @Test
  public void test1(){
    List<CityPO> citys = cityMapper.selectAll();
    citys.forEach(x->{
      System.out.println(JSON.toJSONString(x));
    });
  }

  @Test
  public void test2(){
    List<UserPO> pos = userMapper.selectAll();
    pos.forEach(x->{
      System.out.println(JSON.toJSONString(x));
    });
  }

}
