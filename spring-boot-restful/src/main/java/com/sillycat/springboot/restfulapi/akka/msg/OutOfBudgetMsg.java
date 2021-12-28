package com.sillycat.springboot.restfulapi.akka.msg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OutOfBudgetMsg {

	private String id;

	private Integer priority;

}
