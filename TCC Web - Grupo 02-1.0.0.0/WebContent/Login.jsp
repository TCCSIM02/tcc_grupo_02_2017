<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
	
	<!-- Header -->
	<c:import url="HeaderLogin.jsp" />
	<!-- Header -->	
	
	<section id="content">
	    <div class="main padder">
	      <div class="row">
	        <div class="col-lg-4 col-lg-offset-4 m-t-large">
	          <section class="panel">
	            <header class="panel-heading text-center">
	              Logar
	            </header>
	            <form action="index.html" class="panel-body">
	              <div class="block">
	                <label class="control-label">Nome de usu�rio</label>
	                <input type="text" placeholder="TccDoc" class="form-control">
	              </div>
	              <div class="block">
	                <label class="control-label">Senha</label>
	                <input type="password" id="inputPassword" placeholder="Senha" class="form-control">
	              </div>
	              <div class="checkbox">
	                <label>
	                  <input type="checkbox"> Me manter logado
	                </label>
	              </div>
				  <a href="#" class="pull-right m-t-mini"><small>Esqueceu a senha?</small></a>
				  <button type="submit"  name="command" value="EfetuarLogin" class="btn btn-info">Logar</button>
				  
	            </form>
	          </section>
	        </div>
	      </div>
	    </div>
  	</section>

	<!-- Footer -->
	<c:import url="FooterLogin.jsp" />	
	<!-- Footer -->
	
</body>
</html>