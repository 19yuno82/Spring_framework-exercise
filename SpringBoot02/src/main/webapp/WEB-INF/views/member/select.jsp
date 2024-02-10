<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- context path를 "cpath"라는 이름으로 저장해두기 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<% pageContext.setAttribute("cpath", request.getContextPath()); %>

<!-- 1.request영역에 저장된 정보를 가져오시오. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="${cpath}/assets/css/main.css" />
		
	</head>
	<style>
	
	</style>
	<body style="text-align: center;">
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>Tel</td>
								<td>Address</td>							
							</tr>
							<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
						</table>
					</nav>		
					<a href="main.jsp" class="button next scrolly">되돌아가기</a>	
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

