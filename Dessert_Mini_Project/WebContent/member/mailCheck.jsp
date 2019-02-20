<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	var email
	var checkNum;
	$(document).ready(function(){
		$("#userEmail").val(opener.$("[name='userEMail']").val());
		$("#check").on("click", function(event){
			$(this).val("인증번호 재전송");
			$.ajax({
				type : "GET",
				url : "../EmailCheck",
				dataType : "text",
				data : {
					userEmail : $("#userEmail").val()
				},
				success : function(Data, status, xhr) {
					var x = "<table><tr><th style='width:120px;'>인증번호</th><td style='width:200px;'><input type='text' name='checker' maxlength='10' id='checker'>";
					x += "<br><span id='result' style='font-size: 9px;'>&nbsp;</span></td><td style='width:140px;' id='usingbutton'>&nbsp;</td></table>";
					$("#resultCheck").html(x);
					alert("인증번호가 " + $("#userEmail").val() + "로 전송되었습니다.");
					$("#checker").focus();
					checkNum = Data.trim();
					console.log(checkNum);
				},
				error : function(xhr, status, error) {
					console.log("error");
				}
			})
		})
		$("body").on("keyup", "#checker", function(event){
			if($(this).val() == checkNum){
				$("#result").text("인증번호가 일치합니다.");
				$("#result").css("color", "green");
				$("#usingbutton").html("<input type='button' value='사용하기' id='using'>")
				
			} else{
				$("#result").text("인증번호가 일치하지 않습니다.");
				$("#result").css("color", "red");
				$("#usingbutton").html("&nbsp;")
			}
		})
		$("body").on("click", "#using" ,function(event){
			if($("#checker").val() == checkNum){
				opener.$("[name='userEMail']").attr("readonly", true);
				opener.$("#domain").attr("hidden", true);
				opener.$("#email_certification").attr("hidden", true);
				opener.email_check = true;
				window.close();
			} else{
				alert("인증번호가 틀렸습니다. \n인증번호를 확인해 주세요.");
			}
		})
	})
 
</script>
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