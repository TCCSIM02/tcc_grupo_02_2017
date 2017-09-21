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
	
	
	<section id="content">
		
		<section class="main padder">
		  
			<div class="clearfix">
				<h4><i class="icon-edit"></i>Cadastrar consulta</h4>
			</div>
		  
		  <div class="row">
			<div class="col-sm-12">
				<section class="panel">
					<div class="panel-body">
					 
						<form class="form-horizontal" action="controller.do" method="post" data-validate="parsley">      
						
							<div class="form-group">
								<label class="col-lg-3 control-label">Status</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="statusConsulta" id="statusConsulta" required
									maxlength="45" placeholder="agendada" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Diagnóstico</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="diagnostico" id="diagnostico" required
									maxlength="200" placeholder="não consultado" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data de inicio</label>
								<div class="col-lg-6">
									<input type="date" class="form-control" name="dataHoraConsultaInicio" id="dataHoraConsultaInicio" required
									maxlength="10" placeholder="01/01/1900 00:00" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data de conclusão</label>
								<div class="col-lg-6">
									<input type="date" class="form-control" name="dataHoraConsultaFinal" id="dataHoraConsultaFinal" required
									maxlength="10" placeholder="31/12/2000 00:00" size="16">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Valor</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="valorConsulta" id="valorConsulta" required
									maxlength="45" placeholder="00,00" size="16">
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
								<a href="ListarConsulta.jsp" class="btn btn-white">Cancelar</a>
								<button name="command" value="CriarConsulta" type="submit" class="btn btn-primary">Cadastrar</button>
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