<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/menu.css">
<!--  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!--  -->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&amp;subset=korean" rel="stylesheet" />

<script type="text/javascript">
	<c:if test="${!empty mesg}">
		alert("${mesg}");
		<c:remove var="mesg" />
	</c:if>
	$(document).ready(function(){
		$("#search").autocomplete({
			source : function( request, response ) {
				$.ajax({
					type : "post",
					url : "SearchingFood",
					dataType : "json",
					data : {
						search : $("#search").val().trim()
					},
					success : function(data, status, xhr){
						//서버에서 json 데이터 response 후 목록에 뿌려주기 위함
                        response(
                            $.map(data, function(item) {
                            	console.log(item)
                                return {
                                    label: item.FTITLE,
                                    value: item.FTITLE
                                }
                            })
                        );
					},
					error : function(xhr, status, error) {
						console.log("error");
					}
				})
				// ajax 끝
			},
			minLength: 2,
	        select: function( event, ui ) {
	            // 만약 검색리스트에서 선택하였을때 선택한 데이터에 의한 이벤트발생
	        	console.log(ui);
	            console.log(ui.item);
	        },
	        focus: function(event, ui) {

	            return false;

	            //event.preventDefault();
	        }
	    })
	})
</script>
<div>
	<div class = "font">
		<c:choose>
			<c:when test="${loginInfo != null }">
				<a href="Logout" class="menuTop">로그아웃</a>&nbsp;&nbsp;
				<a href="" class="menuTop">장바구니</a>&nbsp;&nbsp;
				<a href="" class="menuTop">나의정보</a>&nbsp;
			</c:when>
		
			<c:otherwise>
				<a href="loginForm.jsp" class="menuTop">로그인</a>&nbsp;&nbsp;
				<a href="memberForm.jsp" class="menuTop">회원가입</a>&nbsp;
			</c:otherwise>
		</c:choose>
		<div align="center"><a href="main"><img src="content/image/order/mainBanner.jpg" width = "200"></a>
		
		</div>
		<div>
			<form action="SearchingFoodList" method="get">
				<input type="text" name="search" id="search"> <input type="submit" value="검색">
			</form>
			 
		</div>
	</div>
	
</div>
