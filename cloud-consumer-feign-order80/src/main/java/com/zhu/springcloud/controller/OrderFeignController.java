package com.zhu.springcloud.controller;

import com.zhu.springcloud.service.PaymentFeignService;
import com.zhu.springcloud.entities.CommonResult;
import com.zhu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){

        return  paymentFeignService.getPaymentById(id);

    }
}
