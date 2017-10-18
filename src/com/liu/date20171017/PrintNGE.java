package com.liu.date20171017;

import java.util.Scanner;

/**
 * 2018有赞笔试编程题第三题：打印每个数组元素的NGE（NGE为元素右边第一个比它大的元素）
 * <已实现算法不完善，只通过10%>
 * Created by Herry on 2017/10/17.
 */
public class PrintNGE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];

        // 获取输入
        for (int i = 0; i < n; i ++) {
            nums[i] = scanner.nextLong();
        }

        //测试用例通过率为10%
        for(int j = 0; j < n -1; j ++) {
            int flag = 0;
            for (int k = j + 1; k < n; k ++) {
                if(nums[j] < nums[k]) {
                    System.out.println(nums[k]);
                    flag  = 1;
                    break;
                }
            }
            if(flag == 0) {
                System.out.println("-1");
            }
        }
        System.out.println("-1");
    }
}
