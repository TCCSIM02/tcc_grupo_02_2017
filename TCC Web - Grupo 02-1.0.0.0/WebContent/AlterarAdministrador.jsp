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
<body>
	
	<!-- Header -->
	<c:import url="Header.jsp" />
	
	<!-- Menu de navegação do Administrador -->
	<c:import url="MenuAdministrador.jsp?pagina=funcionario" />
	
	
	<section id="content">
		
		<section class="main padder">
		  
			<div class="clearfix">
				<h4><i class="icon-edit"></i>Alterar administradores</h4>
			</div>
		  
		  <div class="row">
			<div class="col-sm-12">
				<section class="panel">
					<div class="panel-body">
					 
						<form class="form-horizontal" action="controller.do" method="post" data-validate="parsley"> 

							<input type="hidden" name="codAdministrador" id="codAdministrador" value="${administradorTO.codAdministrador}" /> 
		

							<div class="form-group">
								<label class="col-lg-3 control-label">Nome</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nome" id="nome" required
									maxlength="65" placeholder="Nome" size="16" value="${administradorTO.nome}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">CPF</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cpf" id="cpf" required
									maxlength="14" placeholder="CPF" size="16" value="${administradorTO.cpf}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data de nascimento</label>
								<div class="col-lg-6">
									<input type="date" class="form-control" name="dataNascimento" id="dataNascimento" required
									maxlength="11" placeholder="Data de nascimento" size="16" value="${administradorTO.dataNascimento}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Email</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="email" id="email" required
									maxlength="100" placeholder="Email" size="16" value="${administradorTO.email}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Estado Civil</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="estadoCivil" id="estadoCivil" 
									maxlength="20" placeholder="Estado civil" size="16"  value="${administradorTO.estadoCivil}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Nacionalidade</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nacionalidade" id="nacionalidade" required
									maxlength="35" placeholder="Nacionalidade" size="16"  value="${administradorTO.nacionalidade}">
								</div>				  
							</div>
							

							<div class="form-group">
								<label class="col-lg-3 control-label">CEP</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cep" id="cep" required onblur="pesquisacep(this.value);"
									maxlength="9" placeholder="CEP" size="16" value="${administradorTO.cep}">
								</div>				  
							</div>


							<div class="form-group">
								<label class="col-lg-3 control-label">Endereço</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="endereco" id="endereco" required
									maxlength="200" placeholder="Endereço" size="16" readonly="true" value="${administradorTO.endereco}">
								</div>				  
							</div>

							<div class="form-group">
								<label class="col-lg-3 control-label">Cidade</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cidade" id="cidade" required
									maxlength="9" placeholder="Cidade" size="16" readonly="true" value="${administradorTO.cidade}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">País</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="pais" id="pais" required
									maxlength="20" placeholder="País" size="16" readonly="true" value="${administradorTO.pais}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">UF</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="uf" id="uf" required
									maxlength="2" placeholder="UF" size="16" readonly="true" value="${administradorTO.uf}">
								</div>				  
							</div>
							
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Número</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="numeroEndereco" id="numeroEndereco" required
									maxlength="200" placeholder="Número" size="16" value="${administradorTO.numeroEndereco}">
								</div>				  
							</div>					
							
							
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Telefone Principal</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="tel1" id="tel1" required
									maxlength="16" placeholder="Telefone principal" size="16"  value="${administradorTO.tel1}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Telefone Opcional</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="tel2" id="tel2" 
									maxlength="16" placeholder="Telefone opcional" size="16"  value="${administradorTO.tel2}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Celular</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cel" id="cel" 
									maxlength="16" placeholder="Celular" size="16" value="${administradorTO.cel}">
								</div>
							</div>			  
								
							<div class="form-group">
							  <div class="col-lg-9 col-lg-offset-3"> 
								<button name="command" value="AlterarAdministrador" type="submit" class="btn btn-primary">Salvar</button>
								<a href="ListarAdministrador.jsp" class="btn btn-white">Cancelar</a>								
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
				//$('#tel1').mask('(00) 00000-0000');
				//$('#tel2').mask('(00) 00000-0000');
				//$('#cel').mask('(00) 00000-0000');
				
				$('#cpf').mask('000.000.000-00');
				
				$('#tel1').mask('(00) 0000-00009');
				$('#tel1').blur(function(event) {
				   if($(this).val().length == 15){ // Celular com 9 dígitos + 2 dígitos DDD e 4 da máscara
					  $('#tel1').mask('(00) 00000-0009');
				   } else {
					  $('#tel1').mask('(00) 0000-00009');
				   }
				});
				
				$('#tel2').mask('(00) 0000-00009');
				$('#tel2').blur(function(event) {
				   if($(this).val().length == 15){ // Celular com 9 dígitos + 2 dígitos DDD e 4 da máscara
					  $('#tel2').mask('(00) 00000-0009');
				   } else {
					  $('#tel2').mask('(00) 0000-00009');
				   }
				});
				
				$('#cel').mask('(00) 0000-00009');
				$('#cel').blur(function(event) {
				   if($(this).val().length == 15){ // Celular com 9 dígitos + 2 dígitos DDD e 4 da máscara
					  $('#cel').mask('(00) 00000-0009');
				   } else {
					  $('#cel').mask('(00) 0000-00009');
				   }
				}); 
				
				$('#cnpj').mask('00.000.000/0000-00');
				$('#cep').mask('00000-000');			
			});
		</script>
	
	
</body>
</html>