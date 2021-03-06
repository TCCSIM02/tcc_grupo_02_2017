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
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
					<h4 class="modal-title" id="modalLabel">Excluir Unidade</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir esta unidade?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" id="id_excluir"/>
						<button type="submit" class="btn btn-primary" name="command" value="ExcluirUnidade">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	
	<!-- Header -->
	<c:import url="Header.jsp" />
	
	<!-- Menu de navegação do Administrador -->
	<c:import url="MenuAdministrador.jsp?pagina=unidade" />
		
	<section id="content">
    <section class="main padder">
      
	  <div class="clearfix">
        <h4><i class="icon-table"></i>Pesquisar Unidades</h4>
      </div>

      <div class="row">
        <div class="col-lg-12">
          <section class="panel">
            <header class="panel-heading">
				Unidades
            </header>
            <div class="panel-body">
              <div class="row text-small">
                <div class="col-sm-4 m-b-mini">
                  <a href="CriarUnidade.jsp" class="btn btn-sm btn-white">Cadastrar Unidade</a>	     				  
                </div>
                
                
                <div class="col-sm-4 m-b-mini">
					<!-- para que a pesquisa fique lá no cano -->
                </div>
                
                
				<form action="controller.do" method="post">
					<div class="col-sm-4">
						<div class="input-group">
							<input name="data[search]" id="search" class="input-sm form-control" placeholder="Pesquisar">
							<span class="input-group-btn">
								<button class="btn btn-sm btn-white" type="submit" name="command" value="ListarUnidadeBuscar">Buscar</button>
							</span>
						</div>
					</div>
				</form>
              </div>
            </div>
           
            <c:if test="${not empty lista}">
			<div id="list" class="row">

				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>Código</th>
								<th>Nome fantasia</th>
								<th>CNPJ</th>
								<th>CEP</th>
								<th>Cidade</th>
								<th>Telefone</th>

								<th class="actions">Ações</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="to" items="${lista}">
						
						<tr>
							<td>${to.codUnidade}</td>
							<td>${to.nomeFantasia}</td>
							<td>${to.cnpj}</td>
							<td>${to.cep}</td>
							<td>${to.cidade}</td>
							<td>${to.tel1}</td>
							
							   <td class="actions">
                                                <a class="btn btn-success btn-xs" href="controller.do?command=VisualizarUnidade&id=${to.codUnidade}">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="controller.do?command=EditarUnidade&id=${to.codUnidade}">Alterar</a>
                                                <button id="btn${to.codUnidade}" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${to.codUnidade}">Excluir</button>
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                </div>
                </c:if>
            <footer class="panel-footer">
              <div class="row">
				<div class="col-sm-4 text-center"></div>
                <div class="col-sm-3 text-center">
                </div>
                <div class="col-sm-5 text-right text-center-sm">                
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