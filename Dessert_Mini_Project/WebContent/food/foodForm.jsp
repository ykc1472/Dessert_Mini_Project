<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#options").on("change", function(event){
			if($(this).val() != '#'){
				var tegs = "<table border='1'><tr><td colspan='2'>옵션1 : 멀티바 바닐라 카라멜 아몬드 (+0원)</td>	<td rowspan='3'><input type='button' value='옵션삭제'></td>";
					tegs += "</tr><tr><td>수량<input type='text' name='amount'> </td><td><img src='content/image/order/down.PNG'>&nbsp;";
					tegs += "<img src='content/image/order/up.PNG'></td></tr><tr><td><span style='font-size: 14px; color: gray;'>10,900원 x 5 개</span></td><td>";
					tegs += "<span style='font-size: 20px; color: red; font-weight: bold;'>54,500</span></td></tr></table>";
				console.log($("#result").html(tegs));
			}
		})
	})

</script>
<body>
	<div>
		<div align="center">
			<form>
				<table border="1">
					<tr>
						<td rowspan="6"><img src="content/image/food/${foodinfoList[0].fmainimage}.jpg" class="goods" /></td>
						<td>제품명</td>
						<td><b>[${foodinfoList[0].categoryname}]</b> ${foodinfoList[0].ftitle}</td>
					<tr>
					<tr>
						<td>가격</td>
						<td><fmt:formatNumber value="${foodinfoList[0].fprice}" pattern="###,###,### 원" /></td>
					</tr>
					<tr>
						<td>옵션</td>
						<td>
							<select id="options">
								<option value="#">옵션을 선택하세요.</option>
								<c:forEach var="foodinfo" items="${foodinfoList}">
									<option value="${foodinfo.foption}">[옵션 ${foodinfo.foption} : ${foodinfo.optionname} 
									(+<fmt:formatNumber value="${foodinfo.optionprice}" pattern="###,###,### 원" />)] /
									재고 : ${foodinfo.stock} 개</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>정보</td>
						<td>
							<div id="result">
							
								
					
								<table>
									<tr>
										<td>옵션1 : 멀티바 그린티 앤 아몬드 (+0원)</td>
										<td>수량<input type="text" name="amount"> +  - </td>
									</tr>
									<tr>
										<td>
											10,900원 x 4 개
										</td>
										<td>
											<span style="font-size: 10px; color: red;">43,600</span>
										</td>
									</tr>
								</table>
									
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" id="order" value="주문하기"> <input type="submit" id="cart" value="장바구니 추가">
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<img src="content/image/food/A08_1.jpg" class="goods" />
						</td>
				</table>
			</form>
		</div>
	</div>
</body>
