package com.liu.date20170524;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 练习合并数组的方法
 * 
 * @author Herry
 *
 */
public class MergeArrays {
	
	public static void main(String[] args) {
		String[] aa = {"11","22","33"};
		String[] bb = {"44","55","66"};
		String[] cc = {"77","88","99"};

		// 合并两个数组
		String[] dd = new String[aa.length + bb.length];
		System.arraycopy(aa, 0, dd, 0, aa.length);
		System.arraycopy(bb, 0, dd, aa.length, bb.length);
		
		// 合并两个数组
		String[] ee = new String[aa.length + bb.length + cc.length];
		System.arraycopy(aa, 0, ee, 0, aa.length);
		System.arraycopy(bb, 0, ee, aa.length, bb.length);
		System.arraycopy(cc, 0, ee, aa.length + bb.length, cc.length);
		
		
		// 合并两个数组
		String[] ff = ArrayUtils.addAll(aa, bb);
		
		// 将多个字符串合并到数组构成新数组
		String[] gg = ArrayUtils.addAll(aa, "12", "13");
		String[] hh = ArrayUtils.addAll(aa, "12", "13", "14");
		String[] ii = ArrayUtils.addAll(aa, "12", "13", "14", "15");
		
		// 合并三个数组
		String[] jj =  ArrayUtils.addAll(aa, bb);
		String[] kk =  ArrayUtils.addAll(jj, cc);
		
		
		// (1)
		ArrayUtils.addAll(aa, bb, cc);
		
		
	}
	
	
	

}
