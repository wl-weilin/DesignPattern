package com.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体同事类持有具体中介者的引用
 * 当需要与其他对象进行通信时，将消息发送给中介者对象进行处理
 */
public class MediatorPattern {
    public static void main(String[] args) {
        // 创建中介者对象
        Mediator mediator = new ConcreteMediator();

        // 创建同事对象
        Colleague colleague1 = new ConcreteColleague("Colleague1", mediator);
        Colleague colleague2 = new ConcreteColleague("Colleague2", mediator);
        Colleague colleague3 = new ConcreteColleague("Colleague3", mediator);

        // 将同事对象添加到中介者中
        ((ConcreteMediator) mediator).addColleague(colleague1);
        ((ConcreteMediator) mediator).addColleague(colleague2);
        ((ConcreteMediator) mediator).addColleague(colleague3);

        // 同事对象发送消息
        colleague1.sendMessage("Hello, colleagues!");
    }
}

/**
 * 中介者接口（Mediator），用于定义对象之间的通信方法
 */
interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

/**
 * 具体中介者类（ConcreteMediator），实现中介者接口，并维护一组同事对象的引用
 */
class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues;

    public ConcreteMediator() {
        colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        for (Colleague c : colleagues) {
            if (c != colleague) {
                c.receiveMessage(message);
            }
        }
    }
}

/**
 * 同事类接口（Colleague），用于定义同事类的通信方法
 */
interface Colleague {
    void sendMessage(String message);

    void receiveMessage(String message);
}

/**
 * 具体的同事类（ConcreteColleague），实现同事类接口，并在需要发送消息时通过中介者来发送消息
 */
class ConcreteColleague implements Colleague {
    private String Name;
    private Mediator mediator;

    public ConcreteColleague(String name, Mediator mediator) {
        this.Name = name;
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(Name + " Received message: " + message);
    }
}
