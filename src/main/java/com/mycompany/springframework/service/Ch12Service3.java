package com.mycompany.springframework.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service // 기본적으로 클래스 첫 글자를 소문자로 한 이름으로 관리
@Slf4j
public class Ch12Service3 {
	public Ch12Service3() {
		log.info("실행");
	}
}
