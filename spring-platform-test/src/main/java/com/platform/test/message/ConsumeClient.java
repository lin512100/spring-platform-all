package com.platform.test.message;

/**
 * 消费者客户端
 * @author lin512100
 * @date 2021/7/20
 */
public class ConsumeClient {

    public static void main(String[] args) throws Exception{
        String message = MqClient.consume();
        System.out.println("获取到的消息为：" + message);
    }
}
