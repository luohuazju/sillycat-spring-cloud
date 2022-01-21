package com.sillycat.springboot.restfulapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerDTOJSONTest {

	private static final String JSON_CUSTOMER_DTO = "{\"createdTime\":1640721083418,\"email\":\"luohuazju@gmail.com\",\"firstName\":\"Hua\",\"id\":1,\"lastName\":\"Luo\",\"updatedTime\":1640721083418}";

	private static final String JSON_LIST_DTO = "[{\"createdTime\":1640722909631,\"email\":\"luohuazju@gmail.com\",\"firstName\":\"Hua\",\"id\":1,\"lastName\":\"Luo\",\"updatedTime\":1640722909631},{\"createdTime\":1640722909631,\"email\":\"yiyikangrachel@gmail.com\",\"firstName\":\"Yiyi\",\"id\":2,\"lastName\":\"Kang\",\"updatedTime\":1640722909631}]";

	@Test
	public void testDummy() {
		log.info("testBeanNotNull invoke------");
		Assert.notNull("1", "test ENV is running well");
	}

	@Test
	public void object2JSONString() {
		CustomerDTO dto = new CustomerDTO();
		dto.setCreatedTime(new Date());
		dto.setUpdatedTime(new Date());
		dto.setEmail("luohuazju@gmail.com");
		dto.setFirstName("Hua");
		dto.setId(Long.valueOf(1));
		dto.setLastName("Luo");

		String dtoString = JSON.toJSONString(dto);
		log.info(dtoString);
		Assert.hasText(dtoString, "convert object to json string failed");
	}

	@Test
	public void jsonstring2Object() {
		CustomerDTO dto = JSON.parseObject(JSON_CUSTOMER_DTO, CustomerDTO.class);
		log.info(dto.getCreatedTime().toString());
		log.info(dto.getEmail());
		Assert.isTrue("luohuazju@gmail.com".equals(dto.getEmail()), "convert json string to object failed");
	}

	@Test
	public void list2JSONString() {
		CustomerDTO dto1 = new CustomerDTO();
		dto1.setCreatedTime(new Date());
		dto1.setUpdatedTime(new Date());
		dto1.setEmail("luohuazju@gmail.com");
		dto1.setFirstName("Hua");
		dto1.setId(Long.valueOf(1));
		dto1.setLastName("Luo");

		CustomerDTO dto2 = new CustomerDTO();
		dto2.setCreatedTime(new Date());
		dto2.setUpdatedTime(new Date());
		dto2.setEmail("yiyikangrachel@gmail.com");
		dto2.setFirstName("Yiyi");
		dto2.setId(Long.valueOf(2));
		dto2.setLastName("Kang");

		List<CustomerDTO> list = new ArrayList<>();
		list.add(dto1);
		list.add(dto2);

		String listJSONString = JSON.toJSONString(list);
		log.info(listJSONString);
		Assert.hasText(listJSONString, "convert list to json string failed");
	}

	@Test
	public void jsonString2List() {
		List<CustomerDTO> list = JSON.parseArray(JSON_LIST_DTO, CustomerDTO.class);
		log.info(list.get(0).getEmail());
		Assert.isTrue(list.size() == 2, "convert string to list failed");
	}

}
