<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../content/js/mailCheck.js"></script>
</head>
<body>
	<div style="width: 100%">
		<table>
			<tr>
				<th style="width:120px;">
					사용자 이메일
				</th>
				
				<td style="width:200px;">
					<input type="email" name="userEmail" id="userEmail">
				</td>
				<td style="width:140px;" align="center">
					<input type="button" id="check" value="인증메일보내기">
				</td>
			</tr>
		</table>
		<div id="resultCheck">
			
		</div>
	</div>
</body>
</html>