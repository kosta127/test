<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js" ></script>
	<script src="../js/jquery.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글 보기</title>
	<style>
		.center{
			text-align: center;
		}
	</style>
</head>
<body>
	<div class="container">
		<h2># 게시글 보기</h2>
		<form action="" method="post" class="form-inline pull-right">
			<select name="cond" class="form-control">
				<option value="b_name">작성자</option>
				<option value="b_title">제목</option>
				<option value="b_contents">내용</option>
			</select>
			<input type="text" class="form-control" name="serchKey">
			<input type="submit" class="btn btn-info" value="검색">
		</form>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach var="b" items="${boardList}">
					<tr>
						<td>${ b.b_id }</td>
						<td>
							<a href="boardDetailView.do?b_id=${ b.b_id }">${b.b_title }
								<c:if test="${b.replyCount > 0}">
									<span class="badge">${b.replyCount }</span>
								</c:if>
							</a>						
						</td>
						<td>${b.b_name }</td>
						<td><fmt:formatDate value="${b.b_regdate }" pattern="yyyy-MM-dd"/></td>
						<td>${b.b_hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="center">
			<c:if test="${paging.needBefore }">
					<span class="label"><a href="boardList.do?pageNum=${paging.startPage-1}">이전</a></span>
			</c:if>
			<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
				<c:choose>
					<c:when test="${i==paging.currentPage }">
						<span class="label label-info">${i }</span>
					</c:when>
					<c:otherwise>
						<span class="label"><a href="boardList.do?pageNum=${i }">${i }</a></span>
					</c:otherwise>
				</c:choose>						
			</c:forEach>
			<c:if test="${paging.needAfter }">
					<span class="label"><a href="boardList.do?pageNum=${paging.endPage+1 }">다음</a></span>
			</c:if>
		</div>
		<br>
		<div class="pull-right">
			<a href="boardInsertForm.do" class="btn btn-primary">글쓰기</a>
		</div>
	</div>
</body>
</html>