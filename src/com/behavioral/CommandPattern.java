package com.behavioral;

/**
 * 以开关灯为例实现命令模式
 * 使用者向灯发送命令，由灯执行具体命令
 */
public class CommandPattern {
    public static void main(String[] args) {
        // 请求接收者（Receiver）
        Light light = new Light();
        // 请求发送者（Invoker）
        RemoteControl remoteControl = new RemoteControl();

        // 生成具体的命令
        Command lightOnCommand = new LightOnCommand(light);
        //传送或设置命令
        remoteControl.setCommand(lightOnCommand);
        // 执行命令，最后是由具体的命令类（ConcreteCommand），即LightOnCommand执行的
        // Light is on
        remoteControl.pressButton();

        // 关灯的执行拖成
        Command lightOffCommand = new LightOffCommand(light);
        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton(); // Light is off
    }
}

/**
 * 定义抽象命令接口（Command）
 */
interface Command {
    void execute();
}

/**
 * 具体的命令类（ConcreteCommand），实现抽象命令接口
 */
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

/**
 * 请求接收者（Receiver）
 */
class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

/**
 * 请求发送者（Invoker）
 */
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}