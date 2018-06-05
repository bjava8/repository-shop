package com.mj.shop.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<MemberVO> listView(ListVO listVO) {
		
		return mybatis.selectList("MemberDAO.listView", listVO);
	}
}
