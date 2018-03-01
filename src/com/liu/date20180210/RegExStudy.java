package com.liu.date20180210;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Herry on 2018/2/10.
 * 说明： 用于学习正则表达式时的测试
 * 笔记： 正则表达式总结来说是用于字符串的匹配、获取、分割、替代
 */
public class RegExStudy {

    public static void main(String[] args) {

        //测试匹配方法
        String regStr1 = "(\\w+):\\/\\/([^/:]+)(:\\d*)?([^# ]*)";
        String originStr1 = "http://www.runoob.com:80/html/html-tutorial.html";
        System.out.println(matchString(regStr1, originStr1));
        System.out.println();

        //测试获取方法
        String regStr2 = "(\\w+):\\/\\/([^/:]+)(:\\d*)?([^# ]*)";
        String originStr2 = "http://www.runoob.com:80/html/html-tutorial.html";
        String[] getStrs = getString(regStr2, originStr2);
        for(int i = 0; i < getStrs.length; i ++) {
            System.out.println(getStrs[i]);
        }
        System.out.println();

        //测试分隔方法
        String regStr3 = ":\\d+";
        String originStr3 = "http://www.runoob.com:80/html/html-tutorial.html";
        String[] getStrs2 = splitString(regStr3, originStr3);
        for(int i = 0; i < getStrs2.length; i ++) {
            System.out.println(getStrs2[i]);
        }
        System.out.println();

        //测试替代方法
        String regStr4 = ":\\d+";
        String originStr4 = "http://www.runoob.com:80/html/html-tutorial.html";
        System.out.println(replaceString(regStr4, originStr4, " newString "));
    }


    //【字符串匹配】，验证输入字符串是否满足输入的正则表达式规则
    public static  boolean matchString(String regStr, String originStr) {
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(originStr);
        return matcher.matches();
    }

    //【字符串获取】，在正则表达式匹配时，缓存匹配的项，然后就可以获取需要的项
    public static String[] getString(String regStr, String originStr) {
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(originStr);

        //加入这两行，无法获取匹配后的字符串。暂时认为是两次调用find()方法导致的，还有待查看源码确认
        /*boolean is = matcher.find();
        System.out.println(is);*/

        String[] ss = new String[matcher.groupCount()];
        if(matcher.find()) {
            for(int i = 1; i <= matcher.groupCount();i++){
                ss[i-1] = matcher.group(i);
            }
        }
        return  ss;
    }

    //【字符串分割】，根据正则表达式规则分隔字符串
    public static String[] splitString(String regStr, String originStr) {
        return originStr.split(regStr);
    }

    //【字符串替代】，将符合正则表达式规则的子字符串替换成新字符串
    //另外，String支持正则表达式的方法有repalceAll()和repalceFirst()，replace()是不支持的
    public static String replaceString(String regStr, String originStr, String newStr) {
        return originStr.replaceAll(regStr, newStr);
    }

}
