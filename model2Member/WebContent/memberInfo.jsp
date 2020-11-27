<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#memberInfoArea {
		width: 400px;
		margin: auto;
		border: 1px solid gray;
	}
	
	table {
		width: 380px;
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
	<section id="memberInfoArea">
		<table>
			<tr>
				<td>아이디 : </td>
				<td>${member.id }</td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td>${member.pw }</td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td>${member.name }</td>
			</tr>
			<tr>
				<td>나이 : </td>
				<td>${member.age }</td>
			</tr>
			<tr>
				<td>성별 : </td>
				<td>${member.gender }</td>
			</tr>
			<tr>
				<td>이메일 주소 : </td>
				<td>${member.email }</td>
			</tr>
			<tr>
				<td>
					<a href="memberList.do">리스트로 돌아가기</a>
				</td>
			</tr>
		</table>
	</section>
</body>
</html>