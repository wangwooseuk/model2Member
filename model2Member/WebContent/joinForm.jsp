<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
	#joinformArea {
		margin: auto;
		width: 400px;
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
	<section id="joinformArea">
		<form action="./memberJoinPro.do" method="post" name="joinform">
			<table>
				<tr>
					<td colspan="2">
						<h1>회원가입 페이지</h1>
					</td>
				</tr>
				<tr>
					<td><label for="id">아이디 : </label></td>
					<td><input type="text" name="id" id="id" /></td>
				</tr>
				<tr>
					<td><label for="pw">비밀번호 : </label></td>
					<td><input type="password" name="pw" id="pw" /></td>
				</tr>
				<tr>
					<td><label for="name">이름 : </label></td>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<td><label for="age">나이 : </label></td>
					<td><input type="text" name="age" id="age" maxlength="2" /></td>
				</tr>
				<tr>
					<td><label for="gender">성별 : </label></td>
					<td>
						<input type="radio" name="gender" value="남" checked="checked" id="gender"/>
						남자
						<input type="radio" name="gender" value="여"/>
						여자
					</td>
				</tr>
				<tr>
					<td><label for="email">이메일 주소 : </label></td>
					<td><input type="email" name="email" id="email" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
						<a href="javascript:joinform.reset()">다시작성</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>