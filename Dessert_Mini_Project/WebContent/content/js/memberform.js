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

	$("[name='userpw']").on("change", function(event){
		// PW 수정시에 PW 확인 초기화 Start
		$("[name='re_userpw']").val("");
		$("#re_pw").html("&nbsp;");
		pw_check = false;
		
		$.ajax({
			type : "POST",
			url : "PasswordRegEx",
			dataType : "text",
			data : {
				password : $(this).val()
			},
			success : function(Data, status, xhr) {
				if(Data == 1){
					$("#pw").html("비밀번호에 숫자, 특수문자가 포함되어야 합니다.");
					$("#re_userpw").attr("readonly", "true");
				}else if(Data == 2){
					$("#pw").html("비밀번호에 영문자 대소문자가 적어도 하나씩은 포함되어야 합니다.");
					$("#re_userpw").attr("readonly", true);
				}else{
					$("#pw").html("&nbsp;");
					$("#re_userpw").attr("readonly", false);
				}
			},
			error : function(xhr, status, error) {
				console.log("error");
			}
		})
		
		// PW 수정시에 PW 확인 초기화 End
	})
	
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


//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
			var extraRoadAddr = ''; // 도로명 조합형 주소 변수

			// 법정동명이 있을 경우 추가한다. (법정리는 제외)
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
				extraRoadAddr += data.bname;
			}
			// 건물명이 있고, 공동주택일 경우 추가한다.
			if (data.buildingName !== '' && data.apartment === 'Y') {
				extraRoadAddr += (extraRoadAddr !== '' ? ', '
						+ data.buildingName : data.buildingName);
			}
			// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			if (extraRoadAddr !== '') {
				extraRoadAddr = ' (' + extraRoadAddr + ')';
			}
			// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
			if (fullRoadAddr !== '') {
				fullRoadAddr += extraRoadAddr;
			}
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
			document.getElementById('roadAddress').value = fullRoadAddr;
			document.getElementById('jibunAddress').value = data.jibunAddress;

			// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
			if (data.autoRoadAddress) {
				//예상되는 도로명 주소에 조합형 주소를 추가한다.
				var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
				document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
					+ expRoadAddr + ')';

			} else if (data.autoJibunAddress) {
				var expJibunAddr = data.autoJibunAddress;
				document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
					+ expJibunAddr + ')';

			} else {
				document.getElementById('guide').innerHTML = '';
			}
		}
	}).open();
}
	