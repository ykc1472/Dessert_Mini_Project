package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.PagingQnABorderDTO;
import com.dto.QnABoardCommentDTO;

public class QnABoardDAO {
	public PagingQnABorderDTO selectAllQnABorder(SqlSession session, PagingQnABorderDTO paging) {
		
		paging.setQnABorderlist(session.selectList("BorderMapper.selectAllQnABorder"));
		
		paging.setQnACommentlist(selectQnACommentList(session, paging));
		paging.setTotal(qnaCountAll(session));
		
		return paging;
	}
	public List<QnABoardCommentDTO> selectQnACommentList(SqlSession session, PagingQnABorderDTO paging){
		
		return session.selectList("BorderMapper.selectQnaCommentList", paging.getQnABorderlist());
	}
	public int qnaCountAll(SqlSession session) {
		
		return session.selectOne("BorderMapper.QnACountAll");
	}
}
