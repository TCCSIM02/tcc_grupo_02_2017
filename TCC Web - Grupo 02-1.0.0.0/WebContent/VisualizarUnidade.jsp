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
			<h3 class="page-header">Visualizar Unidade #${unidadeTO.codUnidade}</h3>


			<div class="row">
				<div class="col-md-6">
					<p>
						<strong>Razão social</strong>
					</p>
					<p>${unidadeTO.razaoSocial}</p>
				</div>			
			
				<div class="col-md-6">
					<p>
						<strong>Nome fantasia</strong>
					</p>
					<p>${unidadeTO.nomeFantasia}</p>
				</div>			
			
				<div class="col-md-6">
					<p>
						<strong>CNPJ</strong>
					</p>
					<p>${unidadeTO.cnpj}</p>
				</div>			
			
				<div class="col-md-6">
					<p>
						<strong>Nome da Rede</strong>
					</p>
					<p>${unidadeTO.nomeRede}</p>
				</div>			
			
				<div class="col-md-6">
					<p>
						<strong>Endereço</strong>
					</p>
					<p>${unidadeTO.endereco}</p>
				</div>			
			
				<div class="col-md-6">
					<p>
						<strong>CEP</strong>
					</p>
					<p>${unidadeTO.cep}</p>
				</div>			
			
				<div class="col-md-6">
					<p>
						<strong>Cidade</strong>
					</p>
					<p>${unidadeTO.cidade}</p>
				</div>			
			
				<div class="col-md-6">
					<p>
						<strong>UF</strong>
					</p>
					<p>${unidadeTO.uf}</p>
				</div>			
				
			
				<div class="col-md-6">
					<p>
						<strong>País</strong>
					</p>
					<p>${unidadeTO.pais}</p>
				</div>			
			
				<div class="col-md-6">
					<p>
						<strong>Representante</strong>
					</p>
					<p>${unidadeTO.representante}</p>
				</div>	
				
				<div class="col-md-6">
					<p>
						<strong>Telefone principal</strong>
					</p>
					<p>${unidadeTO.tel1}</p>
				</div>
			
				<div class="col-md-6">
					<p>
						<strong>Telefone opcional</strong>
					</p>
					<p>${unidadeTO.tel2}</p>
				</div>	
			
				<div class="col-md-6">
					<p>
						<strong>Celular</strong>
					</p>
					<p>${unidadeTO.cel}</p>
				</div>
			
				<div class="col-md-6">
					<p>
						<strong>Flag ativo</strong>
					</p>
					<p>${unidadeTO.flagAtivo}</p>
				</div>
				
				<div class="col-md-6">
					<p>
						<strong>Data cadastro</strong>
					</p>
					<p>${unidadeTO.dataCadastro}</p>
				</div>			
			</div>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="controller.do?command=EditarUnidade&id=${unidadeTO.codUnidade}"
						class="btn btn-primary">Editar</a> <a href="#"
						class="btn btn-danger" data-toggle="modal"
						data-target="#delete-modal">Excluir</a> <a
						href="ListarUnidade.jsp" class="btn btn-default">Voltar</a>
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
						<h4 class="modal-title" id="modalLabel">Excluir Unidade</h4>
					</div>
					<div class="modal-body">Deseja realmente excluir este unidade?</div>
					<div class="modal-footer">
						<form action="controller.do" method="post">
							<input type="hidden" name="id" value="${unidadeTO.codUnidade}"/>
							<button type="submit" class="btn btn-primary" name="command" value="ExcluirUnidade">Sim</button>
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