package com.zhu.springcloud.alibaba.controller;

import com.zhu.springcloud.alibaba.domain.CommonResult;
import com.zhu.springcloud.alibaba.domain.Order;
import com.zhu.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;
    @GetMapping("/order/create")
    public CommonResult creatOrder(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");

    }
}
