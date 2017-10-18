package com.liu.date20171017;

import java.util.Scanner;

/**
 * 2018有赞笔试编程题第二题：求两个数的最大公约数
 * Created by Herry on 2017/10/17.
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num1 = scanner.nextLong();
        long num2 = scanner.nextLong();


        System.out.print(getGCD(num1, num2));
    }



    //方法一：该方法由于复杂度比较大，只能部分通过测试用例
    public static long getGreatestCommonDivisor(long num1, long num2) {
        long d = num1 < num2 ? num1 : num2; //约数
        while (d >= 1) {
            if (num1 % d == 0 && num2 % d == 0) {
                break;
            }
            d--;
        }
        return d;
    }


    //方法二：100%通过测试用例
    public static long getGCD(long num1, long num2)   // 循环实现
    {
        long k = 0, y = 0;
        if(num1 < num2)
        {
            k = num1;
            num1 = num2;
            num2 = k;
        }
        while(num1 % num2 != 0)
        {
            y = num1 % num2;
            num1 = num2;
            num2 = y;
        }
        return num2;
    }



}