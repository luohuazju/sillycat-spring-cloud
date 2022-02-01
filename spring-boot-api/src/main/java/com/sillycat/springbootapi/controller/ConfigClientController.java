package com.sillycat.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sillycat.springboot.restfulapi.controller.CustomerController;
import com.sillycat.springbootapi.config.ConfigBeanAuthor;

import lombok.extern.slf4j.Slf4j;

@RestController
@RefreshScope
@Slf4j
public class ConfigClientController {
	
	
	@Value("${config.info}")
    private String configInfo;
	
	@Autowired
	private ConfigBeanAuthor configBeanAuthor;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
    
    @GetMapping("/author")
    public ConfigBeanAuthor getAuthor() {
    	log.info("getCustomer method invoke---------");
    	return configBeanAuthor;
    }
    
    

}
