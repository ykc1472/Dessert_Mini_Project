<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
body {
	font-family: 'Nanum Gothic', sans-serif;
}
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
			<col width="50" />
			<col width="500" />
			<col width="100" />
			<col width="50" />
		</colgroup>
		<thead>
			<tr>
				<th>번 호</th>
				<th>제 목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조 회</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td align="center">3</td>
				<td><a href="qna_borderSelect?${selectPage}">타이틀</a></td>
				<td align="center">내가 작성함?</td>
				<td align="center">언제</td>
				<td align="center">조회수</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td align="center" colspan="5">
					<span id ="selectPage" style="color: red;">1</span>
				</td>
			</tr>
		</tfoot>		
	</table>
		<input type="button" value="처음으로" onclick="move('Board_List.jsp');" />
		<input type="button" value="글쓰기" onclick="move('Board_Write.jsp');" />
</div>
