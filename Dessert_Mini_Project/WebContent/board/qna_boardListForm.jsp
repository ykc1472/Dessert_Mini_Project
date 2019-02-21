<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>

</style>

<script type="text/javascript">
	function move(url){
		location.href=url;
	}
</script>
</head>

<div align="center">
	<marquee behavior="alternate" scrolldelay="100" direction="right">
	디저트는 사랑이야!</marquee>
	<table class="bbs" width="800" height="200" border="2">
		<colgroup>
			<col width="100" />
			<col width="500" />
			<col width="150" />
			<col width="155" />
		</colgroup>
		<thead>
			<tr>
				<th>번 호</th>
				<th>제 목</th>
				<th>작성자</th>
				<th>작성일</th>
				
			</tr>
		</thead>
		<tbody>
		<c:forEach var="list" items="${paging.qnaboardlist}">
			<tr>
				<td align="center">${list.qna_num}</td>
				<td><a href="QnABoardForm?pick=${list.qna_num}">${list.qna_title}</a></td>
				<td align="center">${list.nickname}</td>
				<td align="center">${list.writedate}</td>
			</tr>
			<c:forEach var="commentlist" items="${paging.qnacommentlist}">
				<c:if test="${commentlist.qna_num == list.qna_num}">
					<tr>
						<td align="center">&nbsp;ㄴ</td>
						<td><a href="qna_CommentBoardForm?pick=${commentlist.qna_num}">${commentlist.qnac_title}</a></td>
						<td align="center">${commentlist.nickname}</td>
						<td align="center">${commentlist.writedate}</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:forEach>
		</tbody>
	
		<tfoot>
			<tr>
				<td align="center" colspan="5">
					<span id ="selectPage" style="color: red;">
						1
					</span>
				</td>
			</tr>
		</tfoot>		
	</table>
		
		<input type="button" value="처음으로" onclick="move('Board_List.jsp');" />
		<input type="button" value="글쓰기" onclick="move('Board_Write.jsp');" />
</div>
