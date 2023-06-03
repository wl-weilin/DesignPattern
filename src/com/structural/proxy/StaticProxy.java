package com.structural.proxy;

public class StaticProxy {
    public static void main(String[] args) {
        ILawsuit xiaomin = new XiaoMin();
        //构造一个代理律师并将小民作为构造参数传递进去
        ILawsuit lawyer = new Lawyer(xiaomin);
        //律师提交诉讼申请
        lawyer.submit();
        //律师进行举证
        lawyer.burden();
        //律师代替小民进行辩护
        lawyer.defend();
        //完成诉讼
        lawyer.finish();

    }
}

interface ILawsuit {
    //提交申请
    void submit();
    //进行举证
    void burden();
    //开始辩护
    void defend();
    //诉讼完成
    void finish ();
}

class XiaoMin implements ILawsuit {
    @Override
    public void submit() {
        //老板欠小民工资小民只好申请仲裁
        System.out.println("老板拖欠工资！特此申请仲裁！");
    }

    @Override
    public void burden() {
        //小民证据充足，不怕告不赢
        System.out.println("这是合同书和过去一年的银行工资流水！");
    }

    @Override
    public void defend() {
        //铁证如山，辩护也没什么好说的
        System.out.println("证据确凿!不需要再说什么了!");
    }

    @Override
    public void finish() {
        //结果也是肯定的，必赢
        System.out.println("诉讼成功！判决老板即日起七天内结算工资！");
    }
}

class Lawyer implements ILawsuit {
    private ILawsuit mLawsuit; //持有一个具体被代理者的引用

    public Lawyer(ILawsuit lawsuit) {
        mLawsuit = lawsuit;
    }

    @Override
    public void submit() {
        mLawsuit.submit();
    }

    @Override
    public void burden() {
        mLawsuit.burden();
    }

    @Override
    public void defend() {
        mLawsuit.defend();
    }

    @Override
    public void finish() {
        mLawsuit.finish();
    }
}