package com.sillycat.pojo;

import java.util.Date;
import java.util.List;

import com.sillycat.annotation.Transformer;
import com.sillycat.bo.EducationBO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Transformer(to = EducationBO.class)
public class EducationPOJO {

	private Date startTime;
	private Date endTime;
	private String school;
	private List<String> courses;

}
