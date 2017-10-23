	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
		
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
		
		<script type="text/javascript">

			$(document).ready( function(){
				
				$('#paciente').change(function(){
					comboPaciente = document.getElementById("paciente");
					comboEspecialidade = document.getElementById("especialidade");
					if(comboPaciente.value != ""){
						comboEspecialidade.disabled = false;
					}else{
						comboEspecialidade.disabled = true;
					}
				});
				
				$('#especialidade').change(function(){
					comboEspecialidade = document.getElementById("especialidade");
					comboUnidade = document.getElementById("unidade");
					if(comboEspecialidade.value != ""){
						comboUnidade.disabled = false;
					}else{
						comboUnidade.disabled = true;
					}
				});
				
				
				
				
				$('#especialidade').change(function(){
					SelecionaCombo(this, 'paciente', 'unidade');					
				});
					
				function SelecionaCombo(comboEspecialidade, comboPaciente, comboUnidade){
				
					comboUnidade = document.getElementById(comboUnidade);
					comboPaciente = document.getElementById(comboPaciente);
					LimparCombo(comboUnidade);
					
					if(comboEspecialidade.options[comboEspecialidade.selectedIndex].value != "" && comboPaciente.options[comboPaciente.selectedIndex].value != "" ){
					
						comboUnidade.disabled = true;
						
						$.ajax({
						
							url:'controller.do?command=ListarUnidadePlano',
							type:'get',
							datatype:'json',
						    data: {
						    	//especialidadeValor: comboEspecialidade.options[comboEspecialidade.selectedIndex].value,
						        pacienteValor: comboPaciente.options[comboPaciente.selectedIndex].value
						    },
							success: function(resultado){
								var myObject = eval('(' + resultado + ')');
								PreencheCombo(myObject, comboUnidade);
								comboEspecialidade.disabled = false;
								comboUnidade.disabled = false;						
							}
						
						});
						
					}
				
				}
				
				function LimparCombo(combo){
				
					while(combo.length > 0){
					
						combo.remove(combo.length-1);
					
					}
				
				}
				
				
				function PreencheCombo(json, combo){
				
					combo.options[0] = new Option('Selecione uma unidade','');
					for(var i = 0; i<json.length; i++){
					
						combo.options[combo.length] = new Option(json[i].nomeFantasia, json[i].codUnidade);
					
					}
				
				
				}
				
			});
			
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
				<h4><i class="icon-edit"></i>Agendamento</h4>
			</div>
			  
			<div class="row">
				<div class="col-sm-12">
					<section class="panel">
						<div class="panel-body">
						 
							<form id="formAgendamento" class="form-horizontal" method="post" data-validate="parsley">      
							
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Paciente</label>
									<div class="col-lg-6">
										<select id="paciente" class="input-sm inline form-control"  style="width:100%">
											<option value="">Selecione um paciente</option>
											<c:forEach var="to" items="${listaPaciente}">
												<option value="${to.codPaciente}">${to.nome}</option>
											</c:forEach>
										</select>
									</div>				  
								</div>
								
								
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Especialidade</label>
									<div class="col-lg-6">
										<select id="especialidade" disabled="true" class="input-sm inline form-control"  style="width:100%">
											<option value="">Selecione uma especialidade</option>
											<c:forEach var="to" items="${listaEspecialidade}">
												<option value="${to.codEspecialidade}">${to.especialidade}</option>
											</c:forEach>
										</select>
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Unidade</label>
									<div class="col-lg-6">
										<select id="unidade" disabled="true" class="input-sm inline form-control"  style="width:100%">
											<option value="">Selecione uma unidade</option>
										</select>
									</div>				  
								</div>

						
								<div class="form-group">
								  <div class="col-lg-9 col-lg-offset-3">                      
									<!-- <a href="ListarAdministrador.jsp" class="btn btn-white">Cancelar</a> -->
									<button name="command" type="submit" class="btn btn-primary">Cadastrar</button>
								  </div>
								</div>
								
							</form>				  
						</div>
					</section>
				</div>  
			</div>
		</section>
	</section>
	  
	<!-- Footer -->
	<c:import url="Footer.jsp" />
	
	<script>
		$( "#formAgendamento" ).submit(function( event ) {
			
			comboPaciente = document.getElementById("paciente");
			comboEspecialidade = document.getElementById("especialidade");
			comboUnidade = document.getElementById("unidade");
			
			formAction = document.getElementById("formAgendamento");
			
			if(comboPaciente.value != "" && comboEspecialidade.value != "" && comboUnidade.value != ""){
				formAction.action = "controller.do?command=AgendamentoCalendario&pacienteValor="+ comboPaciente.value +"&especialidadeValor="+comboEspecialidade.value+"&unidadeValor="+comboUnidade.value; 
			}else{
				alert("Tem combo vazio");
				event.preventDefault();
			}
		  
		  
		});
	</script>
	
	</body>

</html>