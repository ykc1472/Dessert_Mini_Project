package com.dto;

import java.sql.Date;

public class MemberDTO {
	private String userid;
	private String userpw;
	private String username;
	private String usernickname;
	private String email;
	private String phone;
	private String address_post;
	private String address_f;
	private String address_l;
	private int grade;
	private Date usersingupdate;

	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String userid, String userpw, String username, String usernickname, String email, String phone,
			String address_post, String address_f, String address_l, int grade, Date usersingupdate) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.usernickname = usernickname;
		this.email = email;
		this.phone = phone;
		this.address_post = address_post;
		this.address_f = address_f;
		this.address_l = address_l;
		this.grade = grade;
		this.usersingupdate = usersingupdate;
	}

	public MemberDTO(String userid, String userpw, String username, String usernickname, String email, String phone,
			String address_post, String address_f, String address_l) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.usernickname = usernickname;
		this.email = email;
		this.phone = phone;
		this.address_post = address_post;
		this.address_f = address_f;
		this.address_l = address_l;
	}

	public MemberDTO(String userid, String userpw) {
		super();
		this.userid = userid;
		this.userpw = userpw;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getusernickname() {
		return usernickname;
	}

	public void setusernickname(String usernickname) {
		this.usernickname = usernickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress_post() {
		return address_post;
	}

	public void setAddress_post(String address_post) {
		this.address_post = address_post;
	}

	public String getAddress_f() {
		return address_f;
	}

	public void setAddress_f(String address_f) {
		this.address_f = address_f;
	}

	public String getAddress_l() {
		return address_l;
	}

	public void setAddress_l(String address_l) {
		this.address_l = address_l;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getUsersingupdate() {
		return usersingupdate;
	}

	public void setUsersingupdate(Date usersingupdate) {
		this.usersingupdate = usersingupdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", usernickname="
				+ usernickname + ", email=" + email + ", phone=" + phone + ", address_post=" + address_post
				+ ", address_f=" + address_f + ", address_l=" + address_l + ", grade=" + grade + ", usersingupdate="
				+ usersingupdate + "]";
	}

}
