package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.FoodInfoDTO;

public class FoodDAO {
	public List<FoodInfoDTO> foodList(SqlSession session, int fcategory){
		List<FoodInfoDTO> list = session.selectList("FoodMapper.FoodList", fcategory);
		return list;
	}
}
