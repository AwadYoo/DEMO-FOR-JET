package com.deemo.util.generic;

import org.junit.Test;

import java.util.Arrays;

public class GenericTestTest {



    @Test
    public void splitList() {
        System.out.println(GenericTest.splitList(Arrays.asList(1, 2, 2), 2));
    }
}