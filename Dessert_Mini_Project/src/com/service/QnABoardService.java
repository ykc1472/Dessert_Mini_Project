package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.QnABoardDAO;
import com.dto.PagingQnABoardDTO;
import com.dto.QnABoardDTO;

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
	
	public QnABoardDTO seleclt (int qna_num) {
		SqlSession session = MySqlSessionFactory.getSession();
		QnABoardDTO dto = null;
		try {
			QnABoardDAO dao = new QnABoardDAO();
			dto = dao.selectQnABoard(session, qna_num);
			
		} finally {
			session.close();
		}
	
		return dto;
	}
}
