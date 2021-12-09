package com.sillycat.springboot.restfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Data
public class CustomerDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;

}
