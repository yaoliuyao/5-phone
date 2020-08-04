<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改</title>
</head>
<body>
	<form action="${r}/edit" method="post">
		<input value="${phone.id}" name="id" readOnly>
		<input value="${phone.name}" name="name">
		<input value="${phone.price}" name="price" type="number">
		<button>提交修改</button>
	</form>
</body>
</html>
