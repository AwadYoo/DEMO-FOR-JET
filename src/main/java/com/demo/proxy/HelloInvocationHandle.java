package com.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 尤贺雨
 * @create 2019-04-08 9:21
 */
public class HelloInvocationHandle implements InvocationHandler {

    private Object target;

    public HelloInvocationHandle(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理开始：");
        Object invoke = method.invoke(target, args);
        System.out.println("代理结束：");
        return invoke;
    }
}
