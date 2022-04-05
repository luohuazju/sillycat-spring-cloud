package com.sillycat.springbootopenapi.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Book {

	private Long id;
	
	@NotBlank
	@Size(min = 0, max = 20)
	private String bookName;
	
	@NotBlank
	@Size(min = 0, max = 10)
	private String bookCode;
	
}
