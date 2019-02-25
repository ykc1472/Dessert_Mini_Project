package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;
import com.dto.OrderDTO;

public class OrderDAO {
	public List<OrderDTO> orderConfirm(SqlSession session, List<OrderDTO> orderList){
		
		for(int i = 0 ; i < orderList.size() ; i++) {
			OrderDTO dto = session.selectOne("OrderMapper.orderConfirm", orderList.get(i));
			
			orderList.get(i).setFcategoryname(dto.getCategoryname());
			orderList.get(i).setFcode(dto.getFcode());
			orderList.get(i).setFtitle(dto.getFtitle());
			orderList.get(i).setContent(dto.getContent());
			orderList.get(i).setFprice(dto.getFprice());
			orderList.get(i).setFmainimage(dto.getFmainimage());
			orderList.get(i).setOptionname(dto.getOptionname());
			orderList.get(i).setOptionprice(dto.getOptionprice());
			orderList.get(i).setStock(dto.getStock());
		}
		
		return orderList;
	}
	
	public MemberDTO orderUserInfo(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("MemberMapper.orderUserInfo", userid);
		return dto;
	}
	
	public int orderDone(SqlSession session, List<OrderDTO> orderList) {
		
		int success = session.insert("OrderMapper.orderDone", orderList);
		return success;
	}
}
