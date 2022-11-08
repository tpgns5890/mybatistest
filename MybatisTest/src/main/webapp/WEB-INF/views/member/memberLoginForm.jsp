<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>로 그 인</h1>
		</div>
		<div>
			<form action="memberlogin.do" id="frm" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">아이디</th>
							<td width="150">
								<input type="text" id="id" name="id"><!-- id속성은 jsp에 name속성은 java의 request에 담긴다 -->
							</td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td>
								<input type="password" id="passwd" name="passwd"><!-- name속성은 가급적 vo객체명과 일치 시킨다 -->
							</td>
						</tr>

					</table>
				</div><br/>
				<div>
					<input type="submit" value="로그인">&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;
					<input type="button" value="홈 가기" onclick="">
				</div>
			</form>
		</div>
	</div>

</body>
</html>