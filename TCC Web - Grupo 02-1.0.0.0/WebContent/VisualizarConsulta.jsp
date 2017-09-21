<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
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
	<c:import url="MenuAdministrador.jsp?pagina=consulta" />
	
	
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Visualizar Consulta #${consultaTO.codConsulta}</h3>


		<div class="row">
			<div class="col-md-6">
				<p>
					<strong>Status</strong>
				</p>
				<p>${consultaTO.statusConsulta}</p>
			</div>

			<div class="col-md-6">
				<p>
					<strong>Diagnóstico</strong>
				</p>
				<p>${consultaTO.diagnostico}</p>
			</div>

			<div class="col-md-6">
				<p>
					<strong>Data inicio da consulta</strong>
				</p>
				<p>${consultaTO.dataHoraConsultaInicio}</p>
			</div>

			<div class="col-md-6">
				<p>
					<strong>Data fim da consulta</strong>
				</p>
				<p>${consultaTO.dataHoraConsultaFinal}</p>
			</div>

			<div class="col-md-6">
				<p>
					<strong>Valor da consulta</strong>
				</p>
				<p>${consultaTO.valorConsulta}</p>
			</div>

		</div>
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="controller.do?command=EditarConsulta&id=${consultaTO.codConsulta}"
					class="btn btn-primary">Editar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal">Excluir</a> <a
					href="ListarConsulta.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Consulta</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este consulta?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" value="${consultaTO.codConsulta}"/>
						<button type="submit" class="btn btn-primary" name="command" value="ExcluirConsulta">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->




	<!-- Footer -->
	<c:import url="Footer.jsp" />
	
	
</body>
</html>