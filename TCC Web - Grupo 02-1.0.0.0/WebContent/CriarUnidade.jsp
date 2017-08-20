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
	
	<!-- Header -->
	<c:import url="Header.jsp" />
	
	<!-- Menu de navegação do Administrador -->
	<c:import url="MenuAdministrador.jsp" />
	
	<body>
		
		<section class="main padder">
			  
				<div class="clearfix">
					<h4><i class="icon-edit"></i>Cadastrar unidade</h4>
				</div>
			  
			  <div class="row">
				<div class="col-sm-12">
					<section class="panel">
						<div class="panel-body">
						 
							<form class="form-horizontal" action="controller.do" method="post" data-validate="parsley">      
							
								<div class="form-group">
									<label class="col-lg-3 control-label">Razão social</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="razaoSocial" id="razaoSocial" required
										maxlength="200" placeholder="Razão social" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Nome fantasia</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="nomeFantasia" id="nomeFantasia" 
										maxlength="150" placeholder="Nome fantasia" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">CNPJ</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="cnpj" id="cnpj" required
										maxlength="18" placeholder="CNPJ" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Nome rede</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="nomeRede" id="nomeRede" required
										maxlength="45" placeholder="Nome rede" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Endereço</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="endereco" id="endereco" required
										maxlength="200" placeholder="Endereço" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">CEP</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="cep" id="cep" required
										maxlength="9" placeholder="CEP" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Cidade</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="cidade" id="cidade" required
										maxlength="50" placeholder="Cidade" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">UF</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="uf" id="uf" required
										maxlength="2" placeholder="UF" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">País</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="pais" id="pais" required
										maxlength="20" placeholder="País" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Representante</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="representante" id="representante" required
										maxlength="45" placeholder="País" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Telefone principal</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="tel1" id="tel1" required
										maxlength="15" placeholder="Telefone principal" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Telefone opcional</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="tel2" id="tel2" 
										maxlength="15" placeholder="Telefone opcional" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Celular</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="cel" id="cel" 
										maxlength="15" placeholder="Celular" size="16">
									</div>				  
								</div>
								

								<!--
								<div class="form-group">
									<label class="col-lg-3 control-label">Flag ativo</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="flagAtivo" id="flagAtivo"
										maxlength="100" placeholder="Flag Ativo" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Data cadastro</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="dataCadastro" id="dataCadastro"
										maxlength="100" placeholder="Data Cadastro" size="16">
									</div>				  
								</div>
								-->
								
								
								
								<div class="form-group">
								  <div class="col-lg-9 col-lg-offset-3">                      
									<a href="ListarUnidade.jsp" class="btn btn-white">Cancelar</a>
									<button name="command" value="CriarUnidade" type="submit" class="btn btn-primary">Cadastrar</button>
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

 
    <script>
        <!-- Formata os campos -->
        $(document).ready(function(){
        	$('#tel1').mask('(00) 0000-0000');
        	$('#tel2').mask('(00) 0000-0000');
        	$('#cel').mask('(00) 0000-0000');
			$('#cnpj').mask('00.000.000/0000-00');
			$('#cep').mask('00000-000');			
        });
    </script>


	
</body>
 
</html>