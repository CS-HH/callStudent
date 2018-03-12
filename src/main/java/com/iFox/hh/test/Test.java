package com.iFox.hh.test;

import com.iFox.hh.utils.MD5Utils;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public class Test {
    public static void main(String[] args) {
        String str = MD5Utils.md5Message("123456");
        System.out.println(str);
    }
}
