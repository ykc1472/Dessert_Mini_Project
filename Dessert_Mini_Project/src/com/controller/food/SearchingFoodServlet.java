package com.controller.food;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.service.FoodService;

@WebServlet("/SearchingFood")
public class SearchingFoodServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// json 파일로 만들기 위해서 json-simple-1.1.1.jar 파일 필요
	
		//최상단 json객체
		JSONObject jsonroot=new JSONObject();

//		List<String> selectlist = null;
		List<HashMap<String, String>> selectlist = null;
		String search = request.getParameter("search");
		FoodService service = new FoodService();
			
		selectlist = service.searchFoodList(search);
	
		JSONArray jsonList = new JSONArray();
		//가상DB목록을 JSON배열목록에 출력하기 위한 임의의 JSON오브젝트
		JSONObject object =null;
		//DB에서 조회한 값을 반복문을 이용하여 객체 하나씩 뽑아온다
		
		for(Map<String,String> selectone : selectlist){
			Set<String> set = selectone.keySet();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				object = new JSONObject();
				String key = it.next();
				object.put(key, selectone.get(key));
				jsonList.add(object);
			}
		    
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print(jsonList);
		pw.flush();
		pw.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
