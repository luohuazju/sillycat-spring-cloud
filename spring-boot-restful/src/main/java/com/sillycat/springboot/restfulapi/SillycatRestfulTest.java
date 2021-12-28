package com.sillycat.springboot.restfulapi;

import com.sillycat.springboot.restfulapi.model.AdvanceLookalikeDeloyType;
import com.sillycat.springboot.restfulapi.model.LookalikeReachType;

public class SillycatRestfulTest {

	public static void main(String[] args) {
		System.out.println("------start------------");
		AdvanceLookalikeDeloyType type1 = AdvanceLookalikeDeloyType.PERCENT;
		AdvanceLookalikeDeloyType type2 = AdvanceLookalikeDeloyType.COUNT;
		LookalikeReachType result1 = LookalikeReachType.valueOf(type1.name());
		System.out.println(type1.name());
		System.out.println(result1.getValue());
		
		
		LookalikeReachType result2 = LookalikeReachType.valueOf(type2.name());
		System.out.println(result2);
	}

}
