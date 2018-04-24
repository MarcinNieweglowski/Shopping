<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Product Database</title>
	<link href="<c:url value="/resources/form-validation.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/main.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/general.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/navbar.css" />" rel="stylesheet">
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
 	<spring:url value="/resources/form-validation.js" var="formJS" />
	<spring:url value="/resources/navbar.js" var="navbarJS" />
</head>
<body>