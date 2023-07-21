package com.structural;

/**
 * 三孔插座（源接口）转两孔插座（目标接口）
 */
public class AdapterPattern {
    // 在客户端代码中，通过目标适配器接口来使用对象
    // 对使用者来说，只需要知道适配器提供了一个两孔插座即可，对于适配的细节不需要了解
    public static void main(String[] args) {
        // 类适配器模式
        Target target1 = new ClassAdapter();
        target1.doubleHoleSocket();
        System.out.println();

        // 对象适配器模式
        Target target2 = new ObjectAdapter();
        target2.doubleHoleSocket();
    }
}

/**
 * 目标接口（Target）,适配器要实现的接口
 * 两孔插座
 */
interface Target {
    void doubleHoleSocket();
}

/**
 * 源接口（Adaptee），原本不兼容的接口
 * 三孔插座
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
 * 实现三孔插座
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
class ClassAdapter extends AdapteeImpl implements Target {

    @Override
    public void doubleHoleSocket() {
        this.threeHoleSocket();
        System.out.println("==========类适配器-开始转换==========");
        System.out.println("变成了一个两孔插座。");
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
        // 调用继承的方法，对其进行适配处理
        this.adaptee.threeHoleSocket();
        System.out.println("==========对象适配器-开始转换==========");
        System.out.println("变成了一个两孔插座。");
    }
}

