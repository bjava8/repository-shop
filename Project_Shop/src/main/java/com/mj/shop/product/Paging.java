package com.mj.shop.product;


public class Paging {
	
	private int total; // 전체
	private int totalPage; // 총 페이지수
	private int currentPage = 1; // 요청한 페이지 1
	private int pageSize = 10; // 30 한 페이지에 출력될 게시물 수
	

	
	private int block = 3;
	
	// 현재 페이지currentPage, pageSize로 계산
	private int beginNum; // 시작 번호
	private int endNum; // 끝 번호

	private int beginPage; // 시작 페이지 "1" 2 3
	private int endPage; // 끝 페이지 1 2 "3" 

	private int prevPage; // 이전 페이지 prev(1) 4 5 6 
	private int nextPage; // 다음 페이지 1 2 3 next(4)
	
	public Paging(int totalCount, int currentPage) {
		total = totalCount;
		this.currentPage = currentPage;
		calculatePaging();
	}
	
	// 생성자 : 변수 totalCount 1 pageSize() 30 currentPage 1
	public Paging(int totalCount, int currentPage, int pageSize) {
		total = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		calculatePaging();
	}
	
	@Override
	public String toString() {
		return "Paging [total=" + total + ", totalPage=" + totalPage + ", currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", block="
				+ block + ", beginPage=" + beginPage + ", endPage=" + endPage + "]";
	}

	public void calculatePaging() {

		// 1. 전체 페이지 계산
		totalPage = total / pageSize;
		if (total % pageSize > 0) totalPage++;
		
		// 2. 요청 페이지가 전체 페이지보다 크면 에러
		if (currentPage > totalPage) return;
		
		// 시작번호 계산
		beginNum = (currentPage - 1) * pageSize + 1;
		
		// 끝 번호 계산
		endNum = beginNum + pageSize - 1;
		if (currentPage == totalPage) endNum = total; // 현재 페이지가 마지막 페이지(total_page)
			//end = total % pageSize;

		
		//beginPage = (currentPage - 1) * pageSize + 1;
		// 시작 페이지 계산
		
		
		
		// 페이지 계산
		// 1. 시작 페이지 = 현재 페이지의 블록
		/**
		 * block = 3;
		 * 
		 * 1 1 0+1 3*0+1
		 * 2 1 0+1 
		 * 3 1 1
		 * 
		 * 4 4 1+1 3*1+1
		 * 5 4 1+1
		 * 6 4 2   3*2+1
		 * 
		 * 7 7
		 * 
		 */
		int blockNum = currentPage / block;
		if (currentPage % block == 0) blockNum--;
		beginPage = block * blockNum + 1;
		
		/*
		beginPage = currentPage / block;
		if (currentPage % block > 0) beginPage++;
		*/
		endPage = beginPage + block - 1;
		if (endPage > totalPage) endPage = totalPage;
		
		
		// prevPage 이전 페이지
		prevPage = beginPage - 1;
		if (prevPage < 1) prevPage = 1;
		
		// nextPage 다음 페이지
		nextPage = endPage + 1;
		if (nextPage > totalPage) nextPage = totalPage;
		
/*		
		if (currentPage <= 10) {
			prev = 1;
		} else {
			prev = currentPage - block;
		}
		
		// next
		next = prev + block;
		if (next > totalPage)
			next = totalPage;*/

	}

	public int getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(int beginNum) {
		this.beginNum = beginNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {	
		this.beginPage = beginPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	// 끝 번호 계산 : 전체 페이지 수
	/**
	 * total_page = 0 X
	 * total_page = 1
	 * 
	 * 현재 페이지가 마지막 페이지(total_page)면
	 * 
	 */
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
}
