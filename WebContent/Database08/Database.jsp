<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Database.jsp</title>
</head>
<body>
   	<fieldset>
		<legend>데이타베이스 연동<span style="font-size:2em;color:red">${message}${param.method}</span></legend>
		<ul style="list-style-type: decimal;">			
			<li><a href="<c:url value='/Database/JDBCConnection.do?method=JDBC'/>">스프링 JDBC API사용(스프링 DAO모듈에 포함됨.)</a></li>
			<li><a href="<c:url value='/Database/JNDIConnection.do?method=JNDI'/>">스프링 JNDI API사용(스프링 CONTEXT모듈에 포함됨.)</a></li>
		</ul>
	</fieldset>
</body>
</html>