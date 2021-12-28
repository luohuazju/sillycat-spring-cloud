package com.sillycat.springboot.restfulapi.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(callSuper = true)
@Data
public class ExcelListener extends AnalysisEventListener<Object> {

	private List<JSONObject> dataList = new ArrayList<>();

	private Map<String, Integer> importHeads = new HashMap<>(16);

	@Override
	public void invoke(Object data, AnalysisContext context) {
		String headStr = JSON.toJSONString(data);
		dataList.add(JSONObject.parseObject(headStr));
	}

	@Override
	public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
		for (Integer key : headMap.keySet()) {
			if (importHeads.containsKey(headMap.get(key))) {
				continue;
			}
			importHeads.put(headMap.get(key), key);
		}
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		log.info("Excel parse done!");
	}

}
