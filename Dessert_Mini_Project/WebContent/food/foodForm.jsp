<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){
		
		//옵션 선택 하지 않을 경우 창이 넘어가지 않고, 알림창('장바구니추가'버튼)
		$("#cart").on("click", function(event) {
			var result = $("#result").html().trim();
					if (result.length==0) {
						alert("옵션을 선택해주세요.");
						event.preventDefault();
					}
				});

		//옵션 선택 하지 않을 경우 창이 넘어가지 않고, 알림창('주문하기'버튼)
		$("#order").on("click", function(event) {
			var result = $("#result").html().trim();
					if (result.length==0) {
						alert("옵션을 선택해주세요.");
						event.preventDefault();
					}
				});

		// 옵션 선택에 따라 테이블을 추가해주는 부분
		$("#options").on("change", function(event){
			if($(this).val() != '#'){
				var select = Number.parseInt($(this).val());
				if($("#"+select).attr("id") != select){
					<c:forEach var="foodinfo" items="${foodinfoList}">
						if(${foodinfo.foption} == select){
							var tegs = "<table id='${foodinfo.foption}'><tr><td colspan='2'>옵션 ${foodinfo.foption}: ${foodinfo.optionname}(+<fmt:formatNumber value='${foodinfo.optionprice}' pattern='###,###,### 원' />)";
						    tegs += "</td><td rowspan='3'><input type='button' value='옵션삭제' data-delete='${foodinfo.foption}'></td>";
							tegs += "</tr><tr><td>수량<input type='text' name='amount' value='1' data-amount='${foodinfo.foption}'> </td><td><img src='content/image/order/minus.PNG' data-down='${foodinfo.foption}'>&nbsp;";
							tegs += "<img src='content/image/order/plus.PNG' data-up='${foodinfo.foption}'></td></tr><tr><td><span style='font-size: 14px; color: gray;'><fmt:formatNumber value='${foodinfo.fprice + foodinfo.optionprice}' pattern='###,###,### 원' /> x <span data-reamountr='${foodinfo.foption}'>1</span>개</span></td><td>";
							tegs += "<span style='font-size: 20px; color: red; font-weight: bold;' data-reprice='${foodinfo.foption}'><fmt:formatNumber value='${foodinfo.fprice+foodinfo.optionprice}' pattern='###,###,###' /> 원</span>";
							tegs += "<input type='hidden' name='foption' value='${foodinfo.foption}' data-foption='${foodinfo.foption}'><input type='hidden' name='fcode' value='${foodinfo.fcode}' data-fcode='${foodinfo.foption}'>";
							tegs +=	"<input type='hidden' value='${foodinfo.fprice+foodinfo.optionprice}' id='opprice' data-price='${foodinfo.foption}'></td></tr></table>";
							// var tegs = $("#result").html(); 후에 기존의 태그 위에 +=을 이용해서 넣으면 
							// $("#result").html(tegs); // 태그는 정상적으로 복사해오나, input 태그 안의 값은 가져오지 못해서 초기화 된다.
							// 따라서 append를 이용해 기존의 태그에다가 새로운 태그를 추가하는 방법을 사용한다.
							$("#result").append(tegs);
							priceTotal();
						}
					</c:forEach>
				} else{
					alert("이미 선택하신 옵션입니다.");
				}
			}
		})
		
		// 옵션 선택에 따라 테이블을 추가해주는 부분
		
		$("body").on("click", "[data-up]" , function(event){
			var amount = $("[data-amount="+$(this).attr("data-up")+"]").val();
			$("[data-amount="+$(this).attr("data-up")+"]").val(++amount);
			check($("[data-amount="+$(this).attr("data-up")+"]"));
		})
		
		$("body").on("click", "[data-down]" , function(event){
			var amount = Number.parseInt($("[data-amount="+$(this).attr("data-down")+"]").val());
			if (amount - 1 != 0){
				$("[data-amount="+$(this).attr("data-down")+"]").val(--amount);
				check($("[data-amount="+$(this).attr("data-down")+"]"));
			}
		})
		
		$("body").on("change", "[data-amount]" , function(event){
			check(this);
		})
		
		function check(select){
			$.ajax({
				type : "POST",
				url : "checkStock",
				dataType : "text",
				data : {
					fcode : $("[data-fcode='"+$(select).attr("data-amount")+"']").val(),
					foption : $("[data-foption='"+$(select).attr("data-amount")+"']").val()
				},
				success : function(Data, status, xhr) {
					if(Data.trim() == "잘못된 접근입니다."){
						alert(Data.trim());
					}else{
						var stock = Number.parseInt(Data.trim());
						if (Number.parseInt($("[data-amount='"+$(select).attr("data-amount")+"']").val()) > stock){
							$("[data-amount='"+$(select).attr("data-amount")+"']").val(stock);
							alert("재고량 이상을 주문할 수 없습니다. 재고 : " + stock);
						} else{
							var amount = Number.parseInt($("[data-amount='"+$(select).attr("data-amount")+"']").val());
							$("[data-reamountr='"+$(select).attr("data-amount")+"']").text(amount);
							var totalPrice = Number.parseInt($("[data-price='"+$(select).attr("data-amount")+"']").val()) * amount;
							$("[data-reprice='"+$(select).attr("data-amount")+"']").text(totalPrice.toLocaleString() + " 원");
							priceTotal();
							// totalPrice.toLocaleString() -> 숫자에 3자리마다 ',' 를 넣어주는 함수이다.
						}
					}
				},
				error : function(xhr, status, error) {
					console.log("error");
				}
			})
		}
		
		$("body").on("click","[data-delete]", function(event){
			// 옵션 삭제
			$("#"+$(this).attr("data-delete")).remove();
			priceTotal();
			
		})
		function priceTotal(){
			var totalPrice = 0;
			var text = "";
			var amounts = new Array();
			var price = new Array();
			$("[data-amount]").each(function(idx, ele){
				
				amounts[Number.parseInt(idx)] = Number.parseInt($(ele).val());
			})
			$("[data-price]").each(function(idx, ele){
				
				price[Number.parseInt(idx)] = Number.parseInt($(ele).val());
			})
			for(var i = 0 ; i < amounts.length ; i ++){
				totalPrice += (amounts[i] * price[i]);
			}
			$("#priceTotal").text(totalPrice.toLocaleString()+ "원");
			
	
		}
		$("[type='submit']").on("click", function(){
			if($(this).attr("id") == "order"){
				$("form").attr("action", "orderConfirm");
				
			} else if($(this).attr("id") == "cart"){
				$("form").attr("action", "cartAdd");
			}
		})
	})
	
