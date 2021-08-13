package com.platform.user.aop.service.impl;

import com.platform.user.aop.annotation.Log;
import com.platform.user.aop.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * 业务实现类
 * @author lin512100
 * @date 2021/6/8
 */
@Service
public class BusinessServiceImpl implements BusinessService {


    /**
     * aop失效解决办法之一 自我注入
     */
    @Resource
    BusinessService businessService;

    @Override
    @Log(module = "业务办理")
    public String push(String id) {
        System.out.printf("业务提交：%s%n", id);
        int simulate = new Random().nextInt(10);
        businessService.notice();
        if (simulate % 2 == 0) {
            throw new IllegalArgumentException("业务办理失败 余额不足");
        }
        return "业务办理成功";
    }

    @Override
    @Log(module = "业务通知")
    public void notice() {
        System.out.println("短信发送成功~~~");
    }
}
