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
					<h4 class="modal-title" id="modalLabel">Excluir Consulta</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este consulta?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" id="id_excluir"/>
						<button type="submit" class="btn btn-primary" name="command" value="ExcluirConsulta">Sim</button>
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
	<c:import url="MenuAdministrador.jsp?pagina=consulta" />
		
	<section id="content">
    <section class="main padder">
      
	  <div class="clearfix">
        <h4><i class="icon-table"></i>Pesquisar Consultas</h4>
      </div>

      <div class="row">
        <div class="col-lg-12">
          <section class="panel">
            <header class="panel-heading">
				Consultas
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
                  <a href="CriarConsulta.jsp" class="btn btn-sm btn-white">Cadastrar novo consulta</a>	     				  
                </div>
                
                
                <div class="col-sm-4 m-b-mini">
					<!-- para que a pesquisa fique lá no cano -->
                </div>
                
                
                <div class="col-sm-4">
                  <div class="input-group">
                    <input type="text" class="input-sm form-control" placeholder="Pesquisar" value="Consulta" >
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
								<th>Código</th>
								<th>Status</th>
								<th>Diagnóstico</th>
								<th>Data inicio da consulta</th>
								<th>Data fim da consulta </th>
								<th>Valor da consulta</th>

								<th class="actions">Ações</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="to" items="${lista}">
						
						<tr>
							<td>${to.codConsulta}</td>
							<td>${to.statusConsulta}</td>
							<td>${to.diagnostico}</td>
							<td>${to.dataHoraConsultaInicio}</td>
							<td>${to.dataHoraConsultaFinal}</td>
							<td>${to.valorConsulta}</td>
							
							   <td class="actions">
                                                <a class="btn btn-success btn-xs" href="controller.do?command=VisualizarConsulta&id=${to.codConsulta}">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="controller.do?command=EditarConsulta&id=${to.codConsulta}">Editar</a>
                                                <button id="btn${to.codConsulta}" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${to.codConsulta}">Excluir</button>
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
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
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