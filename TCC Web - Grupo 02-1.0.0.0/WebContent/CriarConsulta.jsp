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
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/moment.js"></script>
	
	
	
	
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
				<h4><i class="icon-edit"></i>Cadastrar consulta</h4>
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
									<textarea class="form-control" name="diagnostico" id="diagnostico" required rows="10" cols="40"
									maxlength="200" placeholder="não consultado" style="overflow:auto;resize:none" ></textarea>
								</div>											  
							</div>					
			
							<div class="container">
							    <div class='col-md-5'>
							        <div class="form-group">
							            <div class='input-group date' id='datetimepicker6'>
							                <input type='text' class="form-control" />
							                <span class="input-group-addon">
							                    <span class="glyphicon glyphicon-calendar"></span>
							                </span>
							            </div>
							        </div>
							    </div>
							    <div class='col-md-5'>
							        <div class="form-group">
							            <div class='input-group date' id='datetimepicker7'>
							                <input type='text' class="form-control" />
							                <span class="input-group-addon">
							                    <span class="glyphicon glyphicon-calendar"></span>
							                </span>
							            </div>
							        </div>
							    </div>
							</div>
							
							
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
	<c:import url="Footer.jsp"/>
	
	
	<script type="text/javascript">
	    $(function () {
	        $('#datetimepicker6').datetimepicker();
	        $('#datetimepicker7').datetimepicker({
	            useCurrent: false //Important! See issue #1075
	        });
	        $("#datetimepicker6").on("dp.change", function (e) {
	            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
	        });
	        $("#datetimepicker7").on("dp.change", function (e) {
	            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
	        });
	    });
	</script>	
</body>
</html>