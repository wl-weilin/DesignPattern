package com.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者(Observer)模式
 * 又称为发布-订阅模式
 */
public class ObserverPattern {
    public static void main(String[] args) {
        // 创建具体主题对象
        Subject subject = new ConcreteSubject();

        // 创建具体观察者对象
        Observer observer1 = new ConcreteObserver("observer1");
        Observer observer2 = new ConcreteObserver("observer2");

        // 注册观察者
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        // 被观察者改变状态，并向已注册的观察者发布通知
        subject.setState(100);
        subject.notifyObservers();
    }
}

/**
 * 抽象主题（Subject）接口，用于注册、移除和通知观察者
 */
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    void setState(int state);

    int getState();
}

/**
 * 具体主题（ConcreteSubject）类，实现抽象主题接口，并维护观察者列表
 */
class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

/**
 * 抽象观察者（Observer）接口，用于接收通知和更新
 */
interface Observer {
    void update(ConcreteSubject subject);
}

/**
 * 具体观察者（ConcreteObserver）类，实现抽象观察者接口
 */
class ConcreteObserver implements Observer {
    private final String observerName;

    ConcreteObserver(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(ConcreteSubject subject) {
        int state = subject.getState();
        System.out.println(observerName + " get notification and subject state changed to: " + state);
    }
}











