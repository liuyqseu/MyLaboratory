package com.liu.date20180210;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Herry on 2018/2/10.
 * 说明： 来自于百度知道的提问
 * 问题： 一共数字四位，首位数为4|5|6|7后三位【0-9】，多个数字可以用逗号分开，不限数字个数，写在html做input验证
 */
public class ValidateInput {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("^[4|5|6][0-9]{3}(,[4|5|6][0-9]{3})*$");

        Matcher matcher = pattern.matcher("4567,458");

        System.out.println(matcher.matches());
    }
}
