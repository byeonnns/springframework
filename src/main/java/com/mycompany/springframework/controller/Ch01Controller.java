package com.mycompany.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/ch01")
@Slf4j
@Controller
public class Ch01Controller {
	@RequestMapping("")
	public String index() {
		log.info("index() 실행");
<<<<<<< HEAD
		log.info("index() 실행이 정상적으로 작동됨");
=======
		log.info("index() 실행2");
>>>>>>> branch 'master' of https://github.com/byeonnns/springframework.git
		return "ch01/index";
	}
}
