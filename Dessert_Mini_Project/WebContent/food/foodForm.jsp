<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<body>
	<div>
		<div align="center">
			<form>
				<table border="1">
					<tr>
						<td rowspan="6"><img src="content/image/food/A08_0.jpg" class="goods" /></td>
						<td>제품명</td>
						<td></td>
					<tr>
					<tr>
						<td>가격</td>
						<td>9000</td>
					</tr>
					<tr>
						<td>옵션</td>
						<td>
							<select id="options">
								<option></option>
							</select>
						</td>
					</tr>
					<tr>
						<td>정보</td>
						<td>
							<div id="result">
								<table>
									<tr>
										<td>구매수량</td>
										<td><input type="text" name="amount"> +  - </td>
									</tr>
									<tr>
										<td>가격  : </td>
										<td></td>
										
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
