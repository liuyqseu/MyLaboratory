package com.liu.date20180312;

/**
 * Created by Herry on 2018/3/12.
 * 说明： 科大讯飞笔试。验证子类引用与父类引用以及它们调用子类、父类方法的情况。
 */
public class ValidateClass {

    public static void main(String[] args) {
        ValidateClass validateClass1 = new ValidateClass();
        ValidateClassChild validateClassChild1 = new ValidateClassChild();

        validateClass1 = validateClassChild1;
        //以下代码是错误的，子类引用不能指向父类引用
        //validateClassChild1 =validateClass1;

        validateClass1.printA();
        ////以下代码是错误的，指向子类的父类引用不能调用子类方法
        //validateClass1.printB();

    }

    public void printA() {
        System.out.println("A-Father");
    }
}


class ValidateClassChild extends ValidateClass  {

    public void printB() {
        System.out.println("B-Child");
    }

}