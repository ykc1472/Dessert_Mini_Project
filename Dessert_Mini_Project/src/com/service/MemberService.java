package com.service;

import java.util.HashMap;

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
			if(session != null)
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
			if(session != null)
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
			if(session != null)
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
			if(session != null)
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
			if(session != null)
			session.close();
		}
	
		return loginInfo;
	}

	public HashMap<String, String> idSearch(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		HashMap<String, String> map = null;
		try {
			MemberDAO dao = new MemberDAO();
			map = dao.idSearch(session, dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return map;
	}
}
