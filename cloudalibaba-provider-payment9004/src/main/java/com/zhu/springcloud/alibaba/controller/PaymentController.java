package com.zhu.springcloud.alibaba.controller;

import com.zhu.springcloud.entities.CommonResult;
import com.zhu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    public static HashMap<Long, Payment> map = new HashMap<>();

    static {
        map.put(1L, new Payment(1L, "00c2abb6-5066-45af-bf85-7236c064f53d"));
        map.put(2L, new Payment(2L, "adf19bc4-f206-4cd4-9704-5831e6fa321a"));
        map.put(3L, new Payment(2L, "94767467-2ed7-4bcd-bb68-9c0ab0e3a187"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymenySQL(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        CommonResult commonResult = new CommonResult(200, "from sql ,serverPort:" + serverPort, payment);
        return commonResult;
    }
}