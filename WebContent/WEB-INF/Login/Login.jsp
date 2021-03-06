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
    <title>로그인</title>
	
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
    
	<link rel="stylesheet" href="../BasicCSS/LoginForm.css" type="text/css"/>

  </head>
<body id="LoginForm">
	<div class="container">
		<h1 class="form-heading">login Form</h1>
			<div class="login-form">
			<div class="main-div">
			<div class="panel">
			<h2>ParkJinSeong</h2>
			<p>Please enter your email and password</p>
			<c:if test="${errorMessage!=null}"><span style="color: red;font-size: 1.3em;font: bold;">${errorMessage}</span></c:if>
			</div>
				<form id="Login" action="<c:url value="/Control/MainMove.do"/>" method="post">
				<div class="form-group">
					<input type="text" class="form-control" id="userID" name="userID" placeholder="아이디를 입력하여주세요">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" id="userPWD" name="userPWD" placeholder="비밀번호를 입력하여주세요">
				</div>
				<div class="forgot">
					<a href="<c:url value="/Control/SingUpForm.do"/>">회원가입 하시겠습니까?</a>
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
	<!-- 
	 Members table
	 ID                                        NOT NULL NVARCHAR2(15)
	 PASSWORD                                  NOT NULL NVARCHAR2(20)
	 NAME                                      NOT NULL NVARCHAR2(10)
	 GENDER                                    NOT NULL NVARCHAR2(10)
	 TEL                                       NOT NULL NVARCHAR2(15)
	 LIFEAAGEPLAN                              NOT NULL NVARCHAR2(15)
	
	 Post table
	 
	  NO                                        NOT NULL NUMBER
	 ID                                        NOT NULL NVARCHAR2(15)
	 TITLE                                     NOT NULL NVARCHAR2(50)
	 POSTDATE                                  NOT NULL DATE
	 CONTENT                                   NOT NULL NVARCHAR2(1000)
	 DOWNCOUNT                                          NUMBER
	 -->
</body>
</html>