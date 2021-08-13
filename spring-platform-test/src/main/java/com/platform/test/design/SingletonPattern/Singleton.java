package com.platform.test.design.SingletonPattern;

/**
 * 可能会被反序列化
 * @author lin512100
 * @date 2021/8/12
 */
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
