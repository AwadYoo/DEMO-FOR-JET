package com.demo.proxy;

/**
 * @author 尤贺雨
 * @create 2019-04-08 9:20
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("这是 com.demo.proxy.HelloServiceImpl.sayHello() 方法");
    }
}
