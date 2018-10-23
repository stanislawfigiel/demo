package com.example.demo.jackson.json.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private long id;
	private String firstName;
	private String lastName;
	private boolean active;
	private Address address;
	String[] languages;

}
