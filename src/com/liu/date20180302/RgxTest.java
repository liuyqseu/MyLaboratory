package com.liu.date20180302;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Herry on 2018/3/2.
 * 说明： 这是网上看到的一个题目，在此运行试验，暂不提交
 */
public class RgxTest {

    public static void main(String[] args) {
        /*String ip = "172.25.27.1  3.25.118.32   105.38.225.12";
        System.out.println("原字符串:"+ip);
        ip=ip.replaceAll("(\\d+)", "00$1");
        System.out.println("先补0:"+ip);
        ip=ip.replaceAll("0*(\\d{3})", "$1");
        System.out.println("留三位:"+ip);
        String[] new_ip = ip.split(" +");
        // System.out.println(new_ip);//这样打印的是字符串数组的首地址

        Arrays.sort(new_ip);

        System.out.println("去0再排序后:");
        for (String string : new_ip) {

            System.out.println(string.replaceAll("0*([0-9]{1,2})", "$1"));

        }*/


        String ip = "172.25.27.1  3.25.118.32   105.38.225.12 105.38.0.12";
        System.out.println("原字符串:"+ip);
        Matcher m= Pattern.compile("(\\d+)").matcher(ip);
        StringBuffer sb=new StringBuffer();
        while(m.find()){
            if(m.group().length()==1){
                m.appendReplacement(sb, "00$1");
            }else if(m.group().length()==2){
                m.appendReplacement(sb, "0$1");
            }
        }
        System.out.println("处理后的字符串："+sb);
        String[] newIp=sb.toString().split("\\s+");
        Arrays.sort(newIp);
        System.out.println("排序结果：");
        for(String ele:newIp){
            System.out.println(ele.replaceAll("0*(\\d{1,3})", "$1"));
        }

    }
}
