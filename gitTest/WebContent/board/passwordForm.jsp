<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>
<body>
	<div class="container">
		<div class="panel panel-info">
      	<div class="panel-heading">비밀번호 입력</div>
      	<div class="panel-body">
      		<form action="checkPassword.do" method="post">
      			<input type="hidden" name="b_id" value="${param.b_id }">
      			<input type="hidden" name="flag" value="${param.flag }">
      			<input type="password" class="form-control" name="b_password">
      			<input type="submit" class="btn btn-primary" value="확인">
      			<a href="boardDetailView.do?b_id=${param.b_id }" class="btn btn-success">돌아가기</a>
      		</form>
      	</div>
    	</div>
	</div>
</body>
</html>