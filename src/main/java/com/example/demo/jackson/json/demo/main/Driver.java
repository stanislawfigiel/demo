package com.example.demo.jackson.json.demo.main;

import com.example.demo.jackson.json.demo.pojo.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.net.URL;

public class Driver {

	public static void main(String[] args) {

		Double a = 2.3d;
		Integer b = 3;
		String as  = "aa";
		System.out.println("ZNAK:"+ as.charAt(1));


		try{
			ObjectMapper objectMapper = new ObjectMapper();
			Driver driver = new Driver();
			URL path = driver.getClass().getResource("/data/jsonData.json");
			System.out.println("PATH:" + path);
			File file = new File(Driver.class.getResource("/data/jsonData.json").getPath());
			Student student =  objectMapper.readValue(file, Student.class);
			System.out.println("STUDENT:" + student);
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}

}
