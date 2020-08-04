<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	
<html>
<head>
	<meta charset="utf-8">
	<style>
		table, tr, td, th {
			border: 1px solid black;
			padding: 5px 1em;
			border-collapse: collapse;
			text-align: center;
		}
		table {
			width: 98%;
		}
		.edit input {
			display: block;
			margin-bottom: 10px;
		}
		.a-form {
			padding-bottom: 1em;
			width: 98%;
			display: flex;
			justify-content: space-between;
		}
		header {
			display: grid;
			grid-template-columns: 1fr auto;
		}
		header span {
			padding: 1em 2em;
		}
	</style>
</head>

<body>
	<header>
		<h3>手机系统</h3>
	</header>
	
	<div>
		<form class="a-form" action='${r}/add' method='post'>
			<input type='text' name='name' placeholder='手机名'>
			<input type='number' name='price' placeholder='价格'>
			<button>添加手机</button>
		</form>
	</div>
	
	<div style="margin-top: 2em">
		<form action="${r}/list">
			<input name="tiaojian" placeholder="请输入条件">
			<button>搜索</button>
		</form>
	</div>
	
	<table>
		<tr>
			<th>编号</th>
			<th>手机名</th>
			<th>价格</th>
			<th>操作</th>
		</tr>
		
		<c:forEach var="phone" items="${xxx}">
		<tr>
			<td>${phone.id}</td>
			<td>${phone.name}</td>
			<td>${phone.price}</td>
			<td>
				<a href='${r}/del?id=${phone.id}'>删除</a>
				<a href='${r}/edit?id=${phone.id}'>修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>



