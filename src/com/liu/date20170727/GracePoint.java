package com.liu.date20170727;

import java.util.Scanner;

/**
 * 计算优雅点的个数
 * 牛客网：网易2017求秋招试题
 * 目前通过率80%
 * Created by2147483647  Herry on 2017/7/27.
 */
public class GracePoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r2 = scanner.nextInt();
        System.out.println(countGracePoint(r2));
    }
    //计算优雅的点的数量
    public static int countGracePoint(int r2) {
        int count = 0;
        int r = (int)Math.sqrt(r2);
        for(int i = (0-r); i <= r; i++) {
            for(int j = (0-r); j <= r; j++) {
                if(i * i + j * j == r2) {
                    count++;
                }
            }
        }
        return count;
    }
}
