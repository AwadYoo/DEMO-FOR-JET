package com.demo.proxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author 尤贺雨
 * @create 2019-04-08 9:14
 */
public class HelloTest {

    public static void main(String[] args) {

        HelloService helloService = new HelloServiceImpl();

        HelloInvocationHandle handle = new HelloInvocationHandle(helloService);

        HelloService instance = (HelloService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
                , helloService.getClass().getInterfaces(), handle);
        instance.sayHello();

        test();
    }

    private static void test() {

        IdentityHashMap<String, String> identityHashMap = new IdentityHashMap();

        String a1 = new String("A");
        String a2 = new String("A");

        identityHashMap.put(a1, "2");
        identityHashMap.put(new String("B"), "2");
        identityHashMap.put(a2, "3");

        Map<String, String> map = new HashMap<>();



        map.put(a1, "2");
        map.put(new String("B"), "2");
        map.put(a2, "3");

        System.out.println(identityHashMap);
        System.out.println(map);

        System.out.println(identityHashMap.get(a1));

    }
}
