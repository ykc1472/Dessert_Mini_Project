<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="content/js/memberform.js"></script>
<script type="text/javascript" src="content/js/postAddress.js"></script>
<link rel="stylesheet" href="content/css/memberForm.css">
<script type="text/javascript">

</script>
<div align="center">
	<form action="UserAdd" method="post">
		<table border="1">
			<tr>
				<th>아이디 :</th>
				<td><input type="text" name="userid" id="userid" maxlength="15"><br>
					<span id="info" style="font-size: 9px; color: red;">사용자 아이디는 영문자와 숫자만 사용이 가능합니다. </span></td>
				<td align="center"><div id="using">&nbsp;</div></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td colspan="2"><input type="password" name="userpw" maxlength="20" id="password"><br>
					<span id="password_grade"><span id="pw" class="strength_0" id="password_grade">비밀번호를 입력하세요.</span></span></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td colspan="2"><input type="password" name="re_userpw" id="re_userpw" maxlength="20"><br>
					<span class="re_pw" id="re_pw" style="font-size: 9px; color: red;">&nbsp;</span></td>
			</tr>
			<tr>
				<th>이름</th>
				<td colspan="2"><input type="text" name="userName"><br></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>
					<input type="text" name="nickName" id="nickName"><br>
					<span id="nickCheckResult" style="font-size: 9px; color: red;">&nbsp;</span>
				</td>
				<td><input type="button" id="nickCheck" value="중복검사"><br></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="userEMail"> 
				<select	id="domain">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="daum.net">daum.net</option>
						<option value="nate.com">nate.com</option>
						<option value="hotmail.com">hotmail.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="icloud.com">icloud.com</option>
				</select><br> <span id="emailCheck">&nbsp;</span></td>
				<td><input type="button" id="email_certification"
					value="이메일 인증하기"></td>
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<td colspan="2"><input type="text" name="userPhoneNum" maxlength="11" placeholder="- 없이 입력하세요." id="phoneNumber"><br> 
					<span id="phoneCheck" style="font-size: 9px;">&nbsp;</span>
				</td>
			</tr>
			<tr>
				<th rowspan="3">주소</th>
				<td colspan="2"><input type="text" name="post" id="postcode"
					placeholder="우편번호"> <input type="button"
					onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" name="addr1" id="roadAddress"
					placeholder="도로명주소"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" name="addr2" id="jibunAddress"
					placeholder="지번주소"><span id="guide" style="color:#999"></span></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="가입하기">&nbsp;&nbsp;<input type="reset" value="다시쓰기"></td>
			</tr>
		</table>
	</form>
</div>
