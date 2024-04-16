package com.mycompany.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/ch01")
@Slf4j
@Controller
public class Ch01Controller {
	/*private static final Logger LOGGER = 
	 * LoggerFactory.getLogger(Ch01Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		LOGGER.info("content() 실행");
		return "ch01/content";
	}*/
	@RequestMapping("/content")
	public String content(Model model) {
		log.info("content() 실행");
		model.addAttribute("chNum", "ch01");
		return "ch01/content";
	}
}
