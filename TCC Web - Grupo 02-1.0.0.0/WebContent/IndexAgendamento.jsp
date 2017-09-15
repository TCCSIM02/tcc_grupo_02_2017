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
	
	<!-- Header -->
	<c:import url="Header.jsp" />
	
	<!-- Menu de navegação do Administrador -->
	<c:import url="MenuAdministrador.jsp" />
	
	<section id="content" class="content-sidebar bg-white">
	    <!-- .sidebar -->
	    <aside class="sidebar bg-lighter padder clearfix">
	      <h5>Arraste para um novo agendamento</h5>
	      <div class="line"></div>
	      <div id="myEvents" class="pillbox clearfix m-b no-border no-padder">
	        <ul>
	          <li class="label bg-inverse">Novo agendamento</li>
	          <li class="label bg-success">Novo agendamento</li>
	          <li class="label bg-warning">Novo agendamento</li>
	          <li class="label bg-danger">Novo agendamento</li>
	          <li class="label bg-info">Novo agendamento</li>
	          <li class="label bg-primary">Novo agendamento</li>
	          <li class="label bg-default">Novo agendamento</li>
	        </ul>
	      </div>
	      <div class="line"></div>
	    </aside>
	    <!-- /.sidebar -->
	    <!-- .main -->
	    <section class="main">
	      <div class="" id="fc-agendamento">
			
	      </div>
	    </section>
	    <!-- /.main -->
	</section>	
	

	
	<!-- Footer -->
	<c:import url="Footer.jsp" />
	
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.js"></script>
	
	<script src="js/fuelux/fuelux.js"></script>
	<!-- fullcalendar -->
	<script src="js/jquery-ui-1.10.3.custom.min.js" cache="false"></script>
	<script src="js/jquery.ui.touch-punch.min.js" cache="false"></script>
	<script src="js/fullcalendar/fullcalendar.min.js" cache="false"></script>
	<!-- Sparkline Chart -->
	<script src="js/charts/sparkline/jquery.sparkline.min.js"></script>
	<!-- Easy Pie Chart -->
	<script src="js/charts/easypiechart/jquery.easy-pie-chart.js"></script>
	
	<!-- app -->
	<script src="js/app.js"></script>
	<script src="js/app.plugin.js"></script>
	<script src="js/app.data.js"></script>
	
	<script type="text/javascript">	
	    $('#fc-agendamento').fullCalendar({
	
	        dayClick: function(date, jsEvent, view) { 
	            alert('Clicked on: ' + date.getDate()+"/"+date.getMonth()+"/"+date.getFullYear());  
	        },
	
	    });
	</script>
	
</body>
</html>