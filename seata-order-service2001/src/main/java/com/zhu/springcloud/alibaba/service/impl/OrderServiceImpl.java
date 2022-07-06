package com.zhu.springcloud.alibaba.service.impl;

import com.zhu.springcloud.alibaba.dao.OrderDao;
import com.zhu.springcloud.alibaba.domain.Order;
import com.zhu.springcloud.alibaba.service.AccountService;
import com.zhu.springcloud.alibaba.service.OrderService;
import com.zhu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    @Override
    @GlobalTransactional(name = "fsp_word",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("---->开始新建订单");
        orderDao.create(order);

        log.info("---->订单微服务开始调用库存，库减Count ");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("---->订单微服务开始调用账户，扣钱操作");
        accountService.decrease(order.getUserId(),order.getMoney());

        //4.修改订单的状态
        log.info("---->修改订单状态开始");
        orderDao.update(order.getUserId(),0);

    }
}
