package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.OrderDAO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;

public class OrderService {
	public List<OrderDTO> orderConfirm(List<OrderDTO> orderlist){
		OrderDAO dao = new OrderDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			orderlist = dao.orderConfirm(session, orderlist);
		} finally {
			if(session != null)
				session.close();
		}
		
		return orderlist;
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
	
	public int orderDone(List<OrderDTO> orderList) {
		MemberDTO dto = null;
		OrderDAO dao = new OrderDAO();
		int success = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			success = dao.orderDone(session, orderList);
			if(success == orderList.size()) {
				session.commit();
			}else {
				throw new Exception("모든 상품이 Insert되지 못함");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.rollback();
		}finally {
			if(session != null)
				session.close();
		}
		
		return success;
	}
}
