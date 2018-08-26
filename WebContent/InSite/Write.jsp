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
    margin-bottom: 500px
    }
    </style>
  </head>
  <body>
	<jsp:include page="/BasicCSS/InSiteForm.jsp"/>
	 		<div class="container" >
			<div class = "page-header">
	   			<h1>자료실  <small>입력폼</small></h1>
			</div>
			<div class="row">
				<c:if test="${errorMessage!=null}"><span style="color: red;font-size: 1.3em;font: bold;">${errorMessage}</span></c:if>
				<div class="col-md-12">
					<form class="form-horizontal" method="post" action="<c:url value='/Control/WriteEnd.do'/>">
					  <div class="form-group">
					    <label for="name" class="col-sm-2 control-label">작성자</label>
					    <div class="col-sm-3">
					       ${userID}
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="title" class="col-sm-2 control-label">제목</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="content" class="col-sm-2 control-label">내용</label>
					    <div class="col-sm-5">
						    <textarea rows="10" type="text" class="form-control" id="content" name="content" placeholder="내용를 입력하세요"></textarea>
					    </div>
					  </div>
					   <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-danger">등록</button>
					    </div>
					  </div>
					</form>
				</div>
			</div>	
		</div>
	
		<jsp:include page="/BasicCSS/Footer.jsp"/>
    
  </body>
</html>