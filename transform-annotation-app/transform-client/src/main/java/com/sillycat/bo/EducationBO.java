package com.sillycat.bo;

import java.util.Date;
import java.util.List;

import com.sillycat.annotation.Transformer;
import com.sillycat.pojo.EducationPOJO;

import lombok.Data;

@Data
@Transformer(to = EducationPOJO.class)
public class EducationBO {

	private Date startTime;
	private Date endTime;
	private String school;
	private List<String> courses;

}
