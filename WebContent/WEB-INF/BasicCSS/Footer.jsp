<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- footer -->
    
    <style type="text/css">
    #comp{
    padding-top: 50px
    }
    </style>
    
    
    
	<div style="position:relative;height:710px; background-color:#222222; ">
	
	
	<div style="right:0px; bottom:0px;text-align: center;" id="comp">
	<address style="font-size: 1.5em;color: white;">회사소개</address>
	<address style="font-size: 1.3em;color: white;">서울특별시 구로구 가산동 KOSMO</address>
	<!-- * Daum 지도 - 지도퍼가기 -->
	<!-- 1. 지도 노드 -->
	<div style="width:100%; height: 100%; padding:10px; text-align:center;">
		<div id="daumRoughmapContainer1535266439827" class="root_daum_roughmap root_daum_roughmap_landing" style="width:500px; height:350px; margin:0 auto;;"></div>
	</div>
	<!--
		2. 설치 스크립트
		* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
	-->
	<script charset="UTF-8" class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>
	
		<!-- 3. 실행 스크립트 -->
		<script charset="UTF-8">
			new daum.roughmap.Lander({
				"timestamp" : "1535266439827",
				"key" : "pp3x",
				"mapWidth" : "600",
				"mapHeight" : "300"
			}).render();
		</script>
	
	
	</div>
    <!-- footer -->
    </div>