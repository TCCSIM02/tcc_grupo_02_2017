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
	<c:import url="MenuAdministrador.jsp?pagina=funcionario" />
	
	
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Visualizar Administrador #${administradorTO.codAdministrador}</h3>


		<div class="row">

			<div class="col-md-6">
				<p>
					<strong>Nome</strong>
				</p>
				<p>${administradorTO.nome}</p>
			</div>

			<div class="col-md-6">
				<p>
					<strong>CPF</strong>
				</p>
				<p>${administradorTO.cpf}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Data Nascimento</strong>
				</p>
				<p>${administradorTO.dataNascimento}</p>
			</div>

			<div class="col-md-6">
				<p>
					<strong>Email</strong>
				</p>
				<p>${administradorTO.email}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Estado Cívil</strong>
				</p>
				<p>${administradorTO.estadoCivil}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Nacionalidade</strong>
				</p>
				<p>${administradorTO.nacionalidade}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Endereço</strong>
				</p>
				<p>${administradorTO.endereco}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Número</strong>
				</p>
				<p>${administradorTO.numeroEndereco}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>CEP</strong>
				</p>
				<p>${administradorTO.cep}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>UF</strong>
				</p>
				<p>${administradorTO.uf}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Cidade</strong>
				</p>
				<p>${administradorTO.cidade}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>País</strong>
				</p>
				<p>${administradorTO.pais}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Telefone Principal</strong>
				</p>
				<p>${administradorTO.tel1}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Telefone Opcional</strong>
				</p>
				<p>${administradorTO.tel2}</p>
			</div>
			
			<div class="col-md-6">
				<p>
					<strong>Celular</strong>
				</p>
				<p>${administradorTO.cel}</p>
			</div>


		</div>
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="controller.do?command=EditarAdministrador&id=${administradorTO.codAdministrador}"
					class="btn btn-primary">Editar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal">Excluir</a> <a
					href="ListarAdministrador.jsp" class="btn btn-default">Voltar</a>
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
					<h4 class="modal-title" id="modalLabel">Excluir Administrador</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este Administrador?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" value="${administradorTO.codAdministrador}"/>
						<button type="submit" class="btn btn-primary" name="command" value="ExcluirAdministrador">Sim</button>
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