</script>
<body>
				
	<div>
		<div align="center">
			<form action="#" method="get">
				<table border="1">
					<tr>
						<td rowspan="7"><img src="content/image/food/${foodinfoList[0].fmainimage}.jpg" class="goods" /></td>
						<th>제품명</th>
						<td><b>[${foodinfoList[0].categoryname}]</b> ${foodinfoList[0].ftitle}</td>
					<tr>
					<tr>
						<th>가격</th>
						<td><fmt:formatNumber value="${foodinfoList[0].fprice}" pattern="###,###,### 원" /></td>
					</tr>
					<tr>
						<th>옵션</th>
						<td>
							<select id="options">
								<option value="#">옵션을 선택하세요.</option>
								<c:forEach var="foodinfo" items="${foodinfoList}">
									<option value="${foodinfo.foption}">[옵션 ${foodinfo.foption} : ${foodinfo.optionname} 
									(<fmt:formatNumber value="${foodinfo.optionprice}" pattern="###,###,### 원" />)] /
									재고 : ${foodinfo.stock} 개</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>정보</th>
						<td>
							<!-- 여기에 옵션 목록 추가 -->
							<div id="result">
							</div>
							<!-- 여기까지  -->
						</td>
					</tr>
					<tr>
						<th>Total</th>
						<td align="right"><b><span id="priceTotal" style="color: blue; font-size: 20px"></span></b></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" id="order" value="주문하기"> <input type="submit" id="cart" value="장바구니 추가">
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<img src="content/image/food/${foodinfoList[0].fimage}.jpg" class="goods" />
						</td>
				</table>
			</form>
		</div>
	</div>
</body>
