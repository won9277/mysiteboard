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
#content {
	background-image: url("assets/images/rilak2.JPG");
	height: 600px;
	font-size: 15px;
}

#detailTable{
padding: 0;
margin-top: 30px;
border: solid;
width: 500px;
height: 500px;
margin: 0 auto;
}
#button {
	font-family: 'Nanum Gothic';
	float: right;
	margin-right: 30px;
	padding: 20px;
}

#contents {
height: : 400px;
}

#list {
text-align: center;
}
#title{
height: 20px;
font-size: 20px;
}
#top{
height: 20px;
text-align: left;
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
			<div id="button">
				<a href="/mysite/board?a=bmodifypage&no=${vo.no }">수정 |</a> <a
					href="/mysite/board?a=bdelete&no=${vo.no }"> 삭제</a>
			</div>
			<table id="detailTable">
				<tr>
					<th colspan="2" id="title">${vo.title }</th>
				<tr>
					<!-- 글 상세 페이지 -->
					<div id="top">
						<tr>
							<td>${vo.member_name } </td>
							<td>${vo.reg_date }</td>
						</tr>
					</div>
						<tr>
					<td colspan="2">${vo.content }</td></tr>
					
			</table>
			<div id="list">
				<a href="/mysite/board?a=board_list">리스트로 돌아가기</a>
			</div>
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