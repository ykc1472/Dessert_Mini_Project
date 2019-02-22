package com.dto;

public class FoodInfoDTO {
	private int sales;
	private String fcode; // 푸드코드
	private String ftitle;
	private int fprice;
	private String fimage;
	private String fcategory;
	private String content;
	private String fmainimage;
	private int foption;

	public FoodInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodInfoDTO(int sales, String fcode, String ftitle, int fprice, String fimage, String fcategory,
			String content, String fmainimage) {
		super();
		this.sales = sales;
		this.fcode = fcode;
		this.ftitle = ftitle;
		this.fprice = fprice;
		this.fimage = fimage;
		this.fcategory = fcategory;
		this.content = content;
		this.fmainimage = fmainimage;
	}

	public int getFoption() {
		return foption;
	}

	public void setFoption(int foption) {
		this.foption = foption;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public int getFprice() {
		return fprice;
	}

	public void setFprice(int fprice) {
		this.fprice = fprice;
	}

	public String getFimage() {
		return fimage;
	}

	public void setFimage(String fimage) {
		this.fimage = fimage;
	}

	public String getFcategory() {
		return fcategory;
	}

	public void setFcategory(String fcategory) {
		this.fcategory = fcategory;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFmainimage() {
		return fmainimage;
	}

	public void setFmainimage(String fmainimage) {
		this.fmainimage = fmainimage;
	}

	@Override
	public String toString() {
		return "FoodInfoDTO [sales=" + sales + ", fcode=" + fcode + ", ftitle=" + ftitle + ", fprice=" + fprice
				+ ", fimage=" + fimage + ", fcategory=" + fcategory + ", content=" + content + ", fmainimage="
				+ fmainimage + "]";
	}

}
