package com.mycompany.springframework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//@ControllerAdvice
public class Ch10ExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException() {
		log.info("실행");
		
		return "ch10/error500_null";
	}

	@ExceptionHandler(Ch10CustomException.class)
	public String handleCh10CustomException(Ch10CustomException e, Model model) {
		log.info("실행");
		model.addAttribute("message", e.getMessage());
		
		return "ch10/error500_custom";
	}
	
	// 위 예외를 제외한 모든 500 예외 처리
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
	public String handle500Exception() {
		return "ch10/error500";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404
	public String handle404() {
		return "ch10/error404";
	}
}
