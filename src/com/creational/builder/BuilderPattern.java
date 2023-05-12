package com.creational.builder;

/**
 * 使用建造者模式模拟构建一台电脑
 */
public class BuilderPattern {
    public static void main(String[] args) {
        //创建一个实际建造类，传入必要参数
        ComputerBuilder lenovoBuilder = new LenovoComputerBuilder("Intel i7", "三星16G");
        //导演类构造一个使用Builder接口的对象，与实际Builder类直接交互
        ComputerDirector director = new ComputerDirector(lenovoBuilder);
        //导演类通过持有的Builder引用，对实际建造者类进行操作（即可选组件的构建）
        director.construct("微星", "2K", "3080");
        //实际建造者类返回实例
        ComputerProduct lenovoComputer = lenovoBuilder.buildComputer();
        System.out.println("Lenovo Computer:" + lenovoComputer.toString());

        ComputerBuilder macBuilder = new MacComputerBuilder("Apple M1", "海力士8G");
        director = new ComputerDirector(macBuilder);
        director.construct();
        ComputerProduct macComputer = macBuilder.buildComputer();
        System.out.println("Mac Computer:" + macComputer.toString());
    }
}

/**
 * Director被用来封装程序中易变的部分，
 * 如Product对象各种不同的参数设置，在Director类中有不同的构造函数
 */
class ComputerDirector {
    ComputerBuilder mBuilder;
    //可选属性的默认参数
    String mBoard = "华硕";
    String mDisplay = "LG";
    String mGpu = "3060Ti";

    public ComputerDirector(ComputerBuilder builder) {
        mBuilder = builder;
    }

    public void construct(String board, String display, String gpu) {
        mBuilder.setBoard(board);
        mBuilder.setDisplay(display);
        mBuilder.setGpu(gpu);
    }

    public void construct(String mainboard, String display) {
        this.construct(mainboard, display, mGpu);
    }

    public void construct() {
        this.construct(mBoard, mDisplay, mGpu);
    }
}

/**
 * 具体的产品类，通常在建造者模式中是一个较为复杂的对象，创建过程也比较复杂
 * 此处进行了一些简化
 */
class ComputerProduct {
    private String cpu;//必须
    private String ram;//必须Computer
    private String board;//可选
    private String display;//可选
    private String gpu;//可选

    public ComputerProduct(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", ram=" + ram +
                ", board=" + board +
                ", display=" + display +
                ", gpu=" + gpu +
                '}';
    }
}

/**
 * 引入抽象建造者是为了将建造的具体过程交给它的子类来实现，这样更容易扩展
 */
interface ComputerBuilder {
    void setBoard(String board);

    void setDisplay(String display);

    void setGpu(String gpu);

    ComputerProduct buildComputer();
}

class LenovoComputerBuilder implements ComputerBuilder {
    private ComputerProduct computer;

    public LenovoComputerBuilder(String cpu, String ram) {
        computer = new ComputerProduct(cpu, ram);
    }

    @Override
    public void setBoard(String str) {
        computer.setBoard(str);
    }

    @Override
    public void setDisplay(String str) {
        computer.setDisplay(str);
    }

    @Override
    public void setGpu(String str) {
        computer.setGpu(str);
    }

    @Override
    public ComputerProduct buildComputer() {
        System.out.println("创建LenovoComputer产品！");
        return computer;
    }
}

/**
 * 某个具体产品MacComputer的建造类
 */
class MacComputerBuilder implements ComputerBuilder {
    private ComputerProduct computer;

    public MacComputerBuilder(String cpu, String ram) {
        computer = new ComputerProduct(cpu, ram);
    }

    @Override
    public void setBoard(String str) {
        computer.setBoard(str);
    }

    @Override
    public void setDisplay(String str) {
        computer.setDisplay(str);
    }

    @Override
    public void setGpu(String str) {
        computer.setGpu(str);
    }

    @Override
    public ComputerProduct buildComputer() {
        System.out.println("创建MacComputer产品！");
        return computer;
    }
}