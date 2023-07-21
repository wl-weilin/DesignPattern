package com.structural;

/**
 * 桥接模式示例，本例中的Shape和Color之间就是通过桥接模式联系的
 */
public class BridgePattern {
    // 通过组合关系将实现部分和抽象部分联系到一起
    // 其中形状为抽象部分，颜色为实现部分
    public static void main(String[] args) {
        // 画一个红色的圈
        Shape redCircle = new Circle(new RedColor());
        redCircle.draw();

        Shape blueCircle = new Circle(new BlueColor());
        blueCircle.draw();
    }
}

/**
 * 定义抽象部分的接口（Abstraction）
 */
abstract class Shape {
    Color mColor ;
    abstract void draw();
}
/**
 * 定义实现部分的接口（Implementor）
 */
abstract class Color {
    abstract void applyColor();
}

/**
 * 创建具体的抽象部分（Refined Abstraction）
 */
class Circle extends Shape {
    public Circle(Color color) {
        mColor = color;
    }

    @Override
    public void draw() {
        System.out.print("Drawing Circle with ");
        mColor.applyColor();
    }
}

/**
 * 创建具体的实现部分（Concrete Implementor）
 */
class RedColor extends Color {
    @Override
    public void applyColor() {
        System.out.println("Red Color");
    }
}

class BlueColor extends Color {
    @Override
    public void applyColor() {
        System.out.println("Blue Color");
    }
}