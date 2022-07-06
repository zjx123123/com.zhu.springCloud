package com.zhu.springcloud.alibaba.service;

import com.zhu.springcloud.entities.CommonResult;
import com.zhu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymenySQL(Long id) {
        return new CommonResult<>(444,"服务降级，--PaymentFallbackService",new Payment(id,"errorserial"));
    }
}
