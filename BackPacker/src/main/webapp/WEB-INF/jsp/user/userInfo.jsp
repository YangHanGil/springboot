<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.backpacker.springBoot.user.UserVo"%>
<%@page import="com.backpacker.springBoot.product.ProductVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<ProductVo> list = (List<ProductVo>)request.getAttribute("userOrder");
UserVo userVo = (UserVo)request.getAttribute("userVo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
</head>
<body>

<div> 이메일 : <%=userVo.getF_EMAIL() %></div>
<div> 이름 : <%=userVo.getF_NAME() %></div>
<div> 별명 : <%=userVo.getF_NICKNAME() %></div>
<div> 전화번호 : <%=userVo.getF_HP() %></div>
<div> 성별 : <%=userVo.getF_GENDER() %></div>

<table summary="주문내역 리스트" >
	<caption>주문내역 리스트</caption>
	<colgroup>
		<col style="width:7%">
		<col style="width:70%">
		<col style="width:23%">
	</colgroup>
	<thead>
		<tr>
			<th>주문번호</th>
			<th>제품명</th>
			<th>구매일시</th>
		</tr>
	</thead>
	<tbody>
		<%
		if(list != null){
			for (ProductVo productVo : list) {
				
		%>
		<tr>
			<td>
				<%=productVo.getF_NUM()%>
			</td>
			<td>
				<%=productVo.getF_NAME()%>
			</td>
			<td>
				<%=productVo.getF_PAY_DATE() %>
			</td>
		</tr>
		<%
			}
		} else {
		%>
		<tr>
			<td colspan="3">
				주문내역이 없습니다.
			</td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>
<div>
	<a href="/userList">유저목록이동</a>
</div>

</body>
</html>