<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>부트스트랩  템플릿</title>
	
    <!-- 부트스트랩 -->
    <link href="<c:url value='/Bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="<c:url value='/Bootstrap/js/bootstrap.min.js'/>"></script>
    
    <link href="<c:url value="/BasicCSS/AllCSS.jsp"/>" rel="stylesheet"/>
    <style type="text/css">
    .container{
    margin-top: 70px;
    
    }
    </style>
  </head>
  <body>
	<jsp:include page="/BasicCSS/InSiteForm.jsp"/>
	 
	
			<div class="container" >
			<div class = "page-header">
	   			<h1>게시판  <small>상세보기 페이지</small></h1>
			</div>
				
			<div class="row">
				<!-- 테이블 전체 가로폭은  테이블을 감싸는 div의 col-*-*로 조정-->
				<div class="col-md-11">
			    	<table class="table table-hover table-striped table-bordered ">
			    		<tr>
			    			<th class="col-md-2 text-center">번호</th>
			    			<td>${list.no }</td>
			    		</tr>
			    		<tr>
			    			<th class="col-md-2 text-center">제목</th>
			    			<td>${list.title }</td>
			    		</tr>
			    		<tr>
			    			<th class="col-md-2 text-center">작성자</th>
			    			<td>${list.id }</td>
			    		</tr>
			    		<tr>
			    			<th class="col-md-2 text-center">조회수</th>
			    			<td>${list.downcount }</td>
			    		</tr>
			    		<tr>
			    			<th class="col-md-2 text-center">등록일</th>
			    			<td>${list.postdate }</td>
			    		</tr>
			    		<tr>
			    			<th colspan="2" class="text-center">내용</th>			    			
			    		</tr>
			    		<tr>
			    			<td colspan="2">
			    				${list.content}
			    			</td>			    			
			    		</tr>
			    		
			    	</table>
		    	</div>	
			</div><!-- row -->
			<div class="row">
				<div class="col-md-11">	
					<!-- .center-block사용시 해당 블락의 크기를 지정하자  -->
			    	<ul id="tabMenu" class="nav nav-pills center-block" style="width:195px">
					  <li><a href="#" data-toggle="modal" data-target="#passwordModal">수정</a></li>
					  <!-- 삭제 취소시에는 모달창이 뜨지 않도록 자스로 제어하기 위해: data-toggle="modal" 삭제 -->
					  <li><a href="<c:url value='/Control/Delete.do?no=${list.no}'/>">삭제</a></li>
					  
					  <li><a href="<c:url value='/Control/NoticeBoard.do?nowPage=${nowPage}'/>">목록</a></li>
					</ul>
			    </div>	
			</div>
		</div>
	
	
    
  </body>
</html>