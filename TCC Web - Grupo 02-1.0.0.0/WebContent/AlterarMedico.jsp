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
				<h4><i class="icon-edit"></i>Alterar médicos</h4>
			</div>
		  
		  <div class="row">
			<div class="col-sm-12">
				<section class="panel">
					<div class="panel-body">
					 
						<form class="form-horizontal" action="controller.do" method="post" data-validate="parsley"> 

							<input type="hidden" name="codMedico" id="codMedico" value="${medicoTO.codMedico}" /> 
		
							<input type="hidden"  name="numUnidade" id="numUnidade" readonly="true" value="${medicoTO.codUnidade}">
							
							<div class="form-group">
								<label class="col-lg-3 control-label">CRM</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="crm" id="crm" required
									maxlength="20" placeholder="número do crm" size="16" value="${medicoTO.crm}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">CRO</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cro" id="cro" required
									maxlength="20" placeholder="número do cro" size="16" value="${medicoTO.cro}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Nome médico</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nome" id="nome" required
									maxlength="65" placeholder="nome do medico" size="16" value="${medicoTO.nome}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">CPF</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cpf" id="cpf" required
									maxlength="14" placeholder="cpf" size="16" value="${medicoTO.cpf}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Data Nascimento</label>
								<div class="col-lg-6">
									<input type="date" class="form-control" name="dataNascimento" id="dataNascimento" required
									maxlength="11" placeholder="data de nascimento" size="16" value="${medicoTO.dataNascimento}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Email</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="email" id="email" required
									maxlength="100" placeholder="email" size="16" value="${medicoTO.email}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Estado Cívil</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="estadoCivil" id="estadoCivil" 
									maxlength="20" placeholder="estado civil" size="16"  value="${medicoTO.estadoCivil}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Nacionalidade</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="nacionalidade" id="nacionalidade" required
									maxlength="35" placeholder="nacionalidade" size="16"  value="${medicoTO.nacionalidade}">
								</div>				  
							</div>
							

							<div class="form-group">
								<label class="col-lg-3 control-label">CEP</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cep" id="cep" required onblur="pesquisacep(this.value);"
									maxlength="9" placeholder="cep" size="16" value="${medicoTO.cep}">
								</div>				  
							</div>


							<div class="form-group">
								<label class="col-lg-3 control-label">Endereço</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="endereco" id="endereco" required
									maxlength="200" placeholder="endereco" size="16" readonly="true" value="${medicoTO.endereco}">
								</div>				  
							</div>

							<div class="form-group">
								<label class="col-lg-3 control-label">Cidade</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cidade" id="cidade" required
									maxlength="9" placeholder="cep" size="16" readonly="true" value="${medicoTO.cidade}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">País</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="pais" id="pais" required
									maxlength="20" placeholder="país" size="16" readonly="true" value="${medicoTO.pais}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">UF</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="uf" id="uf" required
									maxlength="2" placeholder="uf" size="16" readonly="true" value="${medicoTO.uf}">
								</div>				  
							</div>
							
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Número</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="numeroEndereco" id="numeroEndereco" required
									maxlength="200" placeholder="número" size="16" value="${medicoTO.numeroEndereco}">
								</div>				  
							</div>					
							
							
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Telefone Principal</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="tel1" id="tel1" required
									maxlength="16" placeholder="telefone principal" size="16"  value="${medicoTO.tel1}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Telefone Opcional</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="tel2" id="tel2" 
									maxlength="16" placeholder="telefone opcional" size="16"  value="${medicoTO.tel2}">
								</div>				  
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Celular</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="cel" id="cel" 
									maxlength="16" placeholder="telefone opcional" size="16" value="${medicoTO.cel}">
								</div>	
							</div>
							
							<div class="form-group">
								<label class="col-lg-3 control-label">Unidade</label>
								<div class="col-lg-6">
									<select id="codUnidade" name="codUnidade"  class="input-sm inline form-control" required  style="width:100%">
										<c:forEach var="to" items="${listaUnidade}">
											<option value="${to.codUnidade}">${to.nomeFantasia}</option>
										</c:forEach>
									</select>
								</div>				  
							</div>
								
							<div class="form-group">
							<label class="col-lg-3 control-label">Especialidade</label>
								<div class="col-lg-6">
									<c:forEach var="to" items="${listaEspecialidade}">
										<input type="checkbox" name="check" value="${to.codEspecialidade}">${to.especialidade}<br>
									</c:forEach>
								</div>				  
							</div>							

								
							<div class="form-group">
							  <div class="col-lg-9 col-lg-offset-3"> 
								<a href="ListarMedico.jsp" class="btn btn-white">Cancelar</a>
								<button name="command" value="AlterarMedico" type="submit" class="btn btn-primary">Salvar</button>
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
	
	<script type="text/javascript" >
		$(document).ready(
			function() { 
				var numUnidade = document.getElementById("numUnidade").value;
				
				comboUnidade = document.getElementById("codUnidade");
				
				for ( i =0; i < comboUnidade.length; i++){
					if (comboUnidade[i].value == numUnidade){
						comboUnidade[i].selected = true;	
					}									
				}
				
			
				
		});
	</script>
	
	
</body>
</html>