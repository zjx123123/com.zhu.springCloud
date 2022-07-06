package com.zhu.springclou.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements  PaymentHystrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_Ok./(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_TimeOut./(ㄒoㄒ)/~~";
    }
}
