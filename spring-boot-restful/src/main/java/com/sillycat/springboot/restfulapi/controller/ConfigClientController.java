package com.sillycat.springboot.restfulapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/configs")
public class ConfigClientController {
	
	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/configInfo")
	public String getConfigInfo() {
		log.info("getConfigInfo method invoke---------");
		return configInfo;
	}
	
}


