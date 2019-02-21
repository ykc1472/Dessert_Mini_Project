package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.QnABoardDAO;
import com.dto.PagingQnABorderDTO;

public class QnABoardService {
	public PagingQnABorderDTO selectAllQnABorder(PagingQnABorderDTO paging) {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			QnABoardDAO dao = new QnABoardDAO();
			paging = dao.selectAllQnABorder(session, paging);
			
		} finally {
			session.close();
		}
	
		return paging;
	}
}
