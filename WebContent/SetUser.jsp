<%@ page language="java" contentType="text/html;"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<script type='text/javascript' src='jQ/jquery-1.11.2.min.js'></script>
<script type='text/javascript' src='jQ/jquery.validate_1.13.1.min.js'></script>
<!-- Latest compiled and minified JavaScript -->
<script type='text/javascript' src='jQ/jsValidacion.js'></script>
<script type='text/javascript'  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span3">
				<c:choose>

					<c:when test="${not empty param.Success}">
						<div class="alert alert-success">${param.Success}</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-warning">${err } ${param.err}</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="span8">
				<form role="form" id="frmUsers" action="SaveServlet" method="Post">
					<div class="form-group">
						<label>Nombre</label> <input type="text" name="Nombre"
							value="${param.Nombre}" value="" required>
					</div>
					<div class="form-group">
						<label>Apellido Paterno</label> <input type="text" name="apellidoPaterno"
							value="${param.apellidoPaterno}" required>
					</div>
					<div class="form-group">
						<label>Apellido Materno</label> <input type="text" name="apellidoMaterno"
							value="${param.apellidoMaterno}" required>
					</div>
					<div class="form-group">
						<label>RFC</label> <input type="text" name="RFC"
							value="${param.RFC}" required>
					</div>
					<div class="form-group">
						<label>Correo</label> <input type="email" name="email"
							value="${param.email}" required>
					</div>
					<button type="submit" class="btn btn-default">Enviar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>