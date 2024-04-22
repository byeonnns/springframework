package com.mycompany.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.Ch12Dao3;
import com.mycompany.springframework.dao.Ch12Dao4;
import com.mycompany.springframework.dao.Ch12Dao5;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch12Service8 {
	// Field 주입
	@Autowired // 관리 객체만 주입이 가능하다.
	// @Resource도 사용 가능
	private Ch12Dao3 ch12Dao3; // Ch12Dao3 객체도 관리 객체가 되어야 함 (@Repository 이용)
	private Ch12Dao4 ch12Dao4;
	private Ch12Dao5 ch12Dao5;
	
	// Constructor 주입
	@Autowired
	// @Resouce는 불가 -> 생성자 주입 지원 안함
	public Ch12Service8(Ch12Dao4 ch12Dao4) { // 마찬가지로 관리 객체여야 가능하다
		log.info("실행");
		this.ch12Dao4 = ch12Dao4;
	}
	
	// Setter 주입
	@Autowired
	// @Resource도 사용 가능
	public void setCh12Dao5(Ch12Dao5 ch12Dao5) {
		log.info("실행");
		this.ch12Dao5 = ch12Dao5;
	}
}
