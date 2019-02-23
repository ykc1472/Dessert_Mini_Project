package com.food;

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
			
		selectlist = service.searchFoodList("유기농");
	
		JSONArray jsonList=new JSONArray();
		//가상DB목록을 JSON배열목록에 출력하기 위한 임의의 JSON오브젝트
		JSONObject jsontmp=null;
		//DB에서 조회한 값을 반복문을 이용하여 객체 하나씩 뽑아온다
		
		for(Map<String,String> selectone : selectlist){
		    Set<String> key=selectone.keySet();
		    //MAP의 KEY/VALUE를 통하여 JSON임시객체에 담아준후
		    for (Iterator<String> iterator=key.iterator();iterator.hasNext();){
		        String tmpekey=(String) iterator.next();
		        String tmpvalue=(String) selectone.get(tmpekey);
		        jsontmp=new JSONObject();
		        
		        jsontmp.put(tmpekey, tmpvalue);
		    }
		    //JSON배열목록에 추가
		    jsonList.add(jsontmp);
		}
		//db목록 json set
		jsonroot.put("result",jsonList);
		//성공여부
		jsonroot.put("success",true);
//		for(String select : selectlist) {
//			jsonList.add(select);
//		}
//		jsonroot.put("result",jsonList);
//		jsonroot.put("success",true);
//		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print(jsonroot);
		pw.flush();
		pw.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
