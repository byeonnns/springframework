package com.mycompany.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.Ch13MemberDao;
import com.mycompany.springframework.dto.Ch17Member;

import lombok.extern.slf4j.Slf4j;

@Service
public class Ch17Service {
	
	@Autowired
	private Ch13MemberDao memberDao;
	
	public void join(Ch17Member member) {
		// 입력받은 비밀번호를 암호화하는 과정
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		member.setMpassword(passwordEncoder.encode(member.getMpassword()));
		
		member.setMenabled(true);
		memberDao.insert(member);
	}
}
