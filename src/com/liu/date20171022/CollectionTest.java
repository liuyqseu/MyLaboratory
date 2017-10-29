package com.liu.date20171022;

import java.util.*;

/**
 * Created by Herry on 2017/10/22.
 */
public class CollectionTest {

    private boolean bool;
    private byte b;
    private short s;
    private char c;
    private int i;
    private long l;
    private float f;
    private double d;
    private String str;
    private String[] strArray;


    // 静态成员变量
    private static boolean boolStatic;
    private static byte bStatic;
    private static short sStatic;
    private static char cStatic;
    private static int iStatic;
    private static long lStatic;
    private static float fStatic;
    private static double dStatic;
    private static String strStatic;
    private static String[] strArrayStatic;

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.testGo();
    }

    public void testGo() {
        System.out.println("静态成员变量默认值：");
        System.out.println("boolean:" + boolStatic);
        System.out.println("byte:" + bStatic);
        System.out.println("short:" + sStatic);
        System.out.println("char:" + cStatic);
        System.out.println("int:" + iStatic);
        System.out.println("long:" + lStatic);
        System.out.println("float:" + fStatic);
        System.out.println("double:" + dStatic);
        System.out.println("String:" + strStatic);
        System.out.println("String[]:" + strArrayStatic);
    }






}
