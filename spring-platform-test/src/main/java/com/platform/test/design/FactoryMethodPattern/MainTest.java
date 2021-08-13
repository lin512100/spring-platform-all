package com.platform.test.design.FactoryMethodPattern;

public class MainTest {

    public static void main(String[] args) {
        ConcreteFactory concreteFactory = new ConcreteFactory();
        Product product = concreteFactory.factoryMethod();
        product.user();
    }
}
