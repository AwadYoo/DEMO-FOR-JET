package com.demo.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author awad_yoo
 * @create 2019-04-29 09:39
 */
public class Test {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();

        map.put("f",1);
        map.put("s",1);

        int hashCode = Objects.hashCode("s");

        int i = hashCode % map.size();
        System.out.println(i);


    }
}
