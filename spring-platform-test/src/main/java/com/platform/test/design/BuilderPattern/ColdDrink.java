package com.platform.test.design.BuilderPattern;

/**
 * 喝的饮料
 * @author lin512100
 * @date 2021/8/13
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
