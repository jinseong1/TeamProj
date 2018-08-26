<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- DataRoomTop.jsp -->

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
	     	 	<li><a href="<c:url value="/Control/Main.do"/>">HOME</a></li>
       			<li><a href="<c:url value="/Control/NoticeBoard.do?nowPage=1"/>">게시판</a></li>
       			<li><a href="<c:url value="/Control/Logout.do"/>">로그아웃</a></li> 
	     	 </ul>
	     </div>
	  </div><!-- div:contianer-fluid -->
	</nav>	
    <!-- 상단메뉴 끝 -->
