//package com.creational.factory;
//
//public class FactoryMethodPattern {
//    public static void main(String[] args) {
//        // 先创建工厂A
//        MethodFactory factoryA = new ConcreteFactoryA();
//        // 工厂A中创建产品A
//        Product productA = factoryA.createProduct();
//        // 使用产品A
//        productA.use();
//
//        MethodFactory factoryB = new ConcreteFactoryB();
//        Product productB = factoryB.createProduct();
//        productB.use();
//    }
//}
//
//// 所有具体工厂的父类
//abstract class MethodFactory {
//    public abstract Product createProduct();
//}
//
//// 具体工厂类负责创建产品
//class ConcreteFactoryA extends MethodFactory {
//    @Override
//    public Product createProduct() {
//        return new ConcreteProductA();
//    }
//}
//
//// 具体工厂类负责创建产品
//class ConcreteFactoryB extends MethodFactory {
//    @Override
//    public Product createProduct() {
//        return new ConcreteProductB();
//    }
//}