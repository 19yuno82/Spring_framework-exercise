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
	<%--Ex11. 게시글 상세보기 기능 만들기 : 하나의 게시글의 내용을 출력하는 기능을 만들어 봅시다. --%>
	<div id="board">
		<table id="list">
			<tr>
				<td>제목</td>
				<td>
					<%--게시글 제목 출력 --%>
					${board.title}
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<%--작성자 출력 --%>
					${board.writer.email}
				</td>
			</tr>
			<tr>
				<td colspan="2">내용</td>
			</tr>
			<tr>
				<td colspan="2">
					<%--게시글 내용 출력 --%>
					${board.content}
				</td>
			</tr>
			<tr>
				<td colsapn="2">
				<img alt="" src="${cpath}/save/${board.img}">
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<%-- 클릭시 boardMain으로 돌아갈 수 있게 수정해봅시다. --%>
					<a href="${cpath}/member/List"><button>뒤로가기</button></a>
				</td>
			</tr>
		</table>
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