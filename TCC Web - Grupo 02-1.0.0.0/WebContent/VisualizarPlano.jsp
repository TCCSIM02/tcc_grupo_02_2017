<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<meta charset="utf-8">
  	<title>TCC - grupo 02 SI</title>
  	<meta name="description" content="mobile first, app, web app, responsive, admin dashboard, flat, flat ui">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/font.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/plugin.css">
	<link rel="stylesheet" href="css/landing.css">
	<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
</head>
<body>
	
	<!-- Header -->
	<c:import url="Header.jsp" />
	
	<!-- Menu de navegação do Administrador -->
	<c:import url="MenuAdministrador.jsp" />
	
	
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Visualizar Plano #${planoTO.codPlano}</h3>


		<div class="row">
			<div class="col-md-6">
				<p>
					<strong>Nome</strong>
				</p>
				<p>${planoTO.nomePlano}</p>
			</div>




			<div class="col-md-6">
				<p>
					<strong>Registro ANS</strong>
				</p>
				<p>${planoTO.registroAns}</p>
			</div>



			<div class="col-md-6">
				<p>
					<strong>Tipo</strong>
				</p>
				<p>${planoTO.tipoPlano}</p>
			</div>


			<div class="col-md-6">
				<p>
					<strong>Flag Ativo</strong>
				</p>
				<p>${planoTO.flagAtivo}</p>
			</div>


			<div class="col-md-6">
				<p>
					<strong>Data cadastro</strong>
				</p>
				<p>${planoTO.dataCadastro}</p>
			</div>

		</div>
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="controller.do?command=EditarPlano&id=${planoTO.codPlano }"
					class="btn btn-primary">Editar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal">Excluir</a> <a
					href="ListarPlano.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	
	
	
	
	<!-- Footer -->
	<c:import url="Footer.jsp" />
	
	
</body>
</html>