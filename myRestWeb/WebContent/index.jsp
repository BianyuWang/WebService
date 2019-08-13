<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" 
	  xmlns:f="http://java.sun.com/jsf/core">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
	</head>
	
	<body>
		<f:view>
			Spring REST Customer Managerment
			<hr />
			
			
		<h3>customers </h3>
		--	<a href="${pageContext.request.contextPath}/api/customers">List of customers in JSON</a>
		<br></br>
		--	<a href="${pageContext.request.contextPath}/api/customers/1">customers with id 1 in JSON</a>
		<br></br>
		<h3>Find </h3>
		--	<a href="${pageContext.request.contextPath}/api/customers/find/city/cat town">List of customers live in cat town in JSON</a>
		<br></br>
		--	<a href="${pageContext.request.contextPath}/api/customers/find/family/cat">List of customers with family name CAT in JSON</a>
	<br></br>
		--	<a href="${pageContext.request.contextPath}/api/customers/find/name/er">List of customers whose name has "er" in JSON</a>
	<br></br>
	<h3>Sort </h3>
		--	<a href="${pageContext.request.contextPath}/api/customers/sorted/family">List of customers sorted by family in JSON</a>
	<br></br>
		--	<a href="${pageContext.request.contextPath}/api/customers/sorted/birthday">List of customers sorted by birthday in JSON</a>
	<br></br>
		
	<h3>Please go to CustomerRestController to check "Delete,update,add" functions</h3>
		
			
			
			
		</f:view>
	</body>
	
</html>