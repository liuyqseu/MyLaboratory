package com.liu.date20170702;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Herry on 2017/7/2.
 * 说明： 该实验是为了理解通过Arrays.asList()转换得到的List不支持add()操作的原因。
 */
public class TestArrayToList {

    public static void main(String[] args) {
        String[] ordinaryArray = {"11", "22", "33"};
        // (1)
        List<String> transferedArray = Arrays.asList(ordinaryArray);
        // (2)
        transferedArray.add("66");

        // (3)
        List<String> myList = new ArrayList<>();


        /*List<String> get = transferArrayToList(ordinaryArray);
        System.out.println(get.size());*/
    }


    private static <E>  List<E> transferArrayToList(E[] array){
        List<E> transferedList = new ArrayList<>();
        Arrays.stream(array).forEach(arr -> transferedList.add(arr));
        return transferedList;
    }

}
