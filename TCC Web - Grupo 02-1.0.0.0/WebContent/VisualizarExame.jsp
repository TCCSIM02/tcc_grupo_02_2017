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
	<c:import url="MenuAdministrador.jsp?pagina=exame" />
	
	
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Visualizar Exame #${exameTO.codExame}</h3>


		<div class="row">
			<div class="col-md-6">
				<p>
					<strong>Descrição</strong>
				</p>
				<p>${exameTO.descricao}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Resultado</strong>
				</p>
				<p>${exameTO.resultadoExame}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Valor</strong>
				</p>
				<p>${exameTO.valorExame}</p>
			</div>

		</div>
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="controller.do?command=EditarExame&id=${exameTO.codExame}"
					class="btn btn-primary">Editar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal">Excluir</a> <a
					href="ListarExame" class="btn btn-default">Voltar</a>
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
					<h4 class="modal-title" id="modalLabel">Excluir Exame</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este exame?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" value="${exameTO.codExame}"/>
						<button type="submit" class="btn btn-primary" name="command" value="ExcluirExame">Sim</button>
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