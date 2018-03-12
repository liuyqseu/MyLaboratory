package com.liu.date20180312;

import java.util.Scanner;

/**
 * Created by Herry on 2018/3/12.
 * 说明： 科大讯飞第一题笔试题
 */
public class Inter1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wziNum = Integer.parseInt(scanner.nextLine());
        String[] wzhPoint = scanner.nextLine().split(" ");
        int x0 = Integer.parseInt(wzhPoint[0]);
        int y0 = Integer.parseInt(wzhPoint[1]);
        int z0 = Integer.parseInt(wzhPoint[2]);

        int count = 0;
        int x1 = 0;
        int y1 = 0;
        int z1 = 0;
        for(int i = 0; i < wziNum; i++) {
            String[] wziPoint = scanner.nextLine().split(" ");
            x1 = Integer.parseInt(wziPoint[0]);
            y1 = Integer.parseInt(wziPoint[1]);
            z1 = Integer.parseInt(wziPoint[2]);

            if(x1 >= 0 && x1 <= x0 && y1 >= 0 && y1 <= y0 && z1 >= 0 && z1 <= z0) {
                count ++;
            }
        }

        System.out.print(count);

    }

}
