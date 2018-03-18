package com.liu.date20180312;

import java.util.Scanner;

/**
 * Created by Herry on 2018/3/12.
 * 说明： 科大讯飞第二题笔试题
 */
public class Inter2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputSs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputSs[0]);
        int m = Integer.parseInt(inputSs[1]);
        int x = Integer.parseInt(inputSs[2]);
        int k = Integer.parseInt(inputSs[3]);

        int rightNum = 0;
        int wrongNum = 0;
        String[] inputSs2 = scanner.nextLine().split(" ");
        for(int i = 0; i < inputSs2.length; i ++) {
            if(inputSs2[i].equals("0")) {
                wrongNum ++;
            } else {
                rightNum ++;
            }
        }
        if(rightNum >= wrongNum) {
            System.out.print(m * n - wrongNum * x -k * (rightNum - wrongNum));
        } else {
            System.out.print(m * n - wrongNum * x);
        }

    }

}
