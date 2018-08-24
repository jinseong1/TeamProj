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
    
    <style>
    	body{
    		padding-top:51px;
    	}
    	@media all and (min-width: 768px) {
			  .navbar-fixed-width {
			    width: 768px;
			    margin: 0 auto;
			 }
		}

		@media all and (min-width: 992px) {
		  .navbar-fixed-width {
		    width: 992px;
		    margin-left: auto;
		    margin-right:auto;
		  }

		}

		@media all and (min-width: 1200px) {
		  .navbar-fixed-width {
		    width: 1200px;
		    margin-left: auto;
		    margin-right:auto;
		  }
		}
		
		.active{
			font-weight: bold;
			font-size: 1.2em;
		}  
		  
     </style>
    
    
  </head>
  <body>
  	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	    <!-- 화면 크기가 작을때 보여지는 메뉴버튼  -->
	    	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapseMenu">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#" style="color:white;font-weight: bold">
		        	박진성 프로젝트
		      </a>
	    </div><!-- navbar-header -->
	    <!-- 화면 크기가 클때 상단에 보이는 메뉴 -->
	     <div class="collapse navbar-collapse" id="collapseMenu">
	     	 <ul class="nav navbar-nav navbar-right">
	     	 	<li><a href="<c:url value="/Control/MainMove.do"/>">HOME</a></li>
       			<li><a href="<c:url value="/Control/NoticeBoard.do"/>">게시판</a></li>
       			<li><a href="<c:url value="/Control/Logout.do"/>">로그아웃</a></li> 
	     	 </ul>
	     </div>
	  </div><!-- div:contianer-fluid -->
	</nav>	
    <!-- 상단메뉴 끝 -->
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!--칼린더 -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div>
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	      <img src="<c:url value="/Image/City.jpg"/>" width="100%" height="80%">
	      <div class="carousel-caption">
	      </div>
	    </div>
	    <div class="item">
	      <img src="<c:url value="/Image/Sun.jpg"/>" width="100%" height="80%">
	      <div class="carousel-caption">
	      </div>
	    </div>
	    <div class="item">
	      <img src="<c:url value="/Image/Tree.jpg"/>" width="100%" height="80%">
	      <div class="carousel-caption">
	      </div>
	    </div>    
	  </div>
  </div>
	</div>
  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
    
  </body>
</html>