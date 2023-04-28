package com.Structural;

/**
 * 装饰者(Decorator)模式示例
 */
public class Decorator {
    public static void main(String[] args) {

        // 原始的DarkRoast咖啡
        Coffee coffee1 = new DarkRoast();
        System.out.println(coffee1.getDescription()
                + " $" + coffee1.cost());

        // 加两份Mocha和一份Whip
        Coffee coffee2 = new DarkRoast();
        coffee2 = new Mocha(coffee2);
        coffee2 = new Mocha(coffee2);
        coffee2 = new Whip(coffee2);
        System.out.println(coffee2.getDescription()
                + " $" + coffee2.cost());

        // 加一份Mocha和一份Whip
        Coffee coffee3 = new DarkRoast();
        coffee3 = new Mocha(coffee3);
        coffee3 = new Whip(coffee3);
        System.out.println(coffee3.getDescription()
                + " $" + coffee3.cost());
    }
}

/**
 * 抽象组件(抽象被装饰类)——基本的咖啡类
 * 作用：定义接口，装饰器和具体组件都要实现这个接口或者抽象类。
 */
abstract class Coffee {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

/**
 * 具体组件(具体被装饰类)——DarkRoast（焦炒）表示一种具体的咖啡，也是被装饰者
 * 它继承抽象的被装饰者类，并实现其中的抽象方法。
 */
class DarkRoast extends Coffee {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    public double cost() {
        return 0.99;
    }
}

/**
 * 抽象装饰者类——CondimentDecorator（调味品装饰类）
 * 1.抽象装饰者类中继承该抽象类以保持接口规范
 * 2.包含该抽象类的引用以通过多态的方式对多种被装饰者类进行装饰。
 */
abstract class CondimentDecorator extends Coffee {
    Coffee coffee;
}

/**
 * 装饰者类——奶泡
 * 给具体被装饰类DarkRoast加入奶泡
 */
class Whip extends CondimentDecorator {
    public Whip(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + ", Whip";
    }

    public double cost() {
        return 0.10 + coffee.cost();
    }
}

/**
 * 装饰者类——摩卡
 * 给具体被装饰类DarkRoast加入摩卡
 */
class Mocha extends CondimentDecorator {
    public Mocha(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + ", Mocha";
    }

    public double cost() {
        return 0.20 + coffee.cost();
    }
}