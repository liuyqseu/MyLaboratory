package com.liu.date20170910;

import java.util.Scanner;

/**
 * 滴滴出行2018校招笔试题第二题
 * Created by Herry on 2017/9/10.
 */
public class FindNumNUgly {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int numUgly = scanner.nextInt();
        if(numUgly == 1) {
            System.out.print(1);
        } else {
            int count = 1;
            for(int i = 2; ; i++) {
                if(judgeUgly(i)) {
                    count++;
                }
                if(count == numUgly) {
                    System.out.print(i);
                    break;
                }
            }
        }
    }

    //判断是否为丑数
    public static boolean judgeUgly(int n) {
        for (int i = 2; i <= n;i++){
            while (n!=i){
                if(n%i==0) {
                    n = n / i;
                    if(i != 2 && i != 3 && i != 5) {
                        return false;
                    }
                } else {
                    break;
                }
            }
            if(n == i && i != 2 && i != 3 && i != 5) {
                return false;
            }

        }
        return true;
    }

}
