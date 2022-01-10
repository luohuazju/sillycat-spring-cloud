package com.sillycat.pojo;

import java.util.List;

import com.sillycat.annotation.Transformer;
import com.sillycat.bo.ApplicationBO;

import lombok.Data;

@Data
@Transformer(to = ApplicationBO.class)
public class ApplicationPOJO {
	
	private Integer id;
	private String name;
	private List<EducationPOJO> educations;

}
