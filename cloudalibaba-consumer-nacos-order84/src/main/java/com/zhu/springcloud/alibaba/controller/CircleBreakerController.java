package com.zhu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zhu.springcloud.alibaba.service.PaymentService;
import com.zhu.springcloud.entities.CommonResult;
import com.zhu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVER_URL="http://nacos-payment-provider";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private PaymentService paymentService;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") 没有配置
    @SentinelResource(value ="fallback",fallback = "handlerFallback") //fallback只负责业务异常
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVER_URL + "/paymentSQL/" + id, CommonResult.class, id);

          if (id==4)
         {
            throw  new IllegalArgumentException("IllegalArgumentException，非法参数异常");
         }else if (result.getData()==null)
         {
            throw new NullPointerException("NullPointerException,该ID没有对应的记录，空指针异常");
         }
        return result;
    }


    public CommonResult<Payment> handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容"+e.getMessage(),payment);

    }

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymenySQL(@PathVariable("id")Long id){
        CommonResult<Payment> paymentCommonResult = paymentService.paymenySQL(id);
        return paymentCommonResult;
    }
}
