package com.platform.test.design.FactoryMethodPattern;

public class ConcreteFactory extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
