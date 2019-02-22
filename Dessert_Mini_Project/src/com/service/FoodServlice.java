package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.FoodDAO;
import com.dto.FoodInfoDTO;

public class FoodServlice {
	public List<FoodInfoDTO> foodList(int fcategory){
		List<FoodInfoDTO> list = null;
		FoodDAO dao = new FoodDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			list = dao.foodList(session, fcategory);
		} finally {
			if(session != null)
				session.close();
		}
		
		return list;
	}
}
