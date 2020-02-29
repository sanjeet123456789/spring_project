package com.pal.jackson.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Controller {
	public static void main(String[] args) {
		try {
			//create object mapper
			ObjectMapper mapper=new ObjectMapper();
			
			
			//read JSON file and map/copnvert to Java POJO sample_01
			Student thestudent=mapper.readValue(new File("data/sample_02.json"), Student.class);
			
			
			
			//print firstName and lastName
			
			System.out.println("First name"+thestudent.getFirstName());
			System.out.println("lsatName:"+thestudent.getFirstName());
			
			
			Address tempadd=thestudent.getAddress();
			
			System.out.println("street"+tempadd.getStreet());
			System.out.println("city"+tempadd.getCity());
			System.out.println("zip"+tempadd.getZip());
			for(String templanguage:thestudent.getLanguages()) {
				System.out.println(templanguage);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
