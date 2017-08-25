package com.liu.date20170812;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 网易内推笔试题： 判断给定给定数组能够构成数列
 *
 * Created by Herry on 2017/8/12.
 */
public class IfPossible {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int numLength = Integer.parseInt(in.nextLine());
            String inputNums = in.nextLine();
            String[] nums = inputNums.split(" ");
            int[] intNums = new int[nums.length];
            for (int i=0; i < nums.length; i++) {
                intNums[i] = Integer.parseInt(nums[i]);
            }
            Arrays.sort(intNums);
            if(intNums.length <= 2) {
                System.out.println("Possible");
                return;
            }
            int old = intNums[1] - intNums[0];
            for(int j=0; j<intNums.length-1; j++) {
                int newInt  = intNums[j+1] - intNums[j];
                if(newInt != old) {
                    System.out.println("Impossible");
                    return;
                }
            }
            System.out.println("Possible");
        }
    }
}
