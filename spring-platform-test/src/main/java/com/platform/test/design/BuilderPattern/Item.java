package com.platform.test.design.BuilderPattern;

public interface Item {

    /**
     * 姓名
     */
    public String name();

    /**
     * 打包方式
     */
    public Packing packing();

    /**
     * 价格
     */
    public float price();

}
