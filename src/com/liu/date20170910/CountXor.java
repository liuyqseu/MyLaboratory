package com.liu.date20170910;

import java.util.Scanner;

/**
 * 滴滴出行2018校招笔试题第一题  --有待于进一步验证
 * Created by Herry on 2017/9/10.
 */
public class CountXor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int count = 0;
        int beforeFlag = 0;

        int before = scanner.nextInt();
        int behind = 0;
        if(before == 0) {
            count++;
        }
        n--;

        while (n-- > 0) {
            behind = scanner.nextInt();

            if(beforeFlag == 1 && behind == 1)  {
                count++;
                beforeFlag = 0;
                continue;
            }

            if(behind == 0) {
                count++;
                beforeFlag = 0;
                before = 0;
            } else if(before == behind){
                count++;
                beforeFlag = 0;
                before = 0;
            } else {
                if(before != 0) {
                    beforeFlag = 1;
                } else {
                    beforeFlag = 0;
                }
                before = behind;
            }
        }

        System.out.print(count);

    }

}
