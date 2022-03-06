package com.sillycat.springboot.restfulapi.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Data
@JSONType(ignores ={"content", "lastName"}) 
// @JSONType(includes={"name","sex"}) 
public class CustomerDTO {

	@JSONField(name="key") 
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Date createdTime;
	private Date updatedTime;
	@JSONField(serialize=false)
	private String content;

}
