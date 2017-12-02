<%

	//String nomeLogin;

	//nomeLogin = session.getAttribute("nomeLogin").toString();	
	
	//System.out.println(session.toString());
	
	//if (session.){
		//request.getRequestDispatcher("Login.jsp").forward(request,response);  
	//	System.out.println("aaa");
	//}

%>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
		
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

	<!-- Header -->
	<c:import url="Header.jsp" />

	<!-- Menu de navegação do Administrador -->
	<c:import url="MenuAdministrador.jsp?pagina="/>

	<section id="content">
		
		<section class="main padder">
		  
			<div class="clearfix">
				<h4><i class="icon-edit"></i>Agendamento</h4>
			</div>
			 			
			Bem-vindo, ${nomeLogin} e ${nivelUsuario} 
			
			
				

		</section>
	</section>
	  
	<!-- Footer -->
	<c:import url="Footer.jsp" />

	
	</body>

</html>