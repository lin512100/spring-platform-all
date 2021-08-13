package com.platform.test.message;

/**
 * 消息生产者
 * @author lin512100
 * @date 2021/7/20
 */
public class ProductClient {

    public static void main(String[] args) throws Exception{
        MqClient.produce("Hello World");
    }
    
}
