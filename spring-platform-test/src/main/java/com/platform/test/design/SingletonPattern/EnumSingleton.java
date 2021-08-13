package com.platform.test.design.SingletonPattern;

/**
 * JVM会保证enum不能被反射并且构造器方法只执行一次
 * @author lin512100
 * @date 2021/8/12
 */
public enum EnumSingleton {
    /**
     * 单例
     */
    INSTANCE;

    private final Resource instance;

    EnumSingleton() {
        instance = new Resource();
    }

    public Resource getInstance() {
        return instance;
    }

}
