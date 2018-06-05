package com.mj.shop;

import com.mj.shop.product.Paging;

public class PagingTest {

	public static void main(String[] args) {
		//public Paging(int totalCount, int currentPage, pageSize) {
		Paging p = new Paging(14, 1, 15);
		System.out.println(p);
		
		//total 0  X
		//total 1 pageSize 30 currentPage 1
		// lastPage 전체페이지 보다 큰 현재 페이지 안됨
		
		

	}

}
