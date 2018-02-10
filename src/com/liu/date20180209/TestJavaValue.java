package com.liu.date20180209;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Herry on 2018/2/9.
 * 说明： 该问题来自于百度知道
 * 题目：java值传递问题现在一个map里面放若干的元素，再把map放入一个list当中，接着清空map中的数据，为什么list当中的数据也同时没了呢。
 * 因为java不是只有值传递的吗，所以传入list当中的那个map不是应该是值拷贝出来所形成的另一个对象吗，那么删除原对象的数据应该不影响另一
 * 个对象才对啊。
 * 解答参考知乎回答：https://www.zhihu.com/question/31203609
 *
 */
public class TestJavaValue {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "a");
        hashMap.put("2", "b");

        List<Map<String, String>> arrayList = new ArrayList<>();
        arrayList.add(hashMap);

        hashMap.remove("1");
        Map<String, String> hashMap2 = arrayList.get(0);

        for (Map.Entry<String, String> entry : hashMap2.entrySet()) {
            System.out.println(entry.getKey() + "  :  " + entry.getValue());
        }
    }

}
