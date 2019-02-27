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

}
