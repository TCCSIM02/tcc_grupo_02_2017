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
		
		<script type="text/javascript" >

			function carregaData() {	
				alert("carregou");
			    var query = location.search.slice(1);
			    var partes = query.split('&');
			    var data = {};
			    partes.forEach(function (parte) {
			        var chaveValor = parte.split('=');
			        var chave = chaveValor[0];
			        var valor = chaveValor[1];
			        data[chave] = valor;
			    });
			    			
			    document.getElementById('dataInicio').value=(data["eventDate"]);
			}
	</script>
		
	</head>

	<body>

		<!-- Header -->
	<c:import url="Header.jsp" />

	<!-- Menu de navegação do Administrador -->
	<c:import url="MenuAdministrador.jsp" />

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
							
								<div class="form-group">
									<label class="col-lg-3 control-label">Selecione o paciente:</label>
										<div id="cb-medico" class="col-lg-6 input-group dropdown combobox m-b">
											<input class="input-sm form-control" name="combobox" type="text">
											<div class="input-group-btn">
												<button type="button" style="height: 30px; width: 30px"
													class="btn btn-sm btn-white dropdown-toggle" data-toggle="dropdown">
												</button>
												<ul class="dropdown-menu pull-right">
													<li data-value="1" data-selected="true"><a href="#">Item
															One</a></li>
													<li data-value="2"><a href="#">Item Two</a></li>
													<li data-value="3" data-fizz="buzz"><a href="#">Item Three</a></li>
													<li class="divider"></li>
													<li data-value="4"><a href="#">Item Four</a></li>
												</ul>
											</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Médico</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="medico" id="medico" required
										maxlength="200" placeholder="" size="16" readonly="true" value="">
									</div>				  
								</div>

								<div class="form-group">
									<label class="col-lg-3 control-label">Unidade</label>
									<div id="cb-medico" class="col-lg-6 input-group dropdown combobox m-b">
										<input class="input-sm form-control" name="combobox" type="text">
										<div class="input-group-btn">
											<button type="button" style="height: 30px; width: 30px"
												class="btn btn-sm btn-white dropdown-toggle" data-toggle="dropdown">
											</button>
											<ul class="dropdown-menu pull-right">
												<li data-value="1" data-selected="true"><a href="#">Mooca</a></li>
												<li data-value="2"><a href="#">Vergueiro</a></li>
												<li data-value="3" data-fizz="buzz"><a href="#">Itaquera</a></li>
											</ul>
									</div>
								</div>	
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Inicio</label>
									<div class="col-lg-4">
										<input type="date" class="form-control" name="dataInicio" id="dataInicio" required
										maxlength="11" placeholder="data de nascimento" size="16">
									</div>	
									<div class="col-lg-2">
										<input type="time" class="form-control" name="horaInicio" id="horaInicio" required
										maxlength="5" placeholder="data de nascimento" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Fim</label>
									<div class="col-lg-4">
										<input type="date" class="form-control" name="dataFim" id="dataFim" required 
										maxlength="11" placeholder="data de nascimento" size="16">
									</div>	
									<div class="col-lg-2">
										<input type="time" class="form-control" name="horaFim" id="horaFim" required
										maxlength="5" placeholder="data de nascimento" size="16">
									</div>				  
								</div>
								
								<div class="form-group">
									<label class="col-lg-3 control-label">Status</label>
									<div id="cb-medico" class="col-lg-6 input-group dropdown combobox m-b">
										<input class="input-sm form-control" name="combobox" type="text">
										<div class="input-group-btn">
											<button type="button" style="height: 30px; width: 30px"
												class="btn btn-sm btn-white dropdown-toggle" data-toggle="dropdown">
											</button>
											<ul class="dropdown-menu pull-right">
												<li data-value="1" data-selected="true"><a href="#">Agendada</a></li>
												<li data-value="2"><a href="#">Cancelada</a></li>
												<li data-value="3" data-fizz="buzz"><a href="#">Confirmada</a></li>
											</ul>
									</div>
								</div>	
								</div>				
						
								<div class="form-group">
								  <div class="col-lg-9 col-lg-offset-3">                      
									<a href="ListarAgendamento.jsp" class="btn btn-white">Cancelar</a>
									<button name="command" value="CriarAgendamento" type="submit" class="btn btn-primary">Cadastrar</button>
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
	
	<script type="text/javascript" >

		//window.onload = function() {
		/*$(document).ready(function() {	
			alert("carregou");
		    var query = location.search.slice(1);
		    var partes = query.split('&');
		    var data = {};
		    partes.forEach(function (parte) {
		        var chaveValor = parte.split('=');
		        var chave = chaveValor[0];
		        var valor = chaveValor[1];
		        data[chave] = valor;
		    });
		    			
		    document.getElementById('dataInicio').value=(data["eventDate"]);
		});*/
	</script>
    
	</body>

</html>