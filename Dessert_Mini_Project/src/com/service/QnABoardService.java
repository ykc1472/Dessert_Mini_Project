package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.QnABoardDAO;
import com.dto.PagingQnABoardDTO;

public class QnABoardService {
	public PagingQnABoardDTO selectAllQnABorder(PagingQnABoardDTO paging) {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			QnABoardDAO dao = new QnABoardDAO();
			paging = dao.selectAllQnABoard(session, paging);
			
		} finally {
			session.close();
		}
	
		return paging;
	}
}
