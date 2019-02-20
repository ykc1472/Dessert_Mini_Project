package com.mail;

import javax.mail.PasswordAuthentication;

public class SendMail extends javax.mail.Authenticator {
	public PasswordAuthentication getPasswordAuthentication() {
		
		/*
		 * 
		 *   네이버에서 메일 환경설정에서 POP3/SMTP 사용함으로 설정해야 된다.

		 * 
		 * 
		 */
		
		System.out.println("PasswordAuthentication");
		// 네이버나 Gmail 사용자 계정 설정.
		// Gmail의 경우 @gmail.com을 제외한 아이디만 입력한다.
		return new PasswordAuthentication("kyeongcheol1472", "Testtest1234");
	}
}