package com.mycompany.springframework.dto;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04SignUpFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		return Ch04SignUpForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Ch04SignUpForm signUpForm = (Ch04SignUpForm) target;
		
		// 아이디 검사
		String mid = signUpForm.getMid();
		
		if ( mid == null || mid.equals("")) {
			errors.rejectValue("mid", null, "아이디는 필수 입력 사항입니다.");
		} else if (mid.length() < 6 || mid.length() > 12) {
			errors.rejectValue("mid", null, "아이디는 6자 이상 12자 이하로 입력해주세요.");
		}
		
		// 비밀번호 검사
		String mpassword = signUpForm.getMpassword();
		String pwPattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}";
		
		boolean pwResult = Pattern.matches(pwPattern, mpassword);
		
		if ( mpassword == null || mpassword.equals("")) {
			errors.rejectValue("mpassword", null, "비밀번호는 필수 입력 사항입니다.");
		} else if (mpassword.length() < 8 || mpassword.length() > 15) {
			errors.rejectValue("mpassword", null, "비밀번호는 8자 이상 15자 이하로 입력해주세요.");
		} else if (!pwResult) {
			errors.rejectValue("mpassword", null, "비밀번호는 알파벳 대소문자와 숫자를 포함해야 합니다.");
		}
		
		//Email 검사
		String memail = signUpForm.getMemail();
		String emailPattern = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+";
		
		boolean emailResult = Pattern.matches(emailPattern, memail);
		
		if (memail == null || memail.equals("")) {
			errors.rejectValue("memail", null, "이메일은 필수 입력 사항입니다.");
		} else if (!emailResult) {
			errors.rejectValue("memail", null, "이메일 형식이 올바르지 않습니다.");
		}

		//Phone 검사하기
		String mphone = signUpForm.getMphone();
		String phonePattern = "(010|011)-\\d{3,4}-\\d{4}";
		
		boolean phoneResult = Pattern.matches(phonePattern, mphone);
		 
		if (mphone == null || mphone.equals("")) {
			errors.rejectValue("mphone", null, "전화번호는 필수 입력 사항입니다.");
		} else if (!phoneResult) {
			errors.rejectValue("mphone", null, "전화번호 형식이 올바르지 않습니다.");
		}
	         
		//이름 검사하기
		String mname = signUpForm.getMname();
		String namePattern = "[가-힣]{2,5}";
		boolean nameResult = Pattern.matches(namePattern, mname);

		if (mname == null || mname.equals("")) {
			errors.rejectValue("mname", null, "이름은 필수 입력 사항입니다.");
		} else if (!nameResult) {
			errors.rejectValue("mname", null, "2자 이상 5자 이하의 이름을 입력해주세요.");
		}
		
	}
	
}
