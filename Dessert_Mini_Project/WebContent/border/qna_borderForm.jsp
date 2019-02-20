<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div align="center">
	<form action="#" method="post">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" maxlength="50"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea name=content rows ="15" cols="100"></textarea></td>
			</tr>
			<tr>
				<th>공개여부</th>
				<td><input type="checkbox" name="" value="1"> 질문을 누구나 읽을수 있도록 공개합니다.</td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="질문하기">&nbsp;&nbsp;<input type="reset" value="다시 작성하기"></td>
			</tr>
			
		</table>
	</form>
</div>