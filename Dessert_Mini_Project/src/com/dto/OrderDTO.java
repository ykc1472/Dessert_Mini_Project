package com.dto;

import java.sql.Date;

public class OrderDTO extends FoodInfoDTO {
	private int ordernum;
	private String userid;
	private String username;
	private String orderdate;
	private int state;
	private int amount;
	private int addr_post;
	private int payMethod;
	private int payment;
	private String addr_f;
	private String addr_l;

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(String fcode, int foption) {
		super(fcode, foption);
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(String fcode, int foption, String userid, int amount, int addr_post, String addr_f, String addr_l) {
		super(fcode, foption);
		this.userid = userid;
		this.amount = amount;
		this.addr_post = addr_post;
		this.addr_f = addr_f;
		this.addr_l = addr_l;
	}

	public OrderDTO(String fcode, String ftitle, int fprice, String fimage, int fcategory, String content,
			String fmainimage, int foption, int optionprice, int stock, String optionname) {
		super(fcode, ftitle, fprice, fimage, fcategory, content, fmainimage, foption, optionprice, stock, optionname);
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderDTO(String fcode, int foption, String userid, int amount) {
		super(fcode, foption);
		this.userid = userid;
		this.amount = amount;
	}

	public OrderDTO(int ordernum, String userid, String orderdate, int state, int amount, int addr_post, String addr_f,
			String addr_l) {
		super();
		this.ordernum = ordernum;
		this.userid = userid;
		this.orderdate = orderdate;
		this.state = state;
		this.amount = amount;
		this.addr_post = addr_post;
		this.addr_f = addr_f;
		this.addr_l = addr_l;
	}
	
	

	public OrderDTO(String fcode, int foption, String userid, int amount, int addr_post,
			String addr_f, String addr_l, int payMethod, int payment) {
		super(fcode, foption);
		this.userid = userid;
		this.amount = amount;
		this.addr_post = addr_post;
		this.payMethod = payMethod;
		this.payment = payment;
		this.addr_f = addr_f;
		this.addr_l = addr_l;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAddr_post() {
		return addr_post;
	}

	public void setAddr_post(int addr_post) {
		this.addr_post = addr_post;
	}

	public String getAddr_f() {
		return addr_f;
	}

	public void setAddr_f(String addr_f) {
		this.addr_f = addr_f;
	}

	public String getAddr_l() {
		return addr_l;
	}

	public void setAddr_l(String addr_l) {
		this.addr_l = addr_l;
	}
	
	
	public int getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(int payMethod) {
		this.payMethod = payMethod;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "OrderDTO [ordernum=" + ordernum + ", userid=" + userid + ", orderdate=" + orderdate + ", state=" + state
				+ ", amount=" + amount + ", addr_post=" + addr_post + ", addr_f=" + addr_f + ", addr_l=" + addr_l
				+ ", toString()=" + super.toString() + "]";
	}

	

	

}
