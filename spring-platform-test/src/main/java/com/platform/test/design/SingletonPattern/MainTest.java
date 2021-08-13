package com.platform.test.design.SingletonPattern;

public class MainTest {
    public static void main(String[] args) {

        Resource instance = EnumSingleton.INSTANCE.getInstance();

        Singleton singleton = Singleton.getInstance();
    }
}
