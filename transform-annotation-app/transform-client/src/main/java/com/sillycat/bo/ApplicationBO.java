package com.sillycat.bo;

import java.util.List;

import com.sillycat.annotation.Transformer;
import com.sillycat.pojo.ApplicationPOJO;

import lombok.Data;

@Data
@Transformer(to = { ApplicationPOJO.class })
public class ApplicationBO {

	private Integer id;
	private String name;
	private List<EducationBO> educations;

}
