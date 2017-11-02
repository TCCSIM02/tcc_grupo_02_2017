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

		<script src="http://maps.google.com/maps/api/js?key=AIzaSyC5QVUfaP-vdozeOswmtg7cHzapzkrSfG8"></script>
		
		<!-- Adicionando Javascript -->
		<script type="text/javascript" >

			function limpa_formulário_cep() {
					//Limpa valores do formulário de cep.
					document.getElementById('endereco').value=("");
					document.getElementById('cidade').value=("");
					document.getElementById('uf').value=("");
					document.getElementById('pais').value=("");
			}

			function meu_callback(conteudo) {
				if (!("erro" in conteudo)) {
					//Atualiza os campos com os valores.
					document.getElementById('endereco').value=(conteudo.logradouro);
					document.getElementById('cidade').value=(conteudo.localidade);
					document.getElementById('uf').value=(conteudo.uf);
					document.getElementById('pais').value="Brasil";
					
					//----------------------- LAT E LONG ---------------------				
					var lat = '';
					var lng = '';
					var numeroEndereco = document.getElementById('numeroEndereco').value;
					var endereco = document.getElementById('endereco').value=(conteudo.logradouro);
					var address = endereco+" "+numeroEndereco;
					var geocoder= new google.maps.Geocoder();
					geocoder.geocode( { 'address': address}, function(results, status) {
					  if (status == google.maps.GeocoderStatus.OK) {
						 lat = results[0].geometry.location.lat();
						 lng = results[0].geometry.location.lng();
						 
						 document.getElementById('latitude').value = lat;
						 document.getElementById('longitude').value = lng;					 
						 
					  } else {
						 alert("Não foi possivel obter localização: " + status);
					  }
					});	
					
					//----------------------- CEP ---------------------
						
					
				} //end if.
				else {
					//CEP não Encontrado.
					limpa_formulário_cep();
					alert("CEP não encontrado.");
				}
			}
				
			function pesquisacep(valor) {


				//Nova variável "cep" somente com dígitos.
				var cep = valor.replace(/\D/g, '');

				//Verifica se campo cep possui valor informado.
				if (cep != "") {

					//Expressão regular para validar o CEP.
					var validacep = /^[0-9]{8}$/;

					//Valida o formato do CEP.
					if(validacep.test(cep)) {

						//Preenche os campos com "..." enquanto consulta webservice.
						document.getElementById('endereco').value="...";
						document.getElementById('cidade').value="...";
						document.getElementById('uf').value="...";
						document.getElementById('pais').value="...";

						//Cria um elemento javascript.
						var script = document.createElement('script');

						//Sincroniza com o callback.
						script.src = '//viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

						//Insere script no documento e carrega o conteúdo.
						document.body.appendChild(script);
						
				
					} //end if.
					else {
						//cep é inválido.
						limpa_formulário_cep();
						alert("Formato de CEP inválido.");
					}
				} //end if.
				else {
					//cep sem valor, limpa formulário.
					limpa_formulário_cep();
				}
				
			};

		</script>
	</head>
	
	<!-- Header -->
	<c:import url="Header.jsp" />
	
	<!-- Menu de navegação do Administrador -->
	<c:import url="MenuAdministrador.jsp?pagina=unidade" />
	
	<body>
		
		<section id="content">
			
			<section class="main padder">
			  
				<div class="clearfix">
					<h4><i class="icon-edit"></i>Cadastrar Unidade</h4>
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
										<label class="col-lg-3 control-label">Número</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="numeroEndereco" id="numeroEndereco" 
											maxlength="200" placeholder="Número" size="16">
										</div>				  
									</div>
									
									<div class="form-group">
										<label class="col-lg-3 control-label">CEP</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="cep" id="cep" required onblur="pesquisacep(this.value);"
											maxlength="9" placeholder="Cep" size="16">
										</div>				  
									</div>
									
									<div class="form-group">
										<label class="col-lg-3 control-label">Endereço</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="endereco" id="endereco" required
											maxlength="200" placeholder="Endereço" size="16" readonly="true">
										</div>				  
									</div>

									<div class="form-group">
										<label class="col-lg-3 control-label">Cidade</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="cidade" id="cidade" required
											maxlength="9" placeholder="CEP" size="16" readonly="true">
										</div>				  
									</div>
									
									<div class="form-group">
										<label class="col-lg-3 control-label">UF</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="uf" id="uf" required
											maxlength="2" placeholder="UF" size="16" readonly="true">
										</div>				  
									</div>
									
									<div class="form-group">
										<label class="col-lg-3 control-label">País</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="pais" id="pais" required
											maxlength="20" placeholder="País" size="16" readonly="true">
										</div>				  
									</div>									
									
									<input type="hidden" name="latitude" id="latitude">									
				
									<input type="hidden" name="longitude" id="longitude">
									
									<div class="form-group">
										<label class="col-lg-3 control-label">Representante</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="representante" id="representante" required
											maxlength="45" placeholder="Representante" size="16">
										</div>				  
									</div>
									
									<div class="form-group">
										<label class="col-lg-3 control-label">Telefone principal</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="tel1" id="tel1" required
											maxlength="16" placeholder="Telefone principal" size="16">
										</div>				  
									</div>
									
									<div class="form-group">
										<label class="col-lg-3 control-label">Telefone opcional</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="tel2" id="tel2" 
											maxlength="16" placeholder="Telefone opcional" size="16">
										</div>				  
									</div>
									
									<div class="form-group">
										<label class="col-lg-3 control-label">Celular</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="cel" id="cel" 
											maxlength="16" placeholder="Celular" size="16">
										</div>				  
									</div>
				
									<div class="form-group">
									  <div class="col-lg-9 col-lg-offset-3">                      
									  	<button name="command" value="CriarUnidade" type="submit" class="btn btn-primary">Cadastrar</button>
										<a href="ListarUnidade.jsp" class="btn btn-white">Cancelar</a>										
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
        <!-- Formata os campos -->
        $(document).ready(function(){
        	$('#tel1').mask('(00) 00000-0000');
        	$('#tel2').mask('(00) 00000-0000');
        	$('#cel').mask('(00) 00000-0000');
			$('#cnpj').mask('00.000.000/0000-00');
			$('#cep').mask('00000-000');			
        });
    </script>


	
</body>
 
</html>