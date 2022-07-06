package com.zhu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.zhu.springcloud.alibaba.dao"})
public class MybaitsConfig {

}
