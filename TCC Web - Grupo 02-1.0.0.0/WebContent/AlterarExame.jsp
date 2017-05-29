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
	
	
	<section id="content">
		
		<section class="main padder">
		  
			<div class="clearfix">
				<h4><i class="icon-edit"></i>Alterar exame</h4>
			</div>
		  
		  <div class="row">
			<div class="col-sm-12">
				<section class="panel">
					<div class="panel-body">
					 
						<form class="form-horizontal" action="controller.do" method="post" data-validate="parsley"> 

							<input type="hidden" name="codExame" id="codExame" value="${exameTO.codExame}"> 
						
							<div class="form-group">
								<label class="col-lg-3 control-label">Descrição</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="descricao" id="descricao" required
									maxlength="500" placeholder="descrição do exame" size="16" value="${exameTO.descricao}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Resultado</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="resultadoExame" id="resultadoExame" required
									maxlength="100" placeholder="resultado do exame" size="16" value="${exameTO.resultadoExame}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Valor</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="valorExame" id="valorExame" required
									maxlength="45" placeholder="resultado do exame" size="16" value="${exameTO.valorExame}">
								</div>				  
							</div>	
							
							
							<div class="form-group">
							  <div class="col-lg-9 col-lg-offset-3"> 
								<a href="ListarExame.jsp" class="btn btn-white">Cancelar</a>
								<button name="command" value="AlterarExame" type="submit" class="btn btn-primary">Salvar</button>
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