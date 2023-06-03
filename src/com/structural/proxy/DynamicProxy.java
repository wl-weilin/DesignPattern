package com.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object obj; //被代理的类引用

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用被代理类对象的方法，调用之前代理类也可以做一些其它操作
        Object result = method.invoke(obj, args);
        return result;
    }

    public static void main(String[] args) {
        //构造一个小民……
        ILawsuit xiaomin = new XiaoMin();
        //构造一个动态代理
        DynamicProxy proxy = new DynamicProxy(xiaomin);
        //获取被代理类小民的ClassLoader
        ClassLoader loader = xiaomin.getClass().getClassLoader();
        //动态构造一个代理者律师
        ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(loader, new Class[]{ILawsuit.class}, proxy);
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
