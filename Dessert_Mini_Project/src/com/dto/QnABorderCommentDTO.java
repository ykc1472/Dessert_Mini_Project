package com.dto;

public class QnABorderCommentDTO {
	private int qna_num;
	private String qnac_title;
	private String writedate;
	private String rewritedate;
	private String nickname;
	private String content;

	public QnABorderCommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QnABorderCommentDTO(int qna_num, String qnac_title, String writedate, String rewritedate, String nickname,
			String content) {
		super();
		this.qna_num = qna_num;
		this.qnac_title = qnac_title;
		this.writedate = writedate;
		this.rewritedate = rewritedate;
		this.nickname = nickname;
		this.content = content;
	}

	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}

	public String getQnac_title() {
		return qnac_title;
	}

	public void setQnac_title(String qnac_title) {
		this.qnac_title = qnac_title;
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

	@Override
	public String toString() {
		return "QnABorderDTO [qna_num=" + qna_num + ", qnac_title=" + qnac_title + ", writedate=" + writedate
				+ ", rewritedate=" + rewritedate + ", nickname=" + nickname + ", content=" + content + "]";
	}
}
