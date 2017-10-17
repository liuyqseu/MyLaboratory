package com.liu.date20171017;

import java.util.Scanner;

/**
 * 网易2018校招真题练习
 * 来自牛客网：https://www.nowcoder.com/question/next?pid=6910869&qid=126948&tid=10888321
 * Created by Herry on 2017/10/17.
 */
public class CountOpposite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        char[] digits = String.valueOf(input).toCharArray();
        int digitLength = digits.length;

        int sum = 0;
        for (int i = digitLength-1; i >= 0; i --) {
            // 减去48是因为ASCII表中字符1对应的十进制数是49，所以为了将char转换成int，需要减去48
            sum += (digits[i] - 48) * Math.pow(10, digitLength - 1);
            // digitLenth在这里是用作指数，所以需要递减
            digitLength -= 1;
        }
        System.out.print(sum + input);
    }

}
