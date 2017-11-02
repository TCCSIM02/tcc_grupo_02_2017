<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    
    <%
       	String pagina="";	
		String nivelUsuario = "";
		
		try{
			pagina = request.getParameter("pagina");
			nivelUsuario = session.getAttribute("nivelUsuario").toString();			
		}catch(Exception e){
			e.printStackTrace();			
		}
		

	%>


  <!-- nav -->
  <nav id="nav" class="nav-primary hidden-xs nav-vertical">
    <ul class="nav" data-spy="affix" data-offset-top="50">
	
		<% if( nivelUsuario.equals("4")) {  %>
			<% if( pagina.equals("unidade")) {  %>
				<li class="active">		
			<% } else { %>
				<li class="dropdown-submenu">
			<% } %>
					<a href="controller.do?command=ListarUnidadeBuscar"><i class="icon-home icon-xlarge"></i><span>Unidades</span></a>
				</li>
		<% } %>
		
		<% if( nivelUsuario.equals("4")) {  %>
			<% if( pagina.equals("plano")) {  %>
			<li class="active">		
			<% } else { %>
			<li class="dropdown-submenu">
			<% } %>
				<a href="controller.do?command=ListarPlanoBuscar"><i class="icon-briefcase icon-xlarge"></i><span>Planos</span></a>
			</li>
		<% } %>    

		<% if( nivelUsuario.equals("4")) {  %>
			<% if( pagina.equals("funcionario")) {  %>
			<li class="dropdown-submenu active">		
			<% } else { %>
			<li class="dropdown-submenu">
			<% } %>
				<a href="#"><i class="icon-user icon-xlarge"></i><span>Funcionários</span></a>
				    <ul class="dropdown-menu">
			          <li><a href="controller.do?command=ListarMedicoBuscar">Médico</a></li>
			          <li><a href="controller.do?command=ListarAtendenteBuscar">Atendente</a></li>
			          <li><a href="controller.do?command=ListarAdministradorBuscar">Administrador</a></li>
			        </ul>
				<!--<a href="IndexFuncionarios.jsp"><i class="icon-user icon-xlarge"></i><span>Funcionários</span></a>-->
			</li>
		<% } %>
		
		<% if( pagina.equals("paciente")) {  %>
		<li class="active">		
		<% } else { %>
		<li class="dropdown-submenu">
		<% } %>
			<a href="controller.do?command=ListarPacienteBuscar"><i class="icon-user icon-xlarge"></i><span>Pacientes</span></a>
		</li>
		
		<% if( nivelUsuario.equals("1")) {  %>
			<% if( pagina.equals("consulta")) {  %>
			<li class="active">		
			<% } else { %>
			<li class="dropdown-submenu">
			<% } %>
				<a href="controller.do?command=ListarConsultasMedico"><i class="icon-user-md icon-xlarge"></i><span>Consulta</span></a>
			</li>
		 <% } %>
		 
		<% if( pagina.equals("agendamento")) {  %>
		<li class="active">		
		<% } else { %>
		<li class="dropdown-submenu">
		<% } %>
			<a href="controller.do?command=IndexAgendamento"><i class="icon-calendar icon-xlarge"></i><span>Agendamento</span></a>
		</li>
		  
		<!-- <% if( pagina.equals("exame")) {  %>
		<li class="active">		
		<% } else { %>
		<li class="dropdown-submenu">
		<% } %>
			<a href="controller.do?command=ListarExameBuscar"><i class="icon-file icon-xlarge"></i><span>Exame</span></a>
		</li>
		 -->
		
		  
		<!-- <% if( pagina.equals("receituario")) {  %>
		<li class="active">		
		<% } else { %>
		<li class="dropdown-submenu">
		<% } %>
			<a href="IndexReceituario.jsp"><i class="icon-edit icon-xlarge"></i><span>Receituário</span></a>
		</li>
		 -->
		  
    </ul>
  </nav>
  <!-- / nav -->