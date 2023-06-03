package com.creational.factory;

/**
 * 使用到了简单工厂模式中的部分代码
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        Product productA = factory1.createProductA();
        productA.use();

        Product productB = factory1.createProductB();
        productB.use();

    }
}

// 提供创建产品的接口，包含多个创建产品的方法
abstract class AbstractFactory {
    public abstract Product createProductA();

    public abstract Product createProductB();
}

//实际工厂类负责创建产品的逻辑
class ConcreteFactory1 extends AbstractFactory {
    @Override
    public Product createProductA() {
        return new ConcreteProductA();
    }

    @Override
    public Product createProductB() {
        return new ConcreteProductB();
    }
}

