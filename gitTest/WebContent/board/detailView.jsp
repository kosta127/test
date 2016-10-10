<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<title>글보기 :: ${board.b_title }</title>
<style type="text/css">
	.center{
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container">
		<h1># 글보기</h1>
		<table class="table">
		 	<tr>
		 		<th width="20%">작성자</th>
		 		<td>${board.b_name }</td>
		 	</tr>
		 	<tr>
		 		<th>작성일</th>
		 		<td>${board.b_regdate }</td>
		 	</tr>
		 	<tr>
		 		<th>제목</th>
		 		<td>${board.b_title }</td>
		 	</tr>
		 	<tr>
		 		<td colspan="2">${board.b_contents }</td>
		 	</tr>
		 	<tr>
		 		<td colspan="2">
		 			<div class="pull-right">
			 			<a href="boardList.do" class="btn btn-primary">목록보기</a>
			 			<a href="passwordForm.do?flag=md&b_id=${board.b_id }" class="btn btn-warning">수정</a>
			 			<a href="passwordForm.do?flag=del&b_id=${board.b_id }" class="btn btn-danger">삭제</a>
		 			</div>
		 		</td>
		 	</tr>
		 	<tr>
		 		<td colspan="2">		 			
			 			<table class="table">
			 				<c:forEach var="r" items="${replyList }">
				 				<tr>
				 					<td width="20%">${r.r_name }</td>
				 					<td>${r.r_contents }</td>
				 					<td width="10%"><fmt:formatDate value="${r.r_regdate }" pattern="yyyy-MM-dd"/> 
				 					<td width="5%"><a href="#">x</a></td>
				 				</tr>
			 				</c:forEach>
			 				<tr>			 					
			 					<td colspan="4">
			 						<form action="ReplyInsertProc.do" method="post" class="form-inline">
			 							<input type="hidden" name="b_id" value="${board.b_id }">
					 					<input type="text" name="r_name" class="form-control" placeholder="이름">
					 					<input type="text" name="r_contents" class="form-control" placeholder="내용">
					 					<input type="password" name="r_password" class="form-control" placeholder="비밀번호">
					 					<input type="submit" class="form-control" value="등록">
				 					</form>
			 					</td>			 					
			 				</tr>
			 			</table>		 			
		 		</td>
		 	</tr>
		 </table>
	</div>
</body>
</html>