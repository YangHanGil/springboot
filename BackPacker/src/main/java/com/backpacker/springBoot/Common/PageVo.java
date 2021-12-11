package com.backpacker.springBoot.Common;

public class PageVo {

	private int listSize;               
	private int rangeSize = 10;            
	private int page;
	private int range;
	private int listCnt;
	private int pageCnt;
	private int startPage;
	private int startList;
	private int lastList;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private String f_board_div = "";
	private String board_selec = "";
	private String boardSearch = "";
	private String search = "";
	private String subject = "";
	private String target = "";
	private String f_email = "";
	private String level = "";
	
	public int getRangeSize() {
		return rangeSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	
	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}
	
	public int getStartList() {
		return startList;
	}
	
	public int getLastList() {
		return lastList;
	}

	public void setLastList(int lastList) {
		this.lastList = lastList;
	}

	public String getF_board_div() {
		return f_board_div;
	}

	public void setF_board_div(String f_board_div) {
		this.f_board_div = f_board_div;
	}

	public String getBoard_selec() {
		return board_selec;
	}

	public void setBoard_selec(String board_selec) {
		this.board_selec = board_selec;
	}

	public String getBoardSearch() {
		return boardSearch;
	}

	public void setBoardSearch(String boardSearch) {
		this.boardSearch = boardSearch;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
	public String getF_email() {
		return f_email;
	}

	public void setF_email(String f_email) {
		this.f_email = f_email;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void pageInfo(int page, int range, int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		
		this.pageCnt = (int) Math.ceil((double)listCnt/(double)listSize);
		
		this.startPage = (range - 1) * rangeSize + 1 ;
		
		this.endPage = range * rangeSize;
				
		this.startList = ((page-1) * lastList) + 1;

		this.lastList = (startList - 1) + lastList;
		
		this.prev = range == 1 ? false : true;

		this.next = endPage < pageCnt ? true : false;
		if (this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}
	
}
