package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.PagingQnABoardDTO;
import com.dto.QnABoardCommentDTO;
import com.dto.QnABoardDTO;

public class QnABoardDAO {
	public PagingQnABoardDTO selectAllQnABoard(SqlSession session, PagingQnABoardDTO paging) {
		paging.setQnaboardlist(session.selectList("BoardMapper.selectAllQnABoard", null, new RowBounds(paging.getOffset(), paging.getLimit())));
		
		paging.setQnacommentlist(selectQnACommentList(session, paging));
		paging.setTotal(qnaCountAll(session));
		
		return paging;
	}
	public List<QnABoardCommentDTO> selectQnACommentList(SqlSession session, PagingQnABoardDTO paging){
		
		return session.selectList("BoardMapper.selectQnaCommentList", paging.getQnaboardlist());
	}
	
	public int qnaCountAll(SqlSession session) {
		
		return session.selectOne("BoardMapper.QnACountAll");
	}
	
	public QnABoardDTO selectQnABoard(SqlSession session, int qna_num) {
		
		return session.selectOne("BoardMapper.selectQnABoard", qna_num);
	}
	
	
}
