<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="content/js/postAddress.js"></script>
<link rel="stylesheet" href="content/css/memberForm.css">

    
<%
 MemberDTO dto =(MemberDTO)session.getAttribute("loginInfo");
 String userid = dto.getUserid();
 String userpw = dto.getUserpw();
 String username = dto.getUsername();
 String usernickname = dto.getusernickname();
 String email = dto.getEmail();
 String phone = dto.getPhone();
 String address_post = dto.getAddress_post();
 String address_f = dto.getAddress_f();
 String address_l = dto.getAddress_l();
%>  
  
<script type="text/javascript">
$(document).ready(function(){
	$("[name='re_userpw']").on("change", function(event){
		// PW 일치 확인 Start
		
		if($(this).val() == $("[name='userpw']").val()){
			$("#re_pw").html("&nbsp;");
			pw_check = true;
		} else{
			$("#re_pw").html("비밀번호가 서로 다릅니다.");
			pw_check = false;
		}
		// pw 일치 확인 End
	})
	
	$("[name='userpw']").on("keyup", function(event){
		// PW 수정시에 PW 확인 초기화 Start
//		$("[name='re_userpw']").val("");
//		$("#re_pw").html("&nbsp;");
//		pw_check = false;
//		
//		$.ajax({
//			type : "POST",
//			url : "PasswordRegEx",
//			dataType : "text",
//			data : {
//				password : $(this).val()
//			},
//			success : function(Data, status, xhr) {
//				if(Data == 1){
//					$("#pw").html("비밀번호에 숫자, 특수문자가 포함되어야 합니다.");
//					$("#re_userpw").attr("readonly", "true");
//				}else if(Data == 2){
//					$("#pw").html("비밀번호에 영문자 대소문자가 적어도 하나씩은 포함되어야 합니다.");
//					$("#re_userpw").attr("readonly", true);
//				}else{
//					$("#pw").html("&nbsp;");
//					$("#re_userpw").attr("readonly", false);
//				}
//			},
//			error : function(xhr, status, error) {
//				console.log("error");
//			}
//		})
//		
		
		var strength_grade = new Array();
		strength_grade[0] = '매우 안전하지 않은 비밀번호';
		strength_grade[1] = '안전하지 않은 비밀번호';
		strength_grade[2] = '권장하지 않은 비밀번호';
		strength_grade[3] = '안정적인 비밀번호';
		strength_grade[4] = '안전한 비밀번호';
		strength_grade[5] = '매우 강력한 비밀번호';

		var strength = passwordGrade($(this).val());

		$("#pw").text(strength_grade[strength]);
		$("#password_grade").attr("class", "strength_" + strength);
		
		// PW 수정시에 PW 확인 초기화 End
	})
	function passwordGrade(password) {
		var score = 0;

		// Length at least 8 chars long
		if (password.length >= 8)
			score++;

		// both lower and uppercase chars
		if (password.match(/[a-z]/) && password.match(/[A-Z]/))
			score++;

		// at least one num char
		if (password.match(/[0-9]+/))
			score++;

		// at least one special char
		if (password.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)-]/))
			score++;

		// Length at least 12 chars long
		if (password.length >= 12)
			score++;

		return score;
	}
});
</script>	

<div align="center">
	<form action="MemberUpdateServlet" method="post">
		<table border="1">
			<tr>
				<th>아이디 </th>
				<td colspan="2"><%= userid %><br></td>
			</tr>
			<tr>
				<th>기존 비밀번호</th>
				<td colspan="2"><%= userpw %><br>
					
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td colspan="2"><input type="password" name="userpw" maxlength="20" id="password"><br>
					<span id="password_grade"><span id="pw" class="strength_0" id="password_grade">새 비밀번호를 입력하세요.</span></span></td>
			</tr>
			<tr>
				<th>새 비밀번호 확인</th>
				<td colspan="2"><input type="password" name="re_userpw" id="re_userpw" maxlength="20"><br>
					<span class="re_pw" id="re_pw" style="font-size: 9px; color: red;">&nbsp;</span></td>
			</tr>
			<tr>
				<th>이름</th>
				<td colspan="2"><%= username %><br></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>
					<input type="text" value="<%= usernickname %>" name="nickName" id="nickName"><br>
					<span id="nickCheckResult" style="font-size: 9px; color: red;">&nbsp;</span>
				</td>
				<td><input type="button" id="nickCheck" value="중복검사"><br></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td colspan="2"><input type="email" value="<%= email %>" name="userEMail" id="email" readonly  > 
<!-- 				<select	id="domain">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="daum.net">daum.net</option>
						<option value="nate.com">nate.com</option>
						<option value="hotmail.com">hotmail.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="icloud.com">icloud.com</option>
				</select><br> <span id="emailCheck">&nbsp;</span></td> -->
				
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<td colspan="2"><input type="text" value="<%= phone %>" name="userPhoneNum" maxlength="11" placeholder="- 없이 입력하세요." id="phoneNumber"><br> 
					<span id="phoneCheck" style="font-size: 9px;">&nbsp;</span>
				</td>
			</tr>
			<tr>
				<th rowspan="3">주소</th>
				<td colspan="2"><input type="text" value="<%= address_post %>" name="post" id="postcode"
					placeholder="우편번호"> <input type="button"
					onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" value="<%= address_f %>" name="addr1" id="roadAddress"
					placeholder="도로명주소"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" value="<%= address_l %>" name="addr2" id="jibunAddress"
					placeholder="지번주소"><span id="guide" style="color:#999"></span></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
				<input type="submit" value="수정하기">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기"></td>
			</tr>
		</table>
	</form>
</div>
