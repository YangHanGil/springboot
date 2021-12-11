<%@page import="com.backpacker.springBoot.Common.PageVo"%>
<%@page import="com.backpacker.springBoot.user.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
List<UserVo> list = (List<UserVo>)request.getAttribute("list");
int cnt = (Integer)request.getAttribute("cnt");
PageVo pageVo = (PageVo)request.getAttribute("pageVo");
String board_selec = (String)request.getAttribute("board_selec");
if(board_selec == null) board_selec = "";
String boardSearch = (String)request.getAttribute("boardSearch");
if(boardSearch == null) boardSearch = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원주문목록</title>
</head>
<body>

	<script src="http://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="http://localhost:8080/js/common.js"></script>
	<script type="text/javascript">
	function selectUser(idx, range){
		var board_selec = $("#board_selec").val();
		var boardSearch = $("#boardSearch").val();

		location.href = "/userList?nowPage="+idx+"&range="+range+"&board_selec="+board_selec+"&boardSearch="+boardSearch;
	}

	function pageMove(){
		var board_selec = $("#board_selec").val();
		var boardSearch = $("#boardSearch").val();
		
		location.href = "/userList?board_selec="+board_selec+"&boardSearch="+boardSearch;	
	}
	
	</script>
	
	
	<div class="wrap">
			<div class="board-wrap">
				<dl class="community">
					<dt>
						공지사항
						<!--게시판검색-->
						<div class="board_search">
							<div class="select floatl">
								<label for="board_selec">검색분류</label>
								<select id="board_selec">
									<option value="F_NAME" <%if(board_selec.equals("F_NAME")){ %> selected="selected" <%} %>>이름</option>
									<option value="F_EMAIL" <%if(board_selec.equals("F_EMAIL")){ %> selected="selected" <%} %>>이메일</option>
								</select>
							</div>
							<div class="floatl mgl05"><input type="search" id="boardSearch" value="<%=boardSearch%>"/> <input type="button" value="검색" onclick="javascript:pageMove()"/></div>
						</div>
						<!--//게시판검색-->
					</dt>
					<dd class="board_list">
						<!-- 공지사항리스트 -->
						<table summary="리스트" >
							<caption>리스트</caption>
							<colgroup>
								<col style="width:%20">
								<col style="width:%20">
								<col style="width:%20">
								<col style="width:%20">
								<col style="width:%20">
							</colgroup>
							<thead>
								<tr>
									<th>이메일</th>
									<th>이름</th>
									<th>닉네임</th>
									<th>전화번호</th>
									<th>마지막주문정보</th>
								</tr>
							</thead>
							<tbody id="contents_list">
								<%
								for(int i=0; i<list.size(); i++){
								%>
								<tr>
									<td>
										<a href="/userInfo?F_EMAIL=<%=list.get(i).getF_EMAIL()%>"><%=list.get(i).getF_EMAIL() %></a>
									</td>
									<td>
										<a href="/userInfo?F_EMAIL=<%=list.get(i).getF_EMAIL()%>"><%=list.get(i).getF_NAME() %></a>
									</td>
									<td>
										<a href="/userInfo?F_EMAIL=<%=list.get(i).getF_EMAIL()%>"><%=list.get(i).getF_NICKNAME() %></a>
									</td>
									<td>
										<a href="/userInfo?F_EMAIL=<%=list.get(i).getF_EMAIL()%>"><%=list.get(i).getF_HP() %></a>
									</td>
									<td>
										<a href="/userInfo?F_EMAIL=<%=list.get(i).getF_EMAIL()%>"><%=list.get(i).getF_PRODUCT()%></a>
									</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
						<!-- //공지사항리스트 -->
					</dd>
					
					<dd>
						<!-- 페이징 -->
						<div class="paginate_simple">
							<c:if test="${pageVo.prev}">
							<a class="direction" href="#" onClick="fn_prev(${pageVo.startPage}, ${pageVo.range}, ${pageVo.rangeSize}, '/userList')"> ‹ <span>Prev</span></a>
							</c:if>
							<c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}" var="idx">
								<c:if test="${idx eq page}">
							<strong>${idx}</strong>	
								</c:if>
								<c:if test="${idx ne page}">
							<a class="page-link" href="javascript:selectUser(${idx}, ${pageVo.range})"> ${idx} </a>
								</c:if>
							</c:forEach>
							<c:if test="${pageVo.next}">
							<a class="direction" href="#" onClick="fn_next(${pageVo.endPage}, ${pageVo.range}, '${pageVo.rangeSize}', '/userList')" ><span>Next</span> › </a>
							</c:if>		
						</div>
					</dd>
				</dl>
			</div>
		</div>

</body>
</html>