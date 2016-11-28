<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세페이지</h1>
	<table>
		<tr>
			<td>사번</td>
			<td>${dto.sabun }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<td>날짜</td>
			<td>${dto.nalja }</td>
		</tr>
		<tr>
			<td>금액</td>
			<td>${dto.pay }</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="edit.do?idx=${dto.sabun }">수정</a>
				<a href="del.do?idx=${dto.sabun }">삭제</a>
			</td>
		</tr>
		
	</table>
</body>
</html>