package com.example.demo.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class PagingVO {
	private int nowPage;
	private int startPage;
	private int endPage; 
	private int total;
	private int cntPerPage; 
	private int lastPage; 
	private int start;
	private int end;
	private int cntPage = 5; // 보여줄 페이지 목록 개수
	
	public PagingVO() {
		log.info("create page()....");
	}
	
	public PagingVO(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}
	
	private void calcLastPage(int total, int cntPerPage) { //마지막 페이지
		setLastPage((int) Math.ceil((double) total / (double) cntPerPage));
	}
	
	private void calcStartEndPage(int nowPage, int cntPage) { //시작과 끝
		setEndPage(((int) Math.ceil((double) nowPage / (double) cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	private void calcStartEnd(int nowPage, int cntPerPage) { //쿼리에 사용
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
}
