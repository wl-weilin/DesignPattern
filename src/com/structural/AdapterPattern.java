package com.structural;

/**
 * 三孔插座转两孔插座
 */
public class AdapterPattern {
    public static void main(String[] args) {
        new Exception().printStackTrace();
        System.out.println(Thread.currentThread());
        Target newPlug = new ClassAdapter();
        // 对于使用者来说，它只需要知道适配器提供了一个两孔插头即可
        newPlug.doubleHoleSocket();
        System.out.println("这是一个两孔插头");
    }
}

/**
 * 目标接口（Target）,适配器要实现的接口
 */
interface Target {
    public void doubleHoleSocket();
}

/**
 * 源接口（Adaptee），原本不兼容的接口
 */
interface Adaptee {
    /**
     * 需要被适配的功能
     * 这里用插座转换举例
     */
    void threeHoleSocket();
}

/**
 * 源接口的实现类
 */
class AdapteeImpl implements Adaptee {
    @Override
    public void threeHoleSocket() {
        System.out.println("这是一个三孔插座。");
    }
}

/**
 * 类适配器模式
 */
class ClassAdapter implements Target, Adaptee {

    @Override
    public void doubleHoleSocket() {
        System.out.println("这是一个两孔插座。");
    }

    @Override
    public void threeHoleSocket() {
        System.out.println("==========开始转换==========");
        System.out.println("oh，我变成了两孔插座");
    }
}

/**
 * 对象适配器模式
 * 适配器类（Adapter），实现目标接口，并持有源接口的实例
 * 通过适配器类来实现目标接口的方法
 */
class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter() {
        this.adaptee = new AdapteeImpl();
    }

    @Override
    public void doubleHoleSocket() {
        // 调用继承的方法，对其进行增强或处理
        this.adaptee.threeHoleSocket();
        System.out.println("==========开始转换==========");
        System.out.println("oh，我变成了两孔插座");
    }
}

