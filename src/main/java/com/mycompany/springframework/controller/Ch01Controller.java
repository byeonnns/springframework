package com.mycompany.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/ch01")
@Slf4j
@Controller
public class Ch01Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch01/content";
	}
}
