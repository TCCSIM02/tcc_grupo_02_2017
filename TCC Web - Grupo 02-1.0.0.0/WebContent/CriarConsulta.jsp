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
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	$( function() {
		$( "#dataInicio" ).datepicker({ dateFormat: "dd/mm/yy" }).val();
		$( "#dataFim" ).datepicker({ dateFormat: "dd/mm/yy" }).val();
	} );
	</script>

	
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
					 
						<form class="form-horizontal" action="controller.do" method="get" data-validate="parsley">      
						
						
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
									maxlength="200" placeholder="Diagnóstico" style="overflow:auto;resize:none" ></textarea>
								</div>											  
							</div>
							
											
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data de início</label>
								<div class="col-lg-3">
									<input type="text" id="dataInicio" name="dataInicio" size="10"  class="form-control">
								</div>
								<div class="col-lg-3">
										<select id="horaInicio" name="horaInicio" class="input-sm inline form-control"  style="width:100%">
											<option value="00:00:00">00:00</option>	
											<option value="01:00:00">01:00</option>	
											<option value="02:00:00">02:00</option>	
											<option value="03:00:00">03:00</option>	
											<option value="04:00:00">04:00</option>	
											<option value="05:00:00">05:00</option>	
											<option value="06:00:00">06:00</option>	
											<option value="07:00:00">07:00</option>	
											<option value="08:00:00">08:00</option>	
											<option value="09:00:00">09:00</option>	
											<option value="10:00:00">10:00</option>	
											<option value="11:00:00">11:00</option>	
											<option value="12:00:00">12:00</option>	
											<option value="13:00:00">13:00</option>	
											<option value="14:00:00">14:00</option>	
											<option value="15:00:00">15:00</option>
											<option value="16:00:00">16:00</option>	
											<option value="17:00:00">17:00</option>	
											<option value="18:00:00">18:00</option>	
											<option value="19:00:00">19:00</option>	
											<option value="20:00:00">20:00</option>	
											<option value="21:00:00">21:00</option>	
											<option value="22:00:00">22:00</option>	
											<option value="23:00:00">23:00</option>											
										</select>
									</div>													  
							</div>
							
							
							
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data de conclusão</label>
								<div class="col-lg-3">
									<input type="text" id="dataFim" name="dataFim" size="10"  class="form-control">
								</div>
								<div class="col-lg-3">
										<select id="horaFim" name="horaFim" class="input-sm inline form-control"  style="width:100%">
											<option value="00:00:00">00:00</option>	
											<option value="01:00:00">01:00</option>	
											<option value="02:00:00">02:00</option>	
											<option value="03:00:00">03:00</option>	
											<option value="04:00:00">04:00</option>	
											<option value="05:00:00">05:00</option>	
											<option value="06:00:00">06:00</option>	
											<option value="07:00:00">07:00</option>	
											<option value="08:00:00">08:00</option>	
											<option value="09:00:00">09:00</option>	
											<option value="10:00:00">10:00</option>	
											<option value="11:00:00">11:00</option>	
											<option value="12:00:00">12:00</option>	
											<option value="13:00:00">13:00</option>	
											<option value="14:00:00">14:00</option>	
											<option value="15:00:00">15:00</option>
											<option value="16:00:00">16:00</option>	
											<option value="17:00:00">17:00</option>	
											<option value="18:00:00">18:00</option>	
											<option value="19:00:00">19:00</option>	
											<option value="20:00:00">20:00</option>	
											<option value="21:00:00">21:00</option>	
											<option value="22:00:00">22:00</option>	
											<option value="23:00:00">23:00</option>											
										</select>
									</div>																  
							</div>	
							
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Exames</label>
								<div class="col-lg-6">
									<textarea class="form-control" name="exames" id="exames" rows="5" cols="20"
									maxlength="600" placeholder="Exames" style="overflow:auto;resize:none" ></textarea>
								</div>											  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Receituário</label>
								<div class="col-lg-6">
									<textarea class="form-control" name="receituario" id="receituario" rows="5" cols="20"
									maxlength="600" placeholder="Receituário" style="overflow:auto;resize:none" ></textarea>
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
	
	  <script>
        <!-- Formata os campos -->
        $(document).ready(function(){
        	$('#dataInicio').mask('00/00/0000');
        	$('#dataFim').mask('00/00/0000');
        });
      </script>
	

</body>
</html>