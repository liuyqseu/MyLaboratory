package com.liu.date20170423;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Herry
 * @time 2017年4月23日21:24:54
 * @description 为了测试JsonNode转成字符串的两种方式的不同。待更加彻底弄明白将整理成博客。
 *
 */

public class TestJsonString {
	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		
		String jsonString = "\"{\\\"name\\\" : \\\"liuyanqin\\\",\\\"password\\\" : \\\"1234567\\\"}\"";
		
		ObjectMapper objectMapper = new ObjectMapper();		
		JsonNode jsonNode = objectMapper.readTree(jsonString);
		
		
		String aa = jsonNode.toString();  // 转成字符串 --方式1
		
		String bb = jsonNode.asText();  // 转成字符串 --方式2
		
		System.out.println(aa);
		
		System.out.println(bb);
		
		
	
		
		
		
	}
	
	
	


}