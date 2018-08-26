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
    #in {
	  position:absolute;
	  top:50%;
	  left:50%;
	  width:100px;
	  height:100px;
	  background:#f00;
	  margin:-50px 0 0 -50px;
	 }
    
    </style>
  </head>
  <body>
	<jsp:include page="/BasicCSS/InSiteForm.jsp"/>
	 
	<!-- 내용 시작 -->
		<div class="container" >
			<div class = "page-header">
	   			<h1>자료실  <small>목록</small></h1>
			</div>
			<div class="row" style="margin-bottom: 10px">
				<div class="col-md-11 text-right">
					<a href="<c:url value='/Control/Write.do'/>" class="btn btn-success">등록</a>
				</div>
			</div>	
			<div class="row">
				<!-- 테이블 전체 가로폭은  테이블을 감싸는 div의 col-*-*로 조정-->
				<div class="col-md-11">
			    	<table class="table table-hover table-bordered text-center">
			    	
			    		<tr >
			    			<!-- 각 컬럼의 폭은 <td>계열에 class="col-*-*"추가 -->
			    			<th class="col-md-1 text-center">번호</th>
			    			<th class="text-center">제목</th>
			    			<th class="col-md-1 text-center">작성자</th>
			    			<th class="col-md-1 text-center">조회수</th>
			    			<th class="col-md-2 text-center">등록일</th>
			    		</tr>
			    		<c:forEach items="${list}" var="record" varStatus="loop">
			    		<tr>
			    			<td>${record.no}</td>
			    			<td class="text-left"><a href='<c:url value="/Control/ViewMove.do?no=${record.no}&nowPage=${nowPage}"/>'>${record.title}</a></td>
			    			<td>${record.id}</td>
			    			<td>${record.downcount}</td>
			    			<td>${record.postdate}</td>
			    		</tr>
			    		</c:forEach>
			    	</table>
		    	</div>	
			</div>
			<!-- 페이징 처리 부분 -->
			${pagingString}
			<!-- 페이징 처리 부분 -->
			
		</div>
    
    <!-- 내용 끝 -->
  </body>
</html>