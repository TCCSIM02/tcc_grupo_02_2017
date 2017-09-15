<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
  <!-- header -->
	<header id="header" class="navbar">
    <ul class="nav navbar-nav navbar-avatar pull-right">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">            
          <span class="hidden-xs-only">André Luiz</span>
          <span class="thumb-small avatar inline"><img src="images/avatar.jpg" alt="Mika Sokeil" class="img-circle"></span>
          <b class="caret hidden-xs-only"></b>
        </a>
        <ul class="dropdown-menu">
          <li><a href="#">Configurações</a></li>
          <li><a href="#">Perfil</a></li>
          <li><a href="#"><span class="badge bg-danger pull-right">3</span>Notificações</a></li>
          <li class="divider"></li>
          <li><a href="docs.html">Ajuda</a></li>
          <li><a href="signin.html">Sair</a></li>
        </ul>
      </li>
    </ul>
    <a class="navbar-brand" href="#" style="font-family: 'Ubuntu', sans-serif;">TCC</a>
    <ul class="nav navbar-nav hidden-xs">
      <li class="dropdown shift" data-toggle="shift:appendTo" data-target=".nav-primary .nav">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-cog icon-xlarge visible-xs visible-xs-inline"></i>Configurações <b class="caret hidden-sm-only"></b></a>
      </li>
    </ul>
    <form class="navbar-form pull-left shift" action="" data-toggle="shift:appendTo" data-target=".nav-primary">
      <i class="icon-search text-muted"></i>
      <input type="text" class="input-sm form-control" placeholder="Pesquisar">
    </form>
	</header>
  <!-- / header -->