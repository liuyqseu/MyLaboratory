package com.liu.date20170415;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestObjectToJson {
	
	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		
		
		String jsonString = "\"{\\\"name\\\" : \\\"liuyanqin\\\",\\\"password\\\" : \\\"1234567\\\"}\"";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonNode = objectMapper.readTree(jsonString);
		
		
		String aa = jsonNode.toString();
		
		System.out.println(aa);
		
		
		/*ObjectMapper objectMapper = new ObjectMapper();
		
		MyEntity myEntity = new MyEntity();
		myEntity.setName("liu");
		myEntity.setAge(2);
		myEntity.setAddress("jiangxi");
		myEntity.setpId("er");
		
		
		
		try {
			String jsonString = objectMapper.writeValueAsString(myEntity);
			
			System.out.println(jsonString);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}*/
		
		
		
		
	}
	
	
	

}


class MyEntity {
	
	String name;
	
	int age;
	
	String address;
	
	String pId;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}