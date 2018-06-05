package com.mj.shop.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int getTotal(ListVO listVO) {
		
		return mybatis.selectOne("ProductDAO.getTotal", listVO);
	}
	public List<ProductVO> listView(ListVO listVO) {
		
		return mybatis.selectList("ProductDAO.listView", listVO);
	}

	public ProductVO getProduct(String id) {
		return mybatis.selectOne("ProductDAO.getProduct", id);
	}
	
	public int insertProduct(ProductVO vo) {
		return mybatis.insert("ProductDAO.insertProduct", vo);
	}
}
