package com.sillycat.springbootapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Data
@ConfigurationProperties("configBeanAuthor")
public class ConfigBeanAuthor {
	
	private Long id;
	private String name;
	private Long age;
	private String language;

}
