<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력 페이지</h1>
	<form action="insert.do">
	<table>
		<tr>
			<td>사번</td>
			<td>
				<input type="text" name="sabun" id="sabun">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" id="name">
			</td>
		</tr>
		<tr>
			<td>금액</td>
			<td>
				<input type="text" name="pay" id="pay">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit"'>입력</button>
				<button type="reset"'>취소</button>
			</td>
		</tr>
	</table>
	
	</form>
</body>
</html>