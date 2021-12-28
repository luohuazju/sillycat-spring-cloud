package com.sillycat.springboot.restfulapi.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import lombok.Data;

@ContentRowHeight(10)
@HeadRowHeight(20)
@ColumnWidth(15)
@Data
public class User {
	@ExcelProperty(value = "姓名", index = 0)
	private String name;

	@ExcelProperty("性别")
	private String sex;

	@ExcelProperty("年龄")
	private Integer age;

	@ColumnWidth(20)
	@ExcelProperty(value = "卡号", index = 6)
	private String cardID;

	@ExcelIgnore
	private String filed;

	@ExcelProperty({ "普通高等学校全日制教育", "学历" })
	private String kultur;

	@ExcelProperty({ "普通高等学校全日制教育", "学位" })
	private String degree;

	@ExcelProperty({ "普通高等学校全日制教育", "专业" })
	private String major;
}
