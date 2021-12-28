package com.sillycat.springboot.restfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public enum LookalikeReachType {
	
	PERCENT(1, "PERCENT"), COUNT(2, "COUNT");

	private Integer code;
	private String value;

}
