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
	
	<!-- Menu de navega��o do Administrador -->
	<c:import url="MenuAdministrador.jsp" />
	
	
	<section id="content">
		
		<section class="main padder">
		  
			<div class="clearfix">
				<h4><i class="icon-edit"></i>Cadastrar paciente</h4>
			</div>
		  
		  <div class="row">
			<div class="col-sm-12">
				<section class="panel">
					<div class="panel-body">
					 
						<form class="form-horizontal" action="controller.do" method="post" data-validate="parsley">      
						
							<div class="form-group">
								<label class="col-lg-3 control-label">Nome de usu�rio</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nomeLogin" id="nomeLogin" required
									maxlength="20" placeholder="n�mero do c�nvenio" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Senha</label>
								<div class="col-lg-6">
									<input type="password" class="form-control" name="senha" id="senha" required
									maxlength="65" placeholder="nome do paciente" size="16">
								</div>				  
							</div>
							
				
							
							<div class="form-group">
								<label class="col-lg-3 control-label">N�mero do Conv�nio</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="numConvenio" id="numConvenio" required
									maxlength="20" placeholder="n�mero do c�nvenio" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Nome paciente</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nome" id="nome" required
									maxlength="65" placeholder="nome do paciente" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">CPF</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cpf" id="cpf" required
									maxlength="14" placeholder="cpf" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data Nascimento</label>
								<div class="col-lg-6">
									<input type="date" class="form-control" name="dataNascimento" id="dataNascimento" required
									maxlength="11" placeholder="data de nascimento" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Email</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="email" id="email" required
									maxlength="100" placeholder="email" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Estado C�vil</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="estadoCivil" id="estadoCivil" 
									maxlength="20" placeholder="estado civil" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Nacionalidade</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nacionalidade" id="nacionalidade" required
									maxlength="35" placeholder="nacionalidade" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Endere�o</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="endereco" id="endereco" required
									maxlength="200" placeholder="endereco" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">N�mero</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="numeroEndereco" id="numeroEndereco" required
									maxlength="200" placeholder="n�mero" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">CEP</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cep" id="cep" required
									maxlength="9" placeholder="cep" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">UF</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="uf" id="uf" required
									maxlength="2" placeholder="uf" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Cidade</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cidade" id="cidade" required
									maxlength="9" placeholder="cep" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Pa�s</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="pais" id="pais" required
									maxlength="20" placeholder="pa�s" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Telefone Principal</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="tel1" id="tel1" required
									maxlength="15" placeholder="telefone principal" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Telefone Opcional</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="tel2" id="tel2" 
									maxlength="15" placeholder="telefone opcional" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Celular</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cel" id="cel" 
									maxlength="15" placeholder="telefone opcional" size="16">
								</div>				  
							</div>						
					
							<div class="form-group">
							  <div class="col-lg-9 col-lg-offset-3">                      
								<a href="ListarPaciente.jsp" class="btn btn-white">Cancelar</a>
								<button name="command" value="CriarPaciente" type="submit" class="btn btn-primary">Cadastrar</button>
							  </div>
							</div>
							
						</form>				  
					</div>
				</section>
			</div>  
		</div>
	</section>
	
	
	<!-- Footer -->
	<c:import url="Footer.jsp" />
	
	
</body>
</html>