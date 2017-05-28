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
					<h4 class="modal-title" id="modalLabel">Excluir Plano</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este plano?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" id="id_excluir"/>
						<button type="submit" class="btn btn-primary" name="command" value="ExcluirPlano">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	
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