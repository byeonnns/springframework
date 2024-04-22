package com.mycompany.springframework.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.Ch12Dao4;
import com.mycompany.springframework.dao.Ch12Dao5;
import com.mycompany.springframework.dao.Ch12DaoInterface;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch12Service9 {
	// Field 주입
	// 관리 객체만 주입이 가능하다.
	// @Resource도 사용 가능
	
	@Autowired @Qualifier("ch12Dao6") private Ch12DaoInterface field1; // Ch12Dao3 객체도 관리 객체가 되어야 함 (@Repository 이용)
	@Resource(name="ch12Dao7") private Ch12DaoInterface field2;
	
	
	// Constructor 주입
	
	@Autowired
	public Ch12Service9(@Qualifier("ch12Dao6") Ch12DaoInterface field1) {
		
	}

	
	// Setter 주입
	
	@Resource(name="ch12Dao7")
	public void setField2(Ch12DaoInterface field2) {
		this.field2 = field2;
	}
	
}
