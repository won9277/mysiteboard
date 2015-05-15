<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet" type="text/css">
<title>Board List</title>
<style type="text/css">
#content{
background-image: url("assets/images/rilak2.JPG");
height: 600px;

}
.BoardTable {
	width: 100%;
	border: 1px solid;
	
}

.BoardTable tr th {
	height: "20";
	align: "center";
	font-weight: bold;
	width: 50px;
	color: green;
	text-align: center;
}
.BoardTable tr td {
	font-weight: normal;
}
#title{
width: 500px;
}
#writer, #date{
width: 100px;
}
#writeBtn{
float: right;
}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/views/include/header.jsp" flush="false" />
		</div>
		<!-- Table -->
		<div id="content">
		<form action="/mysite/board" method="post">
		<input type="hidden" name="a" value="insertBoardPage"> 
		<div id="writeBtn">
			<input type="submit" value="글쓰기" >
			</div>
			<table class="BoardTable">
					<th></th>
					<th id= "writer">글쓴이</th>
					<th id="title">제목</th>
					<th>댓글</th>
					<th id="date">날짜</th>
				</tr>
				<c:forEach var="g" items="${list }">
				<tr>
					<td>${g.no }</td>
					<td>${g.member_name } </td>
					<td><a href="/mysite/board?a=getboard&no=${g.no }">${g.title } </a></td>
					<td>${g.view_cnt }</td>
					<td>${g.reg_date }</td>
				</tr>
				</c:forEach>
				<%-- <tr height="40" align="center">
					<td>${b.no }</td>
					<td>${b.name }</td>
					<td><a href="">${b.title }</a></td>
					<td>${b.comments_no}</td>
					<td>${b.date.substring(0,10)}</td>
				</tr> --%>
			</table>
			</form>
			<%-- <div align="center">
					
						<FONT size=2>${pageLink}</FONT><br/>
						<form action="" id="frm1" method="post">
							<input type="hidden" id="pageNo" name="pageNo" />
						</form> 
					</div>  --%>

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