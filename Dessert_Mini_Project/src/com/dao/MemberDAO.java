package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	public int phoneNumberCheck(SqlSession session, String phoneNumber) {
		int success = session.selectOne("MemberMapper.phoneNumberCheck", phoneNumber);
		
		return success;
	}
	
	public int nickNameCheck(SqlSession session, String nickName) {
		int success = session.selectOne("MemberMapper.nickNameCheck", nickName);
		
		return success;
	}
	
	public int userIDCheck(SqlSession session, String userid) {
		int success = session.selectOne("MemberMapper.userIDCheck", userid);
		
		return success;
	}
	
	public int userAdd(SqlSession session, MemberDTO dto) {
		int success = session.insert("MemberMapper.userAdd", dto);
		
		return success;
	}
	
	public MemberDTO loginAction(SqlSession session, MemberDTO dto) {
		MemberDTO loginInfo = session.selectOne("MemberMapper.loginAction", dto);
	
		return loginInfo;
	}

	public HashMap<String, String> idSearch(SqlSession session, MemberDTO dto) {
		HashMap map = session.selectOne("MemberMapper.idSearch",dto);
		return map;
	}
	
	public String passwdSearch2(SqlSession session, MemberDTO dto) {
		String success = session.selectOne("MemberMapper.passwdSearch2",dto);
		return success;
	}
	
	public String passwdSearch(SqlSession session, MemberDTO dto) {
		String success = session.selectOne("MemberMapper.passwdSearch",dto);
		return success;
	}
}
