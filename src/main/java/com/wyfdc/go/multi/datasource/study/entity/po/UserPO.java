package com.wyfdc.go.multi.datasource.study.entity.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @Author:   
 */
@Data
@Table(name="user")
public class UserPO {

  @Id
  @Column(name = "id",nullable = false)
  private Long id;

  private String name;

  private String address;

}
