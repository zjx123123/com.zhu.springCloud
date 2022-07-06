package com.zhu.springcloud.alibaba.service.impl;

import com.zhu.springcloud.alibaba.dao.AccountDao;
import com.zhu.springcloud.alibaba.service.AccountService;
import org.apache.tomcat.jni.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER= LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        try {
            TimeUnit.SECONDS.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        LOGGER.info("---->acount-service中扣减账户余额开始");
        accountDao.decrease(userId,money);
    }
}
