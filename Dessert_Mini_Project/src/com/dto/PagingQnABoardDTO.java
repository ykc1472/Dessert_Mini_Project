package com.dto;

import java.util.List;

public class PagingQnABoardDTO {

	private int total;
	private int offset = 0;
	private int limit = 10;
	private int page = 1;
	private int totalpage;
	private List<QnABoardDTO> qnaboardlist;
	private List<QnABoardCommentDTO> qnacommentlist;

	public PagingQnABoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagingQnABoardDTO(int total, int offset, int limit, int page, int totalpage, List<QnABoardDTO> qnaboardlist,
			List<QnABoardCommentDTO> qnacommentlist) {
		super();
		this.total = total;
		this.offset = offset;
		this.limit = limit;
		this.page = page;
		this.totalpage = totalpage;
		this.qnaboardlist = qnaboardlist;
		this.qnacommentlist = qnacommentlist;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public PagingQnABoardDTO(int page) {
		super();
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		this.totalpage = total / limit;
		if (total % limit != 0) {
			this.totalpage++;
		}
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		this.offset = (page - 1) * limit;
	}

	public List<QnABoardDTO> getQnaboardlist() {
		return qnaboardlist;
	}

	public void setQnaboardlist(List<QnABoardDTO> qnaboardlist) {
		this.qnaboardlist = qnaboardlist;
	}

	public List<QnABoardCommentDTO> getQnacommentlist() {
		return qnacommentlist;
	}

	public void setQnacommentlist(List<QnABoardCommentDTO> qnacommentlist) {
		this.qnacommentlist = qnacommentlist;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "PagingQnABoardDTO [total=" + total + ", offset=" + offset + ", limit=" + limit + ", page=" + page
				+ ", totalpage=" + totalpage + ", qnaboardlist=" + qnaboardlist + ", qnacommentlist=" + qnacommentlist
				+ "]";
	}

}
