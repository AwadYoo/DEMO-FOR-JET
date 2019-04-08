package com.demo.zip;



import java.io.*;

/**
 * @author 尤贺雨
 * @create 2019-04-08 14:05
 */
public class ZipTest {

    public static void main(String[] args) throws IOException {
        ZipUtils.createZip("D:\\360Downloads","D:\\kate.zip");
        //ZipUtils.createZipDemo("C:\\Apps\\ssr","C:\\Users\\chenny\\Desktop\\kate.zip");
        System.out.println("create zip success!");
    }

}
