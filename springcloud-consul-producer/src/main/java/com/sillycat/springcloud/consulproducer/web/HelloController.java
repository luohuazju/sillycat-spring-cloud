package com.sillycat.springcloud.consulproducer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/health")
    public String health(){
        return "hello consul";
    }

	@RequestMapping("/hello")
    public String hello() {
        return "helle sillycat";
    }
	
}
