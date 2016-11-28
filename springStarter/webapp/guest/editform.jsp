<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 페이지</h1>
	<form action="update.do" method="post">
		<p>
			<label for="sabun">사번</label>
			<input type="text" name="sabun" id="sabun" value="${dto.sabun }"/>
		</p>
		<p>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" value="${dto.name }"/>
		</p>
		<p>
			<label for="pay">금액</label>
			<input type="text" name="pay" id="pay" value="${dto.pay }"/>
		</p>
		<p>
			<button type="submit">수정</button>
			<button type="reset">취소</button>
		</p>
	</form>
</body>
</html>