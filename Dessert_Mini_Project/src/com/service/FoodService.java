package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.FoodDAO;
import com.dto.FoodInfoDTO;
import com.dto.PagingFoodListDTO;

public class FoodService {
	public PagingFoodListDTO foodList(PagingFoodListDTO paging){
		// 제품 목록을 보여주기 위한 서비스
		// 해당하는 카테고리를 DAO로 보내줘서 제품의 정보를 가져온다.
		FoodDAO dao = new FoodDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			paging = dao.foodList(session, paging);
		} finally {
			if(session != null)
				session.close();
		}
		
		return paging;
	}
	
	public List<FoodInfoDTO> foodInfo(String fcode){
		// foodForm.jsp 요청시 한개의 제품정보를 가지고 돌아간다.
		// list를 사용하는 이유는 조인문에 의해서 옵션에 따라 결과가 1개 이상 나올 수 있기 때문이다.
		List<FoodInfoDTO> list = null;
		FoodDAO dao = new FoodDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			list = dao.foodInfo(session, fcode);
		} finally {
			if(session != null)
				session.close();
		}
		
		return list;
	}
	
	public PagingFoodListDTO foodNewList(PagingFoodListDTO paging){
		FoodDAO dao = new FoodDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			paging = dao.foodNewList(session, paging);
		} finally {
			if(session != null)
				session.close();
		}
		
		return paging;
	}
	
	public List<HashMap<String, String>> searchFoodList(String search){
		FoodDAO dao = new FoodDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		List<HashMap<String, String>> list = null;
		try {
			list = dao.searchFoodList(session, search);
		} finally {
			if(session != null)
				session.close();
		}
		
		return list;
	}
	
}
