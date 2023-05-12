package com.creational.builder;

/**
 * 简化后的建造者模式，不再使用导演类
 */
public class SimpleBuilder {
    public static void main(String[] args) {
        ProductBuilder mProductBuilder = new ConcreteProductBuilder("Intel i7", "三星16G");
        mProductBuilder.setBoard("微星")
                .setDisplay("2K")
                .setGpu("3080");
        Product product = mProductBuilder.buildProduct();
        System.out.println("Product:" + product);
    }
}

/**
 * 具体的产品类，通常在建造者模式中是一个较为复杂的对象，创建过程也比较复杂
 * 此处进行了一些简化
 */
class Product {
    private String cpu;//必须
    private String ram;//必须Computer
    private String board;//可选
    private String display;//可选
    private String gpu;//可选

    public Product(String cpu, String ram) {
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
interface ProductBuilder {
    ProductBuilder setBoard(String board);

    ProductBuilder setDisplay(String display);

    ProductBuilder setGpu(String gpu);

    Product buildProduct();
}

class ConcreteProductBuilder implements ProductBuilder {
    private Product product;

    public ConcreteProductBuilder(String cpu, String ram) {
        product = new Product(cpu, ram);
    }

    @Override
    public ProductBuilder setBoard(String str) {
        product.setBoard(str);
        return this;
    }

    @Override
    public ProductBuilder setDisplay(String str) {
        product.setDisplay(str);
        return this;
    }

    @Override
    public ProductBuilder setGpu(String str) {
        product.setGpu(str);
        return this;
    }

    @Override
    public Product buildProduct() {
        System.out.println("创建产品！");
        return product;
    }
}
