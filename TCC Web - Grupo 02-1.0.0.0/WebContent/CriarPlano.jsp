<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Criar Planos</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>


<body>
 
 <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
	

	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Incluir Plano</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="controller.do" method="post">

			<!-- area de campos do form -->


			<div class="row">
				<div class="form-group col-md-12">
					<label for="nomePlano">Nome</label> <input type="text"
						class="form-control" name="nomePlano" id="nomePlano" required
						maxlength="100" placeholder="nome do plano">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="registroAns">Registro ANS</label> <input type="text"
						class="form-control" name="registroAns" id="registroAns" required
						maxlength="100" placeholder="registro Ans">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="tipoPlano">Tipo</label> <input type="text"
						class="form-control" name="tipoPlano" id="tipoPlano" required
						maxlength="100" placeholder="tipo do plano">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="flagAtivo">Flag Ativo</label> <input type="text" class="form-control"
						name="flagAtivo" id="flagAtivo" maxlength="100" placeholder="Flag Ativo">
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label for="dataCadastro">Data Cadastro</label> <input type="text"
						class="form-control" name="dataCadastro" id="dataCadastro" maxlength="100"
						placeholder="Data Cadastro">
				</div>
			</div>

			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">

					<button type="submit" class="btn btn-primary" name="command" value="CriarPlano">Inserir</button>

					<a href="index.html" class="btn btn-default">Cancelar</a>

				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>