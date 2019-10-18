package com.wyfdc.go.multi.datasource.study.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author:   
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
