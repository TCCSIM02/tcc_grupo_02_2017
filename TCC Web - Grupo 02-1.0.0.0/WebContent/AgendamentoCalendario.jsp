<%@ page language="java" contentType="text/html; charset=UTF-8"
                pageEncoding="UTF-8"%>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
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
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="js/select2/select2.css" cache="false">
        <link rel="stylesheet" href="css/plugin.css">
        <link rel="stylesheet" href="css/font.css" cache="false">
        <link rel="stylesheet" href="css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
        
                       
        <a href="#" class="hide slide-nav-block" data-toggle="class:slide-nav slide-nav-left" data-target="body"></a>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://pages.mailmkt.netshoes.com.br/mask/"></script>
 
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
        <!-- Footer -->
 
        <script src="js/fuelux/fuelux.js"></script>
 
        <!-- fullcalendar -->
 
        <script src='js/fullcalendar/lib/moment.min.js'></script>
        <script src='js/fullcalendar/lib/jquery.min.js'></script>
        <script src='js/fullcalendar/lib/jquery-ui.min.js'></script>
        <script src="js/fullcalendar/fullcalendar.min.js" cache="false"></script>
        <script src='js/fullcalendar/locale-all.js'></script>
        
        
        
    </head>
<body>
    <!-- Header -->
    <c:import url="Header.jsp" />
 
    <!-- Menu de navegação do Administrador -->
    <c:import url="MenuAdministrador.jsp?pagina=agendamento" />
 
    <section id="content" class="content-sidebar bg-white"> <!-- .sidebar -->
    <aside class="sidebar bg-lighter padder clearfix">
 
    <h5>Arraste para um novo agendamento</h5>
    <div class="line"></div>
    <div id="external-events"
                   class="pillbox clearfix m-b no-border no-padder">
                   <ul>
                                   <li class="fc-event">Novo agendamento</li>
                   </ul>
    </div>
    <div class="line"></div>
    
    <p>Selecione o médico:</p>
    
    <select id="medico" class="input-sm inline form-control" style="width:130px">
                   <option value=""></option>
                   <c:forEach var="to" items="${listaMedico}">
                                   <option value="${to.codMedico}">${to.nome}</option>
                   </c:forEach>
    </select>
    
 
    </aside> <!-- /.sidebar --> <!-- .main --> <section class="main">
    <div class="" id="fc-agendamento"></div>
    
    </section> <!-- /.main --> </section>
 
    <!-- footer -->
    <footer id="footer">
    
    <div class="text-center padder clearfix">
                   <p>
                                   <small>&copy; TCC - Grupo 2</small><br> <br>
                   </p>
    </div>
    </footer>
    
 
 
    <script type="text/javascript">
 
        $(document).ready(
              function() {
 
                  var initialLocaleCode = 'pt-br';
 
                  /* initialize the external events
                  -----------------------------------------------------------------*/
 
                  $('#external-events .fc-event').each(function() {
 
                    // store data so the calendar knows to render an event upon drop
                    $(this).data('event', {
                                    title : $.trim($(this).text()), // use the element's text as the event title
                                    stick : true
                    // maintain when user navigates (see docs on the renderEvent method)
                    });
 
                    // make the event draggable using jQuery UI
                    $(this).draggable({
                                    zIndex : 999,
                                    revert : true, // will cause the event to go back to its
                                    revertDuration : 0
                    //  original position after the drag
                    });
 
                  });
 
                  /* initialize the calendar
                  -----------------------------------------------------------------*/
 
                  var jsonCalendario = ${jsonCalendario};
                  alert(jsonCalendario);
                  $('#fc-agendamento').fullCalendar(
                    {
                         header : {
                                         left : 'prev,next today',
                                         center : 'title',
                                         right : 'month'
                         },
                         eventClick : function(calEvent, jsEvent, view) {
                                         var dt = calEvent.start;
                                         var pEventDate = dt.format().substring(0, 10);
                                        
                                         window.open(
                                                                        'CriarAgendamento.jsp?eventDate='
                                                                                                        + pEventDate,
                                                                        "_self");
                         },
                         locale : initialLocaleCode,
                         editable : true,
                         droppable : true, // this allows things to be dropped onto the calendar
                         drop : function() {
                                         // is the "remove after drop" checkbox checked?
                                         if ($('#drop-remove').is(':checked')) {
                                                        // if so, remove the element from the "Draggable Events" list
                                                        $(this).remove();
                                         }
                         },
                         events : jsonCalendario
                    });
 
              });
             
             
              $('#medico').change( function(){
             
                comboMedico = document.getElementById("medico");
 
                var events = {
                    url: "controller.do?command=ListarMedicoAgenda",
                    type: 'POST',
                    data: {
                        medicoValor: comboMedico.options[comboMedico.selectedIndex].value
                    }
                  }
 
                  $('#fc-agendamento').fullCalendar( 'removeEventSource', events);
                  $('#fc-agendamento').fullCalendar( 'addEventSource', events);        
                  $('#fc-agendamento').fullCalendar( 'refetchEvents' );
              }).change();
             
    </script>
 
</body>
</html>