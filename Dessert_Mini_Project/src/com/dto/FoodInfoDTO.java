package com.dto;

public class FoodInfoDTO {
	
	private int sales;
	private String fcode; // 푸드코드
	private String ftitle;
	private int fprice;
	private String fimage;
	private int fcategory;
	private String categoryname;
	private String content;
	private String fmainimage;
	private int foption;
	private int optionprice;
	private int stock;
	private String optionname;

	public FoodInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FoodInfoDTO(String fcode, int foption) {
		super();
		this.fcode = fcode;
		this.foption = foption;
	}



	public FoodInfoDTO(String fcode, String ftitle, int fprice, String fimage, int fcategory, String content,
			String fmainimage, int foption, int optionprice, int stock, String optionname) {
		super();
		this.fcode = fcode;
		this.ftitle = ftitle;
		this.fprice = fprice;
		this.fimage = fimage;
		this.fcategory = fcategory;
		this.content = content;
		this.fmainimage = fmainimage;
		this.foption = foption;
		this.optionprice = optionprice;
		this.stock = stock;
		this.optionname = optionname;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setFcategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public int getOptionprice() {
		return optionprice;
	}

	public void setOptionprice(int optionprice) {
		this.optionprice = optionprice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getOptionname() {
		return optionname;
	}

	public void setOptionname(String optionname) {
		this.optionname = optionname;
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

	public int getFcategory() {
		return fcategory;
	}

	public void setFcategory(int fcategory) {
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
				+ ", fimage=" + fimage + ", fcategory=" + fcategory + ", fcategoryname=" + categoryname + ", content="
				+ content + ", fmainimage=" + fmainimage + ", foption=" + foption + ", optionprice=" + optionprice
				+ ", stock=" + stock + ", optionname=" + optionname + "]";
	}

	
}
