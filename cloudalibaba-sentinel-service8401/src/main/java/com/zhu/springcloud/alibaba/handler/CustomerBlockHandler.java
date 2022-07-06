package com.zhu.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhu.springcloud.entities.CommonResult;
import com.zhu.springcloud.entities.Payment;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception)
    {
        return new CommonResult(444,"按照客户自定义,global handlerException--->!");
    }

    public static CommonResult handlerException2(BlockException exception)
    {
        return new CommonResult(444,"按照客户自定义,global handlerException--->2");
    }
}
