package com.food;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
@WebServlet("/JSONTest")
public class JSONTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//최상단 json객체
		JSONObject jsonroot=new JSONObject();
		//가상의 list객체 (db에서 조회한 결과라고 가정)
		ArrayList<Map<String,Object>> selectlist=new ArrayList<Map<String,Object>>();
		Map<String,Object> dbmap=null;
		for(int i=0;i<20;i++){
		    dbmap=new HashMap<String,Object>();
		    dbmap.put("data", "가상의DB데이터"+i);
		    selectlist.add(dbmap);
		}
		//json 배열목록을 담아줄 jsonarray 객체생성
		JSONArray jsonList=new JSONArray();
		//가상DB목록을 JSON배열목록에 출력하기 위한 임의의 JSON오브젝트
		JSONObject jsontmp=null;
		//DB에서 조회한 값을 반복문을 이용하여 객체 하나씩 뽑아온다
		for(Map<String,Object> selectone : selectlist){
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print(jsonroot);
		pw.flush();
		pw.close();

		
		//사용자페이지에서 넘겨준 가상의 문자열 json data (request.getparameter을 이용하여 받았다고 가정합니다)
		String requestgetparameter="{\"jsonstring1\":\"가상의문자열데이터1\",\"jsonstring2\":\"가상의문자열데이터2\"}";
		if(requestgetparameter.substring(0,1).equals("{")){
		    //단순 object형식일 경우 JSONValue.parse를 이용해줍니다
		    Object jsonobject=JSONValue.parse(requestgetparameter);
		    JSONObject jsonobj=(JSONObject)jsonobject;
		    System.out.println("[JSON 오브젝트파싱후 각각의 KEY로 VALUE값 출력]");
		    System.out.println(jsonobj.get("jsonstring1"));
		    System.out.println(jsonobj.get("jsonstring2"));
		}
		//서버에서 request.getparameter()로 받은 데이터라 가정
		String requestgetparameter2="[{\"jsonstring\":\"가상의문자열배열데이터1\"},{\"jsonstring\":\"가상의문자열배열데이터2\"}]";
		if(requestgetparameter2.substring(0,1).equals("[")){
		    Object jsonarray=JSONValue.parse(requestgetparameter2);
		    JSONArray jsonarr=(JSONArray)jsonarray;
		    System.out.println("[반복문을 돌려서 JSON 배열 파싱후 각각의 KEY로 VALUE값 출력]");
		    for(int i=0;i<jsonarr.size();i++){
		        JSONObject jsonobj=(JSONObject)jsonarr.get(i);
		        System.out.println(jsonobj.get("jsonstring"));
		    }
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
