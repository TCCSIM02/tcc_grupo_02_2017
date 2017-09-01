<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
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

  	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Paciente</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este paciente?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" id="id_excluir"/>
						<button type="submit" class="btn btn-primary" name="command" value="ExcluirPaciente">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	
	<!-- Header -->
	<c:import url="Header.jsp" />
	
	<!-- Menu de navega��o do Administrador -->
	<c:import url="MenuAdministrador.jsp" />
		
	<section id="content">
    <section class="main padder">
      
	  <div class="clearfix">
        <h4><i class="icon-table"></i>Pesquisar Pacientes</h4>
      </div>

      <div class="row">
        <div class="col-lg-12">
          <section class="panel">
            <header class="panel-heading">
				Pacientes
            </header>
            <div class="panel-body">
              <div class="row text-small">
                <div class="col-sm-4 m-b-mini">
                  <select class="input-sm inline form-control" style="width:130px">
                    <option value="0">Visualizar</option>
                    <option value="1">Alterar</option>
                    <option value="3">Exportar</option>
                  </select>
                  <button class="btn btn-sm btn-white">Aplicar</button>   
                  <a href="CriarPaciente.jsp" class="btn btn-sm btn-white">Cadastrar novo paciente</a>	     				  
                </div>
                
                
                <div class="col-sm-4 m-b-mini">
					<!-- para que a pesquisa fique l� no cano -->
                </div>
                
                
                <div class="col-sm-4">
                  <div class="input-group">
                    <input type="text" class="input-sm form-control" placeholder="Pesquisar" value="Paciente" >
                    <span class="input-group-btn">
                      <button class="btn btn-sm btn-white" type="button">Buscar</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
           
            <c:if test="${not empty lista}">
			<div id="list" class="row">

				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>N�mero do Conv�nio</th>
								<th>C�digo paciente</th>
								<th>Nome paciente</th>
								<th>CPF</th>
								<!-- <th>Data Nascimento</th>-->
								<th>Data Cadastro</th>
								<th>Email</th>
								<!-- <th>Estado C�vil</th>
								<th>Nacionalidade</th>
								<th>Endere�o</th>
								<th>N�mero</th>
								<th>CEP</th>
								<th>UF</th>
								<th>Cidade</th>
								<th>Pa�s</th>
								<th>Telefone Principal</th>
								<th>Telefone Opcional</th>
								<th>Celular</th>-->
								<th>Flag ativo</th> 
								<th class="actions">A��es</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="to" items="${lista}">
						
						<tr>
							<td>${to.numConvenio}</td>
							<td>${to.codPaciente}</td>
							<td>${to.nome}</td>
							<td>${to.cpf}</td>
							<!-- <td>${to.dataNascimento}</td>-->
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${to.dataCadastro}" /></td>
							<td>${to.email}</td>
							<!-- <td>${to.estadoCivil}</td>
							<td>${to.nacionalidade}</td>
							<td>${to.endereco}</td>
							<td>${to.numeroEndereco}</td>
							<td>${to.cep}</td>
							<td>${to.cidade}</td>
							<td>${to.uf}</td>
							<td>${to.pais}</td>
							<td>${to.tel1}</td>
							<td>${to.tel2}</td>
							<td>${to.cel}</td>-->
							<td>${to.flagAtivo}</td>
							
							   <td class="actions">
                                                <a class="btn btn-success btn-xs" href="controller.do?command=VisualizarPaciente&id=${to.codPaciente}">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="controller.do?command=EditarPaciente&id=${to.codPaciente}">Editar</a>
                                                <button id="btn${to.codPaciente}" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${to.codPaciente}">Excluir</button>
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- pagina��o ainda n�o foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Pr�ximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->
                    </div>
                </div>
                </c:if>
            <footer class="panel-footer">
              <div class="row">
				<div class="col-sm-4 text-center"></div>
                <div class="col-sm-3 text-center">
                  <small class="text-muted inline m-t-small m-b-small">mostrando 10-20 de 43 itens</small>
                </div>
                <div class="col-sm-5 text-right text-center-sm">                
                  <ul class="pagination pagination-small m-t-none m-b-none">
                    <li><a href="#"><i class="icon-chevron-left"></i></a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#"><i class="icon-chevron-right"></i></a></li>
                  </ul>
                </div>
              </div>
            </footer>
          </section>
        </div>
        
      </div>
    </section>
  </section>
  
  
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    $("#delete-modal").on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget); //botao que disparou a modal
        var recipient = button.data('cliente');
        $("#id_excluir").val(recipient);
    });
    </script>	
	
	
	<!-- Footer -->
	<c:import url="Footer.jsp" />
	
	
</body>
</html>