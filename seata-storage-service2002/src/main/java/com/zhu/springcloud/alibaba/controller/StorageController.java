package com.zhu.springcloud.alibaba.controller;

import com.zhu.springcloud.alibaba.domain.CommonResult;
import com.zhu.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }
}


