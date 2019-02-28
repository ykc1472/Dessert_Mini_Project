package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.OrderDTO;

public class CartDAO {
	public int cartAdd(SqlSession session, List<OrderDTO> cartList){
		return session.insert("CartMapper.InsertAllcart", cartList);
	}
	
	public List<OrderDTO> selectAddInfoCart(SqlSession session, List<OrderDTO> cartList) {
		return session.selectList("CartMapper.selectAddInfoCart", cartList);
	}
	
	public List<OrderDTO> selectCartList(SqlSession session, String userid){
		System.out.println(userid);
		// 유저의 cart 정보를 보여주는 쿼리
		return session.selectList("CartMapper.selectCartList", userid);
	}

}
