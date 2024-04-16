package com.mycompany.springframework.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dto.Ch04LoginForm;
import com.mycompany.springframework.dto.Ch04LoginFormValidator;
import com.mycompany.springframework.dto.Ch04SignUpForm;
import com.mycompany.springframework.dto.Ch04SignUpFormValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
	
	@GetMapping("/loginForm")
	public String loginForm(Model model) {
		model.addAttribute("chNum", "ch04");
		return "ch04/loginForm";
	}
	
	@InitBinder("ch04LoginForm")
	public void ch04LoginFormValidator(WebDataBinder binder) {
		binder.setValidator(new Ch04LoginFormValidator());
	}
	
	@RequestMapping("/login")
	public String login(@Valid Ch04LoginForm loginForm, Errors errors, Model model) { // 유효성 검사 과정에서 에러가 뜬 것이 들어온다.
		log.info("실행");
		// 유효성 검사를 통과하지 못했을 때 다시 로그인 폼을 출력
		if (errors.hasErrors()) {
			model.addAttribute("chNum", "ch04");
			return "ch04/loginForm";
		}
		
		// 로그인 처리
		return "redirect:/";
	}
	
	@GetMapping("/signUpForm")
	public String signUpForm(Model model) {
		model.addAttribute("chNum", "ch04");
		return "ch04/signUpForm";
	}
	
	@InitBinder("ch04SignUpForm")
	public void ch04SignUpFormValidator(WebDataBinder binder) {
		binder.setValidator(new Ch04SignUpFormValidator());
	}
	
	@RequestMapping("/signUp")
	public String signUp(@Valid Ch04SignUpForm signUpForm, Errors errors, Model model) { // 유효성 검사 과정에서 에러가 뜬 것이 들어온다.
		log.info("실행");
		// 유효성 검사를 통과하지 못했을 때 다시 회원가입 폼을 출력
		if (errors.hasErrors()) {
			model.addAttribute("chNum", "ch04");
			return "ch04/signUpForm";
		}
		
		// 회원가입이 완료되면 홈으로 이동
		return "redirect:/";
	}
	
}
