package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.OrderDAO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

public class OrderService {
	public List<OrderDTO> orderConfirm(List<OrderDTO> orderlist){
		List<OrderDTO> list = null;
		OrderDAO dao = new OrderDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			list = dao.orderConfirm(session, orderlist);
		} finally {
			if(session != null)
				session.close();
		}
		
		return list;
	}
	
	public MemberDTO orderUserInfo(String userid){
		MemberDTO dto = null;
		OrderDAO dao = new OrderDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			dto = dao.orderUserInfo(session, userid);
		} finally {
			if(session != null)
				session.close();
		}
		
		return dto;
	}
}
