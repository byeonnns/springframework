package com.mycompany.springframework.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.springframework.dto.Ch15Account;

@Mapper // MyBatis가 사용하는 인터페이스라는 의미
public interface Ch13AccountDao {

	public int updateBalance(Ch15Account account);
	public Ch15Account selectByAno(int ano);
	public List<Ch15Account> selectAll();
}
