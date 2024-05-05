package com.mycompany.springframework.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch17AuthenticationSuccessHandler 
	extends SimpleUrlAuthenticationSuccessHandler {
// SimpleUrlAuthenticationSuccessHandler를 상속받으면 -> 로그인 성공시 defaultTargetUrl로 이동시킴
// SavedRequestAwareAuthenticationSuccessHandler를 상속받으면 -> 사용자가 요청했던 경로를 기억해뒀다가 로그인 성공시 그 경로로 이동시켜줌
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		log.info("실행");
		
		// 로그인이 성공했을 때 이동할 defaultTargerUrl을 지정 : 홈페이지
		//  setDefaultTargetUrl("/");
		
		// 기타 기본 설정을 적용하기 위해 부모 메소드 호출
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
