package com.co.kr.domain;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class ToDoDTO {
	
	private int id;
	private String item;
	private String status;

}
