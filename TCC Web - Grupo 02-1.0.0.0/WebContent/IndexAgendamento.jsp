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
	<link href='js/fullcalendar/fullcalendar.min.css' rel='stylesheet' />
	<link href='js/fullcalendar/fullcalendar.print.min.css' rel='stylesheet' media='print' />	
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
			 	<div id='external-events'>
					<div class='fc-event'>My Event 1</div>
					<div class='fc-event'>My Event 2</div>
					<div class='fc-event'>My Event 3</div>
					<div class='fc-event'>My Event 4</div>
					<div class='fc-event'>My Event 5</div>
					<p>
						<input type='checkbox' id='drop-remove' />
						<label for='drop-remove'>remove after drop</label>
					</p>
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
	<script src='js/fullcalendar/lib/moment.min.js'></script>
	<script src='js/fullcalendar/locale-all.js'></script>
	<!-- Sparkline Chart -->
	<script src="js/charts/sparkline/jquery.sparkline.min.js"></script>
	<!-- Easy Pie Chart -->
	<script src="js/charts/easypiechart/jquery.easy-pie-chart.js"></script>
	
	<!-- app -->
	<script src="js/app.js"></script>
	<script src="js/app.plugin.js"></script>
	<script src="js/app.data.js"></script>
	
	<script type="text/javascript">

		$(document).ready(function() {
	
			var initialLocaleCode = 'pt-br';
			
			/* initialize the external events
			-----------------------------------------------------------------*/
	
			$('#external-events .fc-event').each(function() {
	
				// store data so the calendar knows to render an event upon drop
				$(this).data('event', {
					title: $.trim($(this).text()), // use the element's text as the event title
					stick: true // maintain when user navigates (see docs on the renderEvent method)
				});
	
				// make the event draggable using jQuery UI
				$(this).draggable({
					zIndex: 999,
					revert: true,      // will cause the event to go back to its
					revertDuration: 0  //  original position after the drag
				});
	
			});
	
	
			/* initialize the calendar
			-----------------------------------------------------------------*/
	
			$('#fc-agendamento').fullCalendar({
					header: {
						left: 'prev,next today',
						center: 'title',
						right: 'month,agendaWeek,agendaDay'
					},
					editable: true,
					droppable: true, // this allows things to be dropped onto the calendar
					drop: function() {
						// is the "remove after drop" checkbox checked?
						if ($('#drop-remove').is(':checked')) {
							// if so, remove the element from the "Draggable Events" list
							$(this).remove();
						}
					}
				});
	
			// when the selected option changes, dynamically change the calendar option
			$('#locale-selector').on('change', function() {
				if (this.value) {
					$('fc-agendamento').fullCalendar('option', 'locale', initialLocaleCode);
				}
			});
	
		});
	
	</script>
	
</body>
</html>