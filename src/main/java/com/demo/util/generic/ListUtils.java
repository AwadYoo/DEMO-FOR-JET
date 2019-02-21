package com.demo.util.generic;

import java.util.ArrayList;
import java.util.List;


public class ListUtils {

    public static <T> List<List<T>> splitList(List<T> list, int len) {

        List<List<T>> result = new ArrayList<>();
        int size = list.size();
        int count = (size + len - 1) / len;


        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }

}

