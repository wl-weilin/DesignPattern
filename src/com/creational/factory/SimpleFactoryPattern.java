package com.creational.factory;

public class SimpleFactoryPattern {
    public static void main(String[] args) {
        Product productA = SimpleFactory.createProduct("A");//工厂类创建产品A
        productA.use();
        Product productB = SimpleFactory.createProduct("B");//工厂类创建产品B
        productB.use();
    }
}

//具体产品类的父类，可以为抽象类或接口
abstract class Product {
    public abstract void use();
}

//各个产品的ConcreteProduct类负责创建具体产品
class ConcreteProductA extends Product {
    @Override
    public void use() {
        System.out.println("使用产品A");
    }
}

class ConcreteProductB extends Product {
    @Override
    public void use() {
        System.out.println("使用产品B");
    }
}

//工厂类负责创建产品的逻辑
class SimpleFactory {
    //使用静态方法，这样就可以不用初始化工厂也可以创建产品
    public static Product createProduct(String type) {
        Product product = null;
        if (type.equals("A")) {
            product = new ConcreteProductA();
        } else if (type.equals("B")) {
            product = new ConcreteProductB();
        } else {
            //若要添加具体产品，还要增加判断逻辑和产品创建代码
        }
        return product;
    }
}