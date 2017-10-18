package com.liu.date20171017;

import java.util.*;

/**
 * 2018有赞笔试编程题第一题：字符串转换
 * Created by Herry on 2017/10/17.
 */
public class TransferString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        transfer(input);

        //transferList(input);
    }


    //方法一：普通迭代器实现（笔试时100%通过测试用例）
    public static void transfer(String input) {
        List<String> numList = new ArrayList(Arrays.asList(input.split(" ")));
        ArrayList result = new ArrayList<String>();

        Iterator<String> it = numList.iterator();
        while(it.hasNext()) {
            String item = it.next();
            if(item.equals("")) {
                it.remove();
                continue;
            }
            item = item.toUpperCase().charAt(0) + item.substring(1).toLowerCase();
            result.add(item);
        }

        //JDK1.8中不需要循环输出。因为笔试时牛客网只提供JDK 1.7，不能使用String类的jion()来拼接字符串，所以这里通过循环输出
        for(int i = 0; i < result.size() -1; i ++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.print(result.get(result.size() -1));


        //JDK 1.8输出方式。不需要循环输出，换用下面的输出即可
        //System.out.print(String.join(" ", result));
    }


    //方法二：List专用迭代器实现（未经过测试用例测试）
    public static void transferList(String input) {
        List<String> numList = new ArrayList(Arrays.asList(input.split(" ")));

        ListIterator<String> it = numList.listIterator();
        while(it.hasNext()) {
            String item = it.next();
            if(item.equals("")) {
                it.remove();
                continue;
            }
            it.set(item.toUpperCase().charAt(0) + item.substring(1).toLowerCase());
        }

        System.out.print(String.join(" ", numList));
    }

}
