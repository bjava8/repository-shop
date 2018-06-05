package com.mj.shop.product;


public class ListVO {
	
	private String category;
	private int page = 1; // 요청한 페이지
	private int start;
	private int end;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "ListVO [category=" + category + ", page=" + page + ", start=" + start + ", end=" + end + "]";
	}
}
