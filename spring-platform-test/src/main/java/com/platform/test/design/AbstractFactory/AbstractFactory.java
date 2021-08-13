package com.platform.test.design.AbstractFactory;

/**
 * 抽象工厂模式
 * @author lin512100
 * @date 2021/8/13
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape) ;
}
