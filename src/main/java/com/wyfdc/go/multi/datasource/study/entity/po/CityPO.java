package com.wyfdc.go.multi.datasource.study.entity.po;

import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;

/**
 * @Author:   
 */
@Data
@Table(name="city")
public class CityPO {

  @Column(name = "ID")
  private Long id;

  @Column(name = "Name")
  private String name;

  @Column(name = "CountryCode")
  private String countryCode;

  @Column(name = "District")
  private String district;

  @Column(name = "Population")
  private String population;


}
