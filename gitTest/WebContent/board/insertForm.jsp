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
	<title>글쓰기</title>
</head>
<body>
	<div class="container">
		<h1># 새글쓰기</h1>
		<form action="boardInsertProc.do" method="post">
			 <table class="table">
			 	<tr>
			 		<td>
			 			<label for="b_name">작성자</label>
 			 			<input type="text" class="form-control" name="b_name" id="b_name">
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>
			 			<label for="b_password">비밀번호</label>
 			 			<input type="password" class="form-control" name="b_password" id="b_password">
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>
			 			<label for="b_title">제목</label>
 			 			<input type="text" class="form-control" name="b_title" id="b_title">
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>
			 			<label for="b_contents">내용</label>
 			 			<textarea class="form-control" name="b_contents" id="b_contents"></textarea>
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>
			 			<input type="submit" class="btn btn-primary" value="등록">
			 			<a href="boardList.do" class="btn btn-warning">취소</a>
			 		</td>
			 	</tr>
			 </table>
		</form>
	</div>
</body>
</html>