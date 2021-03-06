<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>Consult.me</title>

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
	<c:import url="MenuAdministrador.jsp?pagina=agendamento" />

	<section id="content">
		
		<section class="main padder">
		  
			<div class="clearfix">
				<h4><i class="icon-edit"></i>Cadastrar agendamento</h4>
			</div>
			  
			<div class="row">
				<div class="col-sm-12">
					<section class="panel">
						<div class="panel-body">
						 
							<form class="form-horizontal" action="controller.do" method="post" data-validate="parsley">   
							
							<input type="hidden"  name="codAgendamento" id="codAgendamento" readonly="true" value="${codAgendamento}">
							
							<input type="hidden"  name="txtFlagAtivo" id="txtFlagAtivo" readonly="true" value="${flagAtivo}">
							
							<input type="hidden"  name="codPaciente" id="codPaciente" readonly="true" value="${codPaciente}">
							
							<input type="hidden"  name="txtHoraComeco" id="txtHoraComeco" readonly="true" value="${horaComeco}">
							
							<input type="hidden"  name="txtHoraFim" id="txtHoraFim" readonly="true" value="${horaFim}">
							
							<input type="hidden"  name="codUnidade" id="codUnidade" readonly="true" value="${codUnidade}">
							
							<input type="hidden"  name="codMedico" id="codMedico" readonly="true" value="${codMedico}">
							
							<input type="hidden"  name="codEspecialidade" id="codEspecialidade" readonly="true" value="${codEspecialidade}">
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Paciente</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nomePaciente" id="nomePaciente" required
									maxlength="200" placeholder="" size="16"  readonly="true" value="${nomePaciente}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Unidade</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nomeUnidade" id="nomeUnidade" required
									maxlength="200" placeholder="" size="16"  readonly="true" value="${nomeUnidade}">
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
								<label class="col-lg-3 control-label">Especialidade</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nomeEspecialidade" id="nomeEspecialidade" required
									maxlength="200" placeholder="" size="16"  readonly="true" value="${nomeEspecialidade}">
								</div>				  
							</div>	

							<div class="form-group">
								<label class="col-lg-3 control-label">Data de início</label>
								<div class="col-lg-3">
									<input type="text" id="dataInicio" name="dataInicio" size="10"  class="form-control" value="${dataComeco}">
								</div>
								<div class="col-lg-3">
										<select id="horaInicio" name="horaInicio" class="input-sm inline form-control" value="${horaComeco}" style="width:100%">
											<option value="00:00">00:00</option>	
											<option value="01:00">01:00</option>	
											<option value="02:00">02:00</option>	
											<option value="03:00">03:00</option>	
											<option value="04:00">04:00</option>	
											<option value="05:00">05:00</option>	
											<option value="06:00">06:00</option>	
											<option value="07:00">07:00</option>	
											<option value="08:00">08:00</option>	
											<option value="09:00">09:00</option>	
											<option value="10:00">10:00</option>	
											<option value="11:00">11:00</option>	
											<option value="12:00">12:00</option>	
											<option value="13:00">13:00</option>	
											<option value="14:00">14:00</option>	
											<option value="15:00">15:00</option>
											<option value="16:00">16:00</option>	
											<option value="17:00">17:00</option>	
											<option value="18:00">18:00</option>	
											<option value="19:00">19:00</option>	
											<option value="20:00">20:00</option>	
											<option value="21:00">21:00</option>	
											<option value="22:00">22:00</option>	
											<option value="23:00">23:00</option>										
										</select>
									</div>													  
							</div>
							
							
							
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data de conclusão</label>
								<div class="col-lg-3">
									<input type="text" id="dataFim" name="dataFim" size="10"  class="form-control" value="${dataFim}">
								</div>
								<div class="col-lg-3">
										<select id="horaFim" name="horaFim" class="input-sm inline form-control" value="${horaFim}" style="width:100%">
											<option value="00:00">00:00</option>	
											<option value="01:00">01:00</option>	
											<option value="02:00">02:00</option>	
											<option value="03:00">03:00</option>	
											<option value="04:00">04:00</option>	
											<option value="05:00">05:00</option>	
											<option value="06:00">06:00</option>	
											<option value="07:00">07:00</option>	
											<option value="08:00">08:00</option>	
											<option value="09:00">09:00</option>	
											<option value="10:00">10:00</option>	
											<option value="11:00">11:00</option>	
											<option value="12:00">12:00</option>	
											<option value="13:00">13:00</option>	
											<option value="14:00">14:00</option>	
											<option value="15:00">15:00</option>
											<option value="16:00">16:00</option>	
											<option value="17:00">17:00</option>	
											<option value="18:00">18:00</option>	
											<option value="19:00">19:00</option>	
											<option value="20:00">20:00</option>	
											<option value="21:00">21:00</option>	
											<option value="22:00">22:00</option>	
											<option value="23:00">23:00</option>											
										</select>
									</div>																  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Ativo?</label>
									<div class="col-lg-6">
										<input type="checkbox" name="flagAtivo" id="flagAtivo">Ativo<br>
									</div>				  
							</div>
							
						
							<div class="form-group">
							  <div class="col-lg-9 col-lg-offset-3">                      
								<a href="Index" class="btn btn-white">Cancelar</a>
								<button name="command" value="AlterarAgendamento" type="submit" class="btn btn-primary">Cadastrar</button>
							  </div>
							</div>
								
							</form>				  
						</div>
					</section>
				</div>  
			</div>
		</section>
	</section>

	  	
	<script type="text/javascript" >
		$(document).ready(
			function() { 
				var horaComeco = document.getElementById("txtHoraComeco").value;
				var horaFim = document.getElementById("txtHoraFim").value;

				var flagAtivo = document.getElementById("txtFlagAtivo").value;
				
				document.getElementById("flagAtivo").checked = true;

				
				comboComeco = document.getElementById("horaInicio");
				comboFim = document.getElementById("horaFim");
				
				for ( i =0; i < comboComeco.length; i++){
					if (comboComeco[i].value == horaComeco){
						comboComeco[i].selected = true;	
					}									
				}
				
				for ( i =0; i < comboFim.length; i++){
					if (comboFim[i].value == horaFim){
						comboFim[i].selected = true;	
					}									
				}
				
				if (flagAtivo == 1){
					checkFlagAtivo.checked = true;
				}
				
				
		});
	</script>
	  
	  
	<!-- Footer -->
	<c:import url="Footer.jsp" />
	    
	</body>

</html>