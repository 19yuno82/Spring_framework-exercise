<%@page import="com.smhrd.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.bDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assetsBoard/css/main.css" />
		<link rel="stylesheet" href="assetsBoard/css/board.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
</head>
<body>		
			<!-- Q17. 게시글 목록 조회 기능 -->
			
			<!-- Q18. 게시글 목록 세부페이지 기능(제목을 클릭하면 세부페이지 BoardDetail.jsp로 이동)-->
			<div id="board">
				<table id = "list">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>시간</td>
					<%-- </tr>
					<%
					int num = 1;
					for(Board i : bList) {
					%>
					<tr>
						<td><%=num%></td>
						<td><%=i.getTitle() %></td>
						<td><%=i.getWriter() %></td>
						<td><%=i.getB_date() %></td>
						<td><a href="DeleteBoard?num=<%=i.getNum()%>">삭제</a></td>
					</tr>
					<% num++; } %> --%>
														<!-- 상태변수 -->
					<c:forEach var="b" items="${bList}" varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td><a href="BoardDetailPage.do?num=${b.num}">${b.title}</a></td>
						<td>${b.writer}</td>
						<td>${b.b_date}</td>
						<td><a href="DeleteBoard.do?num=${b.num}">삭제</a></td>
					</tr>
					</c:forEach>
				
				</table>
				
				<a href="Main.jsp"><button id="writer">홈으로가기</button></a>
				<a href="BoardWritePageService.do"><button id="writer">작성하러가기</button></a>
			</div>


			<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
</body>
</html>