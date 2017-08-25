package com.liu.date20170520;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Herry
 * @time 2017年5月20日10:57:00
 * @description 联系常用正则表达式
 */
public class TestReg {
	
	public static void main(String[] args) {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String str = scanner.nextLine();
			if("exit".equals(str)) {
				break;
			}
			// validateUrl()为需要测试的函数，可替换
			System.out.println(validateUrl(str));
		}
	}
	
	// 验证是否为全为数字
	public static boolean validateDigit(String str){
		 Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$"); 
		 Matcher matcher = pattern.matcher(str);
		 return matcher.matches();
	}
	
	// 验证是否全为字母，不含特殊字符
	public static boolean validateCharacters(String str){
		 Pattern pattern = Pattern.compile("^[a-zA-Z]*$"); 
		 Matcher matcher = pattern.matcher(str);
		 return matcher.matches();
	}
	
	// 验证是否为自然数
	public static boolean validateNatural(String str){
		 Pattern pattern = Pattern.compile("^[+]?[\\d]*$"); 
		 Matcher matcher = pattern.matcher(str);
		 return matcher.matches();
	}
	
	// 验证是否为正整数
	public static boolean validatePlus(String str){
		 Pattern pattern = Pattern.compile("^[+]?[1-9]*$"); 
		 Matcher matcher = pattern.matcher(str);
		 return matcher.matches();
	}
	
	// 验证邮箱
	public static boolean validateEmail(String str){
		 Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$"); 
		 Matcher matcher = pattern.matcher(str);
		 return matcher.matches();
	}
	
	// 验证手机号码
	public static boolean validatePhoneNum(String str){
		 Pattern pattern = Pattern.compile("^1[3|4|5|7|8]\\d{9}$"); 
		 Matcher matcher = pattern.matcher(str);
		 return matcher.matches();
	}
	
	// 验证座机号码
	public static boolean validateFixPhone(String str){
		 Pattern pattern = Pattern.compile("^(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})$"); 
		 Matcher matcher = pattern.matcher(str);
		 return matcher.matches();
	}
	
	// 验证网址
	public static boolean validateUrl(String str){
		 Pattern pattern = Pattern.compile("^((ht|f)tps?):\\/\\/[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-\\.,@?^=%&:\\/~\\+#]*[\\w\\-\\@?^=%&\\/~\\+#])?$"); 
		 Matcher matcher = pattern.matcher(str);
		 return matcher.matches();
	}

}
