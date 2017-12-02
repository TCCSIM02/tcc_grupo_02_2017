<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
  <!-- header -->
	<header id="header" class="navbar">
  
	<ul class="nav navbar-nav  pull-right">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">            
          <span class="hidden-xs-only">${nomeLogin}</span>
          <b class="caret hidden-xs-only"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="docs.html">Ajuda</a></li>
          <li class="divider"></li>
          
          <li><a href="controller.do?command=Logoff">Sair</a></li>
        </ul>
      </li>
    </ul>
	
    <img src="images/map_icon_cor.png" width="48" height="48" class="navbar-brand" href="Index.jsp">
    
    

	</header>
  <!-- / header -->