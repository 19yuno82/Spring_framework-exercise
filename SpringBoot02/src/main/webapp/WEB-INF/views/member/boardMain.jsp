<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- context path를 "cpath"라는 이름으로 저장해두기 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<% pageContext.setAttribute("cpath", request.getContextPath()); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forty by HTML5 UP</title>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if lte IE 8]><script src="${cpath}/assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="${cpath}/assets/css/main.css" />
<link rel="stylesheet" href="${cpath}/assets/css/board.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="${cpath}/assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="${cpath}/assets/css/ie8.css" /><![endif]-->

</head>
<body>
	<div id="board">
	<h1>게시판 메인 페이지</h1>
		<table id="list">
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>시간</td>
				</tr>
			</thead>
			<tbody>
				<%--Ex10.게시글 목록을 출력해봅시다. --%>
				<%--예시) --%>
				<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.idx}</td>
					<td><a href="${cpath}/member/detail?idx=${board.idx}">${board.title}</a></td>
					<td>${board.writer.email}</td>
					<td>${board.indate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${cpath}/guest/main"><button>메인으로</button></a>
		<a href="${cpath}/member/write"><button id="writer">작성하러가기</button></a>
	</div>


	<!-- Scripts -->
	<script src="${cpath}/assets/js/jquery.min.js"></script>
	<script src="${cpath}/assets/js/jquery.scrolly.min.js"></script>
	<script src="${cpath}/assets/js/jquery.scrollex.min.js"></script>
	<script src="${cpath}/assets/js/skel.min.js"></script>
	<script src="${cpath}/assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="${cpath}/assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="${cpath}/assets/js/main.js"></script>
</body>
</html>