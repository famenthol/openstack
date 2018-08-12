package com.it.demo.demo.dao;

import java.util.List;

import com.it.demo.demo.vo.TokenVO;

public interface TokenDao {
	
	public List<TokenVO> findTokenVO();
	
	public void save(TokenVO token);
	
 }
