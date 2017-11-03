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
	
	<%
    	String data="";
		data = request.getParameter("eventDate");
	%>

	
	
	<section id="content">
		
		<section class="main padder">
		  
			<div class="clearfix">
				<h4><i class="icon-edit"></i>Visualizar consulta</h4>
			</div>
		  
		  <div class="row">
			<div class="col-sm-12">
				<section class="panel">
					<div class="panel-body">
					 
						<form class="form-horizontal" action="controller.do" method="post" data-validate="parsley">      
							<div class="form-group">
								<label class="col-lg-3 control-label">Codigo do agendamento</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="codAgendamento" id="codAgendamento" required
									maxlength="200" placeholder="" size="16"  readonly="true" value="${codAgendamento}">
								</div>				  
							</div>

							<div class="form-group">
								<label class="col-lg-3 control-label">Paciente</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nomePaciente" id="nomePaciente" required
									maxlength="200" placeholder="" size="16"  readonly="true" value="${nomePaciente}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Medico</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nomeMedico" id="nomeMedico" required
									maxlength="200" placeholder="" size="16"  readonly="true" value="${nomeMedico}">
								</div>				  
							</div>
						
							<div class="form-group">
								<label class="col-lg-3 control-label">Diagnóstico</label>
								<div class="col-lg-6">
									<textarea class="form-control" name="diagnostico" id="diagnostico" rows="10" cols="40"
									maxlength="200" placeholder="não consultado" readonly="true" style="overflow:resize:none">${diagnostico}</textarea>
								</div>											  
							</div>
							
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data de inicio</label>
								<div class="col-lg-4">
									<input  type="date" class="form-control" name="dataHoraConsultaInicio" id="dataHoraConsultaInicio" required
									maxlength="11" placeholder="" size="16" value="">
								</div>	
								<div class="col-lg-2">
									<input type="time" class="form-control" name="horaInicio" id="horaInicio" required
									maxlength="5" placeholder="" size="16" >
								</div>				  
							</div>
							

							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data de conclusão</label>
								<div class="col-lg-4">
									<input type="date" class="form-control" name="dataFim" value="" id="dataFim" required 
									maxlength="11" placeholder="" size="16">
								</div>	
								<div class="col-lg-2">
									<input type="time" class="form-control" name="horaFim" id="horaFim" required
									maxlength="5" placeholder="" size="16">
								</div>				  
							</div>
							
							<div id="actions" class="row">
								<div class="col-md-12">
				 					<a	href="ListarAtendente.jsp" class="btn btn-default">Voltar</a>
								</div>
							</div>
						
						</form>				  
					</div>
				</section>
			</div>  
		</div>
	</section>
	
	
	<!-- Footer -->
	<c:import url="Footer.jsp"/>
	
</body>
</html>