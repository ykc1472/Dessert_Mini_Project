var childWin;
var email_check = false;		//
var id_check = false;			//
var pw_check = false;			//
var phone_check = false;		//
var nickName_check = false;		//

$(document).ready(function(){
	$("#domain").on("change", function(event){
		// 이메일 입력 기능 Start
		var email = $("[name='userEMail']").val();
		if($(this).val){
			if(email.indexOf('@') == -1 ){
				email = email +  '@' + $(this).val();
			} else{
				email = email.substr(0, email.indexOf('@'))+ '@' + $(this).val();
			}
		} else {
				email = email.substr(0, email.indexOf('@'))+ '@';
		}
		$("[name='userEMail']").val(email);
		// 이메일 입력 기능 End
	})
	
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
	$("#phoneNumber").on("change", function(event){
		// 휴대폰 번호 가입 중복 체크 Start
		if($(this).val() == ''){
			$("#phoneCheck").html("&nbsp;&nbsp;번호를 입력 해 주세요.");
			$("#phoneCheck").css("color", "red");
			phone_check = false;
		}else{ 
			$.ajax({
				type : "POST",
				url : "PhoneCheckServlet",
				dataType : "text",
				data : {
					phoneNumber : $("#phoneNumber").val()
				},
				success : function(Data, status, xhr) {
				   if(Data == 1){
					   $("#phoneCheck").html("&nbsp;&nbsp;이미 가입된 번호입니다.");
					   $("#phoneCheck").css("color", "red");
					   phone_check = false;
				   } else {
					   $("#phoneCheck").html("&nbsp;&nbsp;사용 가능한 번호입니다.");
					   $("#phoneCheck").css("color", "green");
					   phone_check = true;
				   }
				},
				error : function(xhr, status, error) {
					console.log("error");
				}
			})
		}
		// 휴대폰 번호 가입 중복 체크 End
	});
	
		
	$("#email_certification").on("click", function(event){
		// 이메일 인증하기 새창열기
		childWin = window.open("member/mailCheck.jsp","child","width=485, height=300");
		
		// 이메일 인증하기 새창열기 End
	})
	
	
	$("#nickCheck").on("click", function(event){
		// 닉네임 중복 확인
		if($("#nickName").val() == ''){
			$("#nickCheckResult").html("&nbsp;&nbsp;사용할 닉네임을 입력 해 주세요.");
			$("#nickCheckResult").css("color", "red");
			nickName_check = false;
		}else {
			$.ajax({
				type : "POST",
				url : "NickCheckServlet",
				dataType : "text",
				data : {
					nickName : $("#nickName").val()
				},
				success : function(Data, status, xhr) {
				   if(Data == 1){
					   $("#nickCheckResult").html("&nbsp;&nbsp;이미 사용중인 닉네임 입니다.");
					   $("#nickCheckResult").css("color", "red");
					   nickName_check = false;
				   } else {
					   $("#nickCheckResult").html("&nbsp;&nbsp;사용 가능한 닉네임 입니다.");
					   $("#nickCheckResult").css("color", "green");
					   nickName_check = true;
				   }
				},
				error : function(xhr, status, error) {
					console.log("error");
				}
			})
		}
		// 닉네임 중복 확인 End
	})
	
	$("#userid").on("change", function(event){
		// 사용자 아이디 확인
		var idReg = /^[a-z]+[a-z0-9]{5,14}$/g;
		
        if( !idReg.test($(this).val()) ) {
        	$("#info").text("사용자 아이디는 영문자와 숫자만 사용이 가능합니다.");
			$("#using").html("&nbsp;")
			$("#info").css("color", "red");
            alert("아이디는 영문자로 시작하는 6~15자 영문자 또는 숫자이어야 합니다.");
        }else{
			$.ajax({
				type : "POST",
				url : "IdCheck",
				dataType : "text",
				data : {
					userid : $("#userid").val()
				},
				success : function(Data, status, xhr) {
				   if(Data.trim() == "사용 가능한 ID 입니다."){
					   $("#using").html("<input type='button' id='usingbutton' value='ID 사용하기'>")
					   $("#info").text(Data);
					   $("#info").css("color", "green");
				   }else{
					   $("#using").html("&nbsp;")
					   $("#info").text(Data);
					   $("#info").css("color", "red");
				   }
				},
				error : function(xhr, status, error) {
					console.log("error");
				}
			})
		}
		// 사용자 아이디 확인  End
	})
	
	
	$("body").on("click", "#usingbutton", function(event){
		// 사용 가능한 아이디 사용하기
		$("#userid").attr("readonly", true);
		id_check = true;
		alert($("#userid").val()+"을 사용합니다.");
		$(this).attr("hidden", true);
		// 사용 가능한 아이디 사용하기 end
	})
	
	
	$("form").on("submit", function(event){
		if(!(email_check && id_check && pw_check && phone_check && nickName_check)){
			console.log("email_check"+email_check);
			console.log("id_check"+id_check);
			console.log("pw_check"+pw_check);
			console.log("phone_check"+phone_check);
			console.log("nickName_check"+nickName_check);
			event.preventDefault();
			
			if (!id_check){
				alert("아이디 사용하기 버튼을 눌러주세요.");
				$("#userid").focus();
			}else if (!pw_check){
				alert("비밀번호를 확인하세요.");
				$("[name='userpw']").focus();
			}else if (!nickName_check){
				alert("닉네임을 확인하세요.");
				$("#nickName").focus();
			}else if (!phone_check){
				alert("휴대폰 번호를 확인해 해주세요.");
				$("#phoneNumber").focus();
			}else if(!email_check){
				$("[name='userEMail']").focus();
				alert("E Mail인증을 해주세요.");
			} 
		} else {
			if($("[name='userName']").val().length == 0){
				$("[name='userName']").focus();
				alert("이름을 입력해 주세요.");
				event.preventDefault();
			}
			else if($("#postcode").val().length == 0 || $("#roadAddress").val().length == 0 || $("#jibunAddress").val().length == 0){
				$("#postcode").focus();
				alert("주소를 확인해 주세요.");
				event.preventDefault();
			}
		}
		
	})
})
