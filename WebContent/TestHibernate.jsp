<%@page import="moderl.User.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='lista' class="moderl.User.User" scope='request'></jsp:useBean>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<c:forEach items="${lista.getListUser()}" var="art" varStatus="status">
<p>${art.getNombre()}</p>
<p>${art.getApellidoPaterno()}</p>
<p>${art.getApellidoMaterno()}</p>
<p>${art.getRFC()}</p>
<p>${art.getCorreoElectronico()}</p>
</c:forEach>
</body>
</html>