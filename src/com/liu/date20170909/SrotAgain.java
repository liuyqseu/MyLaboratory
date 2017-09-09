package com.liu.date20170909;

import java.util.Scanner;

/**
 * 网易校招笔试题第一题
 *
 * Created by Herry on 2017/9/9.
 */
public class SrotAgain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seriesNum = scanner.nextInt(); //数列的个数

        int multipleOfFour = 0;
        int multipuleOfTwo = 0;
        int noMultiple = 0;
        int numNum = 0;
        long num = 0;

        while (seriesNum-- > 0) {
            numNum = scanner.nextInt();

            multipleOfFour = 0;
            multipuleOfTwo = 0;
            noMultiple = 0;

            for(int i = 0; i < numNum; i ++) {
                num = scanner.nextLong();

                if(num % 4 == 0) {
                    multipleOfFour ++;
                } else if(num % 2 == 0) {
                    multipuleOfTwo ++;
                } else {
                    noMultiple ++;
                }
            }

            if(multipleOfFour >= noMultiple) {
                System.out.println("Yes");
                continue;
            }
            if(multipuleOfTwo == 0 && noMultiple - multipleOfFour == 1) {
                System.out.println("Yes");
                continue;
            }
            System.out.println("No");
        }
    }

}
