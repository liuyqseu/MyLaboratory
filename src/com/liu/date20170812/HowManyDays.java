package com.liu.date20170812;

import java.util.Scanner;

/**
 * 网易内推笔试题： 计算小易最多能够独立生活多少天
 *
 * Created by Herry on 2017/8/12.
 */
public class HowManyDays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt();
            int f = in.nextInt();
            int d = in.nextInt();
            int p = in.nextInt();
            if(d - f*x < 0) {
                System.out.println(d/x);
                return;
            }
            int days = (d-f*x)/(x+p);
            System.out.println(days + f);
        }
    }
}
