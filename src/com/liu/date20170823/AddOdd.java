package com.liu.date20170823;

import java.util.Scanner;

/**
 * 编程题专项练习
 *
 * 题目：https://www.nowcoder.com/practice/49cb3d0b28954deca7565b8db92c5296?tpId=85&tqId=29855&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 *
 * Created by Herry on 2017/8/23.
 */
public class AddOdd {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        long begin = System.currentTimeMillis();
        long sum = 0;
        for(int i = 1; i <= inputNum; i ++) {
            sum += fff(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
        System.out.print(sum);*/

        // --------------------------------------- //
        //测试已包含求和功能的函数
        Scanner scanner2 = new Scanner(System.in);
        int inputNum2 = scanner2.nextInt();
        System.out.print(sumOfMaxOdd2(inputNum2));

    }

    //求一个数的最大奇数约数-> (30%)
    public static int f(int inputNum) {
        int temp = inputNum;
        while(temp > 1) {
            if(inputNum % temp == 0 && temp % 2 != 0) {
                return temp;
            }
            temp --;
        }
        return 1;
    }

    //【改进1】求一个数的最大奇数约数 -> (40%)
    public static int ff(int inputNum) {
        int temp = inputNum;
        if(temp % 2 != 0) {
            return temp;
        }

        for(int i = 2; i <= inputNum / 2; i ++){
            if(inputNum % i == 0) {
                temp = inputNum / i;
                if(temp % 2 != 0) {
                    return temp;
                }
            }
        }
        return 1;
    }

    //【改进2】求一个数的最大奇数约数 -> (60%)
    public static int fff(int inputNum) {
        while(inputNum % 2 == 0) {
            inputNum /= 2;
        }
        return inputNum;
    }

    //【改进3】求一个数的最大奇数约数-> (60%)
    public static int ffff(int inputNum) {
        if(inputNum % 2 != 0) {
            return inputNum;
        }

        while(inputNum % 2 == 0) {
            inputNum /= 2;
        }
        return inputNum;
    }

    //【改进4】求一个数的最大奇数约数 -> (60%)
    public static int fffff(int inputNum) {
        if(inputNum % 2 != 0) {
            return inputNum;
        }
        return fffff(inputNum / 2);
    }

    //【改进5】摘抄自牛客网：包含求和 -> (100%)
    public static long sumOfMaxOdd(long n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return sumOfMaxOdd(n / 2) + n * n / 4;
        } else {
            return sumOfMaxOdd(n - 1) + n;
        }
    }

    //【改进6】摘抄自牛客网：包含求和 -> (100%)
    /**
     * 总体思路：
     * 因为奇数的最大奇数约数就是自己啊，对于偶数我们只能一直除2直到得到一个奇数即为最大奇数约数
     *
     * 比如1 2 3 4 5 6 7 8 9 10
     * 即n=10 ，此时奇数有1 3 5 7 9 我们把这几个奇数相加然后n/2
     * 得到第二轮序列序列 1 2 3 4 5 分别对应上次的2 4 6 8 10 五个偶数，这是我们再加1 3 5
     * 依次类推
     *
     * 细节问题：
     * 当n为偶数，就有n/2个奇数，根据等差数列求和公式 即(（首项+末项）*项数)/2,我们知道n/2个奇数和为((1+n-1)*n/2)/2,
     * 即为(n/2) * (n/2),此时n为偶数，因此 (n/2) * (n/2) = ((n+1)/2)  *  ((n+1)/2)
     *  
     * 当n为奇数，有(n+1)/2个奇数，此时奇数和为((n+1)/2)  *  ((n+1)/2)
     * 因此两种情况可以用一个等式来总结
     * @param num
     * @return
     */
    public static long sumOfMaxOdd2(long num) {
        long sum = 0;
        for (long i = num; i > 0; i = i / 2) {
            long temp = (i + 1) / 2;
            sum += temp * temp;
        }
        return sum;
    }
}
