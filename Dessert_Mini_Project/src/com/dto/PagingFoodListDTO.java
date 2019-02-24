package com.dto;

import java.util.List;

public class PagingFoodListDTO {

	private String fcode;
	private String ftitle;
	private int category;
	private int total;
	private int offset = 0;
	private int limit = 6;
	private int page = 1;
	private int totalpage;
	private int startpage = 1;
	private List<FoodInfoDTO> foodlist;

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public PagingFoodListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagingFoodListDTO(int total, int offset, int limit, int page, int category, List<FoodInfoDTO> foodlist) {
		super();
		this.total = total;
		this.offset = offset;
		this.limit = limit;
		this.page = page;
		this.category = category;
		this.foodlist = foodlist;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
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

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public List<FoodInfoDTO> getFoodlist() {
		return foodlist;
	}

	public void setFoodlist(List<FoodInfoDTO> foodlist) {
		this.foodlist = foodlist;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		this.offset = (page - 1) * limit;
	}

	@Override
	public String toString() {
		return "PagingFoodListDTO [fcode=" + fcode + ", ftitle=" + ftitle + ", category=" + category + ", total="
				+ total + ", offset=" + offset + ", limit=" + limit + ", page=" + page + ", totalpage=" + totalpage
				+ ", foodlist=" + foodlist + "]";
	}

}
