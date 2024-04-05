package com.mycompany.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String index() {
		log.info("index() 실행1");
		log.info("index() 실행2");
		log.info("index() 실행3");
		log.info("index()3까지 정상적으로 실행됨");
		log.info("index() 실행1 종료");
		log.info("index() 실행2 종료");
		log.info("index() 실행3 종료");
		return "home";
	}
}
