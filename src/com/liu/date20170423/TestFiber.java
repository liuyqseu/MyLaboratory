package com.liu.date20170423;

/**
 * @author Herry
 * @time 2017年3月7日21:58:29
 * @description 源自招银网络科技的笔试题，其中需要求出斐波那契数列地1025项模5的结果。在此做一个简单的验证。
 */

public class TestFiber {
	
	public static void main(String[] args) {
		System.out.println(getFiber(35));
	}
	
	public static int getFiber(int n) {
		System.out.println("n= " + n);
		if(n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return getFiber(n-1) + getFiber(n-2);
		}
	}
}
