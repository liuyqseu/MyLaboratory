package com.liu.date20170727;

import java.util.*;

/**
 * 回文序列
 * Created by Herry on 2017/7/27.
 */
public class PalindromicSequence {


    public static void main(String[] args) {
        //数据读取和格式转换
        /*List<Integer> testList = new ArrayList<>();
        testList.add(3);
        testList.add(2);
        testList.add(6);
        testList.add(1);
        testList.add(4);
        System.out.println(toPalindromic(testList));*/

        List<Integer> testList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String length = scanner.nextLine();
        String[] data = scanner.nextLine().split(" ");
        for (String element : data) {
            testList.add(Integer.parseInt(element));
        }
        System.out.print(toPalindromic(testList));
    }

    //进行转换操作
    public static int toPalindromic(List<Integer> sequence)  {
        int header = 0;
        int tail = sequence.size() - 1;
        int count = 0;

        while(header < tail) {
            if (sequence.get(header) < sequence.get(tail)) { //头部数据相加
                header++;
                sequence.set(header, sequence.get(header - 1) + sequence.get(header));
                count++;
            } else if (sequence.get(header) > sequence.get(tail)) {//尾部数据相加
                tail--;
                sequence.set(tail, sequence.get(tail + 1) + sequence.get(tail));
                count++;
            } else {
                header++;
                tail--;
            }
        }
        return count;
    }

}
