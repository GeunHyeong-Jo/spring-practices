<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/add" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="contents" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>
	<br>
	<form action="${pageContext.request.contextPath }/deleteform"
		method="post">
		<table width=510 border=1>
			<c:forEach items="${list }" var='vo' varStatus="status">
				<tr>
					<td><input type='hidden' name="no" value="${vo.no }">
						${status.count }</td>
					<td>${vo.name }</td>
					<td>${vo.reg_date }</td>
					<td><input type="submit" value="삭제"></td>
				</tr>
				<tr>
					<td colspan=4>${vo.contents}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>