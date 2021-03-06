package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.FoodInfoDTO;
import com.dto.PagingFoodListDTO;

public class FoodDAO {
	public PagingFoodListDTO foodList(SqlSession session, PagingFoodListDTO paging){
		List<FoodInfoDTO> list = session.selectList("FoodMapper.FoodList", paging.getCategory(), new RowBounds(paging.getOffset(), paging.getLimit()));
		paging.setFoodlist(list);
		paging.setTotal(foodTotalCount(session, paging.getCategory()));
		
		return paging;
	}
	
	public int foodTotalCount(SqlSession session, int category) {
		// 페이징 처리를 위한 검색 조건에 따른 전체 개수 검색
		return session.selectOne("FoodMapper.foodTotalCount", category);
	}
	
	public List<FoodInfoDTO> foodInfo(SqlSession session, String fcode) {
		
		return session.selectList("FoodMapper.foodInfo", fcode);
		
	}
	
	public PagingFoodListDTO foodNewList(SqlSession session, PagingFoodListDTO paging){
		List<FoodInfoDTO> list = session.selectList("FoodMapper.foodNewList", null, new RowBounds(paging.getOffset(), paging.getLimit()));
		paging.setFoodlist(list);
		paging.setTotal(foodnewTotal(session));
		
		return paging;
	}
	
	public int foodnewTotal(SqlSession session) {
		return session.selectOne("FoodMapper.foodNewTotal");
	}
	
	public List<HashMap<String, String>> searchFoodList(SqlSession session, String search){
		// 검색어를 받아서 해당하는 결과가 들어간 Title을 모두 리턴해준다.
		return session.selectList("FoodMapper.searchFoodList", search);
	}
	
	
	public PagingFoodListDTO searchingList(SqlSession session, PagingFoodListDTO paging) {
		List<FoodInfoDTO> list = session.selectList("FoodMapper.searchingList", paging.getFtitle(), new RowBounds(paging.getOffset(), paging.getLimit()));
		paging.setFoodlist(list);
		paging.setTotal(searchingListTotal(session, paging.getFtitle()));
		
		return paging;
	}
	
	public int searchingListTotal(SqlSession session, String ftitle) {
		return session.selectOne("FoodMapper.searchingListTotal", ftitle);
	}

	public int checkStock(SqlSession session, String fcode, int foption) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("fcode", fcode);
		map.put("foption", foption);
		
		return session.selectOne("FoodMapper.checkStock", map);
	}
}
