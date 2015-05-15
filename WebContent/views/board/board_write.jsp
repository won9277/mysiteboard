<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet"
	type="text/css">
<title>Insert title here</title>
<style type="text/css">
h1 {
	margin: 20px;
}

span {
	margin: 10px;
}

#respond {
	margin-bottom: 10px;
	margin-top: 10px;
	margin: 0 auto;
	width: 940px;
}

#button {
	background-color: white;
	font-family: 'Nanum Gothic';
	float: right;
	padding: 10px;
}

#contents {
	
}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/views/include/header.jsp" flush="false" />
		</div>
		<!-- 등록순으로 보여지는 첫번째 탭 -->
		<!-- Table -->
		<div id="content">
			<form action="/mysite/board" method="post">
				<input type="hidden" name="a" value="insertBoard">
				<table>
					<tr>
						<td colspan="2">제목</td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td colspan="2">내용</td>
						<td><input type="text" name="contents"></td>
					</tr>
				</table>
				<input type="submit" value="등록">
			</form>
		</div>	
			<div id="navigation">
				<c:import url="/views/include/navigation.jsp">
					<c:param name="type" value="main"></c:param>
				</c:import>
			</div>
			<div id="footer">
				<c:import url="/views/include/footer.jsp"></c:import>
			</div>
		</div>
	
</body>
</html>