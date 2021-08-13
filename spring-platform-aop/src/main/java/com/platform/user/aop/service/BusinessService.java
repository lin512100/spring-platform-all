package com.platform.user.aop.service;

/**
 * 业务服务接口
 * @author lin512100
 * @date 2021/6/8
 */
public interface BusinessService {

    /**
     * 业务办理
     * @param id 订单编号
     * @return 返回值
     */
    String push(String id);

    /**
     * 业务通知
     * */
    void notice();
}
