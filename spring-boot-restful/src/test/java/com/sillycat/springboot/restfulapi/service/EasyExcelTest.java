package com.sillycat.springboot.restfulapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.sillycat.springboot.restfulapi.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EasyExcelTest {

	@Test
	public void testListWrite() {
		String fileName = getPath() + "test_write.xlsx";
		log.info("fileName is: " + fileName);
		// EasyExcel.write(fileName).head(head()).sheet("Sheet1").doWrite(dataList());
		EasyExcel.write(fileName).head(head()).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
				.sheet("Sheet1").doWrite(dataList());
	}

	@Test
	public void testPOJOWrite() {
		List<User> users = dataPOJO();
		String fileName = getPath() + "test_pojo_write.xlsx";
		EasyExcel.write(fileName, User.class).sheet("Sheet1").doWrite(users);
	}

	private List<User> dataPOJO() {
		List<User> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			User user = new User();
			user.setName("Name " + i);
			user.setSex("Man");
			user.setAge(10 + i);
			user.setCardID("434343434xxx" + i);
			user.setDegree("Master");
			user.setMajor("EE");
			user.setKultur("Technical");
			list.add(user);
		}
		return list;
	}

	private List<List<String>> head() {
		List<List<String>> list = new ArrayList<>();
		List<String> head0 = new ArrayList<>();
		head0.add("姓名");
		List<String> head1 = new ArrayList<>();
		head1.add("年龄");
		List<String> head2 = new ArrayList<>();
		head2.add("生日");
		list.add(head0);
		list.add(head1);
		list.add(head2);
		return list;
	}

	private List<List<Object>> dataList() {
		List<List<Object>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			List<Object> data = new ArrayList<>();
			data.add("张三" + i);
			data.add(25 + i);
			data.add(new Date());
			list.add(data);
		}
		return list;
	}

	public static String getPath() {
		return EasyExcelTest.class.getResource("/").getPath();
	}
}
