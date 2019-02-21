package com.dto;

public class QnABorderDTO {
	private int qna_num;
	private String qna_title;
	private String nickname;
	private String content;
	private String writedate;
	private String rewritedate;
	private int qna_option;

	public QnABorderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QnABorderDTO(int qna_num, String qna_title, String nickname, String content, String writedate,
			String rewritedate, int qna_option) {
		super();
		this.qna_num = qna_num;
		this.qna_title = qna_title;
		this.nickname = nickname;
		this.content = content;
		this.writedate = writedate;
		this.rewritedate = rewritedate;
		this.qna_option = qna_option;
	}

	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public String getRewritedate() {
		return rewritedate;
	}

	public void setRewritedate(String rewritedate) {
		this.rewritedate = rewritedate;
	}

	public int getQna_option() {
		return qna_option;
	}

	public void setQna_option(int qna_option) {
		this.qna_option = qna_option;
	}

	@Override
	public String toString() {
		return "QnABorderDTO [qna_num=" + qna_num + ", qna_title=" + qna_title + ", nickname=" + nickname + ", content="
				+ content + ", writedate=" + writedate + ", rewritedate=" + rewritedate + ", qna_option=" + qna_option
				+ "]";
	}

}
