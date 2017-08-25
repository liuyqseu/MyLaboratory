package com.liu.date20170423;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Herry
 * @time 2017年3月6日22:02:42
 * @description 为了测试List遍历时删除对List数据处理的影响。
 */
public class DeleteList {
	
	public static void main(String[] args) {
		// ArrayList测试
		ArrayList<Integer> arrayList = new ArrayList<Integer>();		
		arrayList.add(0);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		printAndDelete(arrayList);	//(1)
//		printAndDeleteWithIterator(arrayList);	//(2)	
//		printAndDeleteWithListIterator(arrayList); //(3)

		// LinkedList测试
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
//		printAndDelete(linkedList); //(4)
//		printAndDeleteWithIterator(linkedList); //(5)
//		printAndDeleteWithListIterator(linkedList); //(6)
	}
	
	/* 直接打印后删除  */
	public static void printAndDelete(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			System.out.println("i: " + i);
			list.remove(i);
		}
	}
	
	/* 通过迭代器来实现打印后删除  */
	public static void printAndDeleteWithIterator(List<Integer> list){
		Iterator<Integer> iterable = list.iterator();
		while(iterable.hasNext()) {
			System.out.println(iterable.next());
			iterable.remove();
		}
	}
	
	/* 通过List专有迭代器来实现打印后删除  */
	public static void printAndDeleteWithListIterator(List<Integer> list) {
		ListIterator<Integer> listIterator = list.listIterator();
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
			listIterator.remove();
		}
	}

}
