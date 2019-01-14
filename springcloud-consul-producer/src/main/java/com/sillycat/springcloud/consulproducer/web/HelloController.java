package com.sillycat.springcloud.consulproducer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
    public String hello() {
        return "helle sillycat";
    }
	
}
