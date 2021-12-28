package com.sillycat.springboot.restfulapi.listener;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ExcelListenerTest {

	@Test
	public void testExcelRead() {
		String fileName = getPath() + "test_pojo_read.xlsx";
		ExcelListener listener = new ExcelListener();
		EasyExcel.read(fileName, listener).sheet().doRead();
		// headers
		Map<String, Integer> heads = listener.getImportHeads();
		log.info(heads.toString());
		List<JSONObject> data = listener.getDataList();
		for (JSONObject object : data) {
			log.info(object.toString());
		}
	}

	public static String getPath() {
		return ExcelListenerTest.class.getResource("/").getPath();
	}
}
