package com.mycompany.springframework.dto;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04LoginFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		return Ch04LoginForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Ch04LoginForm loginForm = (Ch04LoginForm) target;
		
		// 아이디 검사
		String mid = loginForm.getMid();
		
		if ( mid == null || mid.equals("")) {
			errors.rejectValue("mid", "errors.mid.required", "아이디는 필수 입력 사항입니다.");
		} else if (mid.length() < 6 || mid.length() > 12) {
			errors.rejectValue("mid", "errors.mid.length", new String[] {"6", "12"} ,"아이디는 6자 이상 12자 이하로 입력해주세요.");
		}
		
		// 비밀번호 검사
		String mpassword = loginForm.getMpassword();
		String pwPattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}";
		
		boolean result = Pattern.matches(pwPattern, mpassword);
		
		if ( mpassword == null || mpassword.equals("")) {
			errors.rejectValue("mpassword", null, "비밀번호는 필수 입력 사항입니다.");
		} else if (mid.length() < 8 || mid.length() > 15) {
			errors.rejectValue("mpassword", null, "비밀번호는 8자 이상 15자 이하로 입력해주세요.");
		} else if (!result) {
			errors.rejectValue("mpassword", null, "비밀번호는 알파벳 대소문자와 숫자를 포함해야 합니다.");
		}
		
	}
	
}
