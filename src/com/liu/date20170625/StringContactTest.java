package com.liu.date20170625;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试StringBuilder和StringBuffer在多线程情形下的不同表现
 * 说明： StringBuilder是线程不安全的，但是效率较高 -->会抛出异常
 *      StringBuffer是线程安全的，但是效率较低-->不会有异常
 * @author Herry
 */
public class StringContactTest {
	
	public static void main(String[] args) {		
		// 测试StringBuilder拼接方式
		for(int i=0; i < 20; i++) {			
			stringContactWithBuilder();			
		}	
	
	}
	
	// 通过StringBuilder来进行字符串拼接
	public static void stringContactWithBuilder(){	
		// 待拼接数据
		List<String> dataList = new ArrayList<>();
		// 模拟赋值
		for (int i = 0; i < 10; i++) {
			dataList.add("data" + i);
		}
		
		
		
		StringBuilder stringBuilder = new StringBuilder();
		dataList.parallelStream().forEach(data -> {		
			stringBuilder.append(data);		
			StringBuilder stringBuilder2 = new StringBuilder();
			
			// 待拼接数据
			List<String> dataList2 = new ArrayList<>();
			// 模拟赋值
			for (int i = 0; i < 10; i++) {
				dataList2.add("data" + i);
			}
			dataList2.parallelStream().forEach(data2 -> {				
				stringBuilder2.append(data2);				
			});
			stringBuilder.append(stringBuilder2.toString());
			
		});	
		
		System.out.println(stringBuilder.toString());
	}
	
	// 通过StringBuffer来进行字符串拼接
	public static void stringContactWithBuffer(){	
		// 待拼接数据
		List<String> dataList = new ArrayList<>();
		// 模拟赋值
		for (int i = 0; i < 20; i++) {
			dataList.add("data" + i);
		}
		
		StringBuffer stringBuffer = new StringBuffer();
		dataList.parallelStream().forEach(data -> {		
			stringBuffer.append(data);		
			StringBuffer stringBuffer2 = new StringBuffer();
			dataList.parallelStream().forEach(data2 -> {				
				stringBuffer2.append(data2);				
			});
			System.out.println(stringBuffer2.toString());
		});
		System.out.println(stringBuffer.toString());		
	}

}
