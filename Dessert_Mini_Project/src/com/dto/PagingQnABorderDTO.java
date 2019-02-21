package com.dto;

import java.util.List;

public class PagingQnABorderDTO {

	private int total;
	private int offset;
	private int limit = 10;
	private int page;
	List<QnABoardDTO> QnABorderlist;
	List<QnABoardCommentDTO> QnACommentlist;

	public PagingQnABorderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagingQnABorderDTO(int total, int offset, int limit, int page, List<QnABoardDTO> qnABorderlist,
			List<QnABoardCommentDTO> qnACommentlist) {
		super();
		this.total = total;
		this.offset = offset;
		this.limit = limit;
		this.page = page;
		QnABorderlist = qnABorderlist;
		QnACommentlist = qnACommentlist;
	}

	public PagingQnABorderDTO(int page) {
		super();
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	public List<QnABoardDTO> getQnABorderlist() {
		return QnABorderlist;
	}

	public void setQnABorderlist(List<QnABoardDTO> qnABorderlist) {
		QnABorderlist = qnABorderlist;
	}

	public List<QnABoardCommentDTO> getQnACommentlist() {
		return QnACommentlist;
	}

	public void setQnACommentlist(List<QnABoardCommentDTO> qnACommentlist) {
		QnACommentlist = qnACommentlist;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
