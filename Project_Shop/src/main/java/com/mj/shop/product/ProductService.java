package com.mj.shop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO memberDAO;
	
	public int getTotal(ListVO listVO) {
		return memberDAO.getTotal(listVO);
	}
	
	public List<ProductVO> listView(ListVO listVO) {
		return memberDAO.listView(listVO);
	}
	
	public ProductVO getProduct(String id) {
		return memberDAO.getProduct(id);
	}
	
	public int insertProduct(ProductVO vo) {
		return memberDAO.insertProduct(vo);
	}
}
