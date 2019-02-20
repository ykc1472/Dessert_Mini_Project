package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {
	public int phoneNumberCheck(String phoneNumber) {
		SqlSession session = MySqlSessionFactory.getSession();
		int success = 0;
		try {
			MemberDAO dao = new MemberDAO();
			success = dao.phoneNumberCheck(session, phoneNumber);
			
		} finally {
			session.close();
		}
	
		return success;
	}

	public int nickNameCheck (String nickName) {
		SqlSession session = MySqlSessionFactory.getSession();
		int success = 0;
		try {
			MemberDAO dao = new MemberDAO();
			success = dao.nickNameCheck(session, nickName);
			
		} finally {
			session.close();
		}
	
		return success;
	}
	
	public int userIDCheck (String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		int success = 0;
		try {
			MemberDAO dao = new MemberDAO();
			success = dao.userIDCheck(session, userid);
			
		} finally {
			session.close();
		}
	
		return success;
	}
	
	public int userAdd (MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int success = 0;
		try {
			MemberDAO dao = new MemberDAO();
			success = dao.userAdd(session, dto);
			
			session.commit();
		} catch(Exception e) {
			session.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	
		return success;
	}
	
	public MemberDTO loginAction (MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO loginInfo = null;
		try {
			MemberDAO dao = new MemberDAO();
			loginInfo = dao.loginAction(session, dto);
			
			session.commit();
		} catch(Exception e) {
			session.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	
		return loginInfo;
	}
}
