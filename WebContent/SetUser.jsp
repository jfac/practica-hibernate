<%@ page language="java" contentType="text/html;"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Bootstrap Insert Users</title>
 
    <!-- CSS de Bootstrap -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
 
    <!-- librerías opcionales que activan el soporte de HTML5 para IE8 -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="container">
		<div class="row">
			<c:choose>
				<c:when test="${not empty Succes}">
					<div class="alert alert-success">${Success}${param.Success}</div>
				</c:when>
				<c:when test="${not empty err}">
					<div class="alert alert-warning">${err}${param.err}</div>
				</c:when>
			</c:choose>
		</div>
		<div class="row">
        <div class="form-group">
          <form role="form" class="form-inline" id="frmUsers" action="SaveServlet" method="Post">
            <div class="form-group">
              <div class="span6"><label>Nombre</label></div>
              <div class="span6">
                <input type="text" name="Nombre" class="form-control" value="${param.Nombre}" value="" required>
                <div class="form-group has-error">
                  <label class="control-label" for="inputError">${Nombre}</label>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="span6"><label>Apellido Paterno</label></div>
              <div class="span6">
                <input type="text" name="apellidoPaterno" class="form-control" value="${param.apellidoPaterno}" required>
                <div class="form-group has-error">
                  <label class="control-label" for="inputError">${apellidoPaterno}</label>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="span6"><label>Apellido Materno</label></div>
              <div class="span6">
                <input type="text" name="apellidoMaterno" class="form-control" value="${param.apellidoMaterno}" required>
                <div class="form-group has-error">
                  <label class="control-label" for="inputError">${apellidoMaterno}</label>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="span6"><label>RFC</label></div>
              <div class="span6">
                <input type="text" name="RFC" class="form-control" value="${param.RFC}" required>
                <div class="form-group has-error">
                  <label class="control-label" for="inputError">${RFC}</label>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="span6"><label>Correo</label></div>
              <div class="span6">
                <input type="email" name="email" class="form-control" value="${param.email}" required>
                <div class="form-group has-error">
                  <label class="control-label" for="inputError">${email}</label>
                </div>
              </div>
            </div>
            <div class="form-group">
              <button type="submit" class="btn btn-default">Enviar</button>
            </div>
          </form>
        </div><!-- form group -->
      </div><!-- row -->
    </div><!-- container -->
 
    <!-- Librería jQuery requerida por los plugins de JavaScript -->
    <script type='text/javascript' src='jQ/jquery-1.11.2.min.js'></script>
    <script type='text/javascript' src='jQ/jquery.validate_1.13.1.min.js'></script>
    <script type='text/javascript' src='jQ/jsValidacion.js'></script>
 
    <!-- Latest compiled and minified JavaScript -->
    <script type='text/javascript'  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  </body>
</html>