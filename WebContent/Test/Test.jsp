<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
<div class="section-list"><!-- 글 목록 -->
	<table class="core">
		<colgroup>
			<col style="width: 40px;" />
			<col style="width: 80px;" />
			<col style="width: auto;" />
			<col style="width: 120px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
		</colgroup>
		<thead>
			<tr>
				<th>선택</th>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td>10</td>
				<td class="subject">
					<a href="#">글 제목이 삽입됩니다.</a>
				</td>
				<td>홍길동</td>
				<td>2012-11-11</td>
				<td>100</td>
			</tr>
		</tbody>
	</table>
</div><!-- // 글 목록 -->

<div class="pagination"><!-- pagination -->
	<ul class="core">
    	<li class="first"><a class="disable" href="#">«</a></li>
        <li class="prev"><a class="disable" href="#">‹</a></li>
    	<li><a class="current" href="">1</a></li>
        <li><a href="">2</a></li>
        <li><a href="">3</a></li>
        <li><a href="">4</a></li>
        <li><a href="">5</a></li>
        <li class="next"><a href="">›</a></li>
        <li class="last"><a href="">»</a></li>
	</ul>
</div><!-- // pagination -->

<div class="section-button"><!-- section button -->
	<button class="button-b fleft">전체 선택/취소</button>
	<button class="button-b">삭제</button>
	<button class="button-a">쓰기</button>
</div><!-- // section button -->
  </body>
</html>