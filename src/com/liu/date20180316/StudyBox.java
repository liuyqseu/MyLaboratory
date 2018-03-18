package com.liu.date20180316;

/**
 * Created by Herry on 2018/3/16.
 * 说明： 主要研究Java中的包装类
 */
public class StudyBox {
    public static void main(String[] args) {

        Integer a = 100, b = 100, c = 150, d = 150;
        Long e = 150l;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(d.equals(e));
        System.out.println(e.equals(d));
    }

}
