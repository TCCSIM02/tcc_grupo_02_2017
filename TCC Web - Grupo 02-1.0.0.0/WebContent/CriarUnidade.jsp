<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
               <meta charset="utf-8">
               <title>TCC - grupo 02 SI</title>
               <meta name="description" content="mobile first, app, web app, responsive, admin dashboard, flat, flat ui">
                <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">    
               
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
               <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                <script src="https://pages.mailmkt.netshoes.com.br/mask/"></script>
               
               
                <link rel="stylesheet" href="css/bootstrap.css">
                <link rel="stylesheet" href="css/font-awesome.min.css">
                <link rel="stylesheet" href="css/font.css">
                <link rel="stylesheet" href="css/style.css">
                <link rel="stylesheet" href="css/plugin.css">
                <link rel="stylesheet" href="css/landing.css">
                <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
 
                </head>
<body>
               
                <section id="content">
                              
                               <section class="main padder">
                              
                                               <div class="clearfix">
                                                               <h4><i class="icon-edit"></i>Cadastrar unidade</h4>
                                               </div>
                              
                                <div class="row">
                                               <div class="col-sm-12">
                                                               <section class="panel">
                                                                               <div class="panel-body">
                                                                              
                                                                                              <form class="form-horizontal" action="controller.do" method="post" data-validate="parsley">     
                                                                                             
                                                                                                              <div class="form-group">
                                                                                                                              <label class="col-lg-3 control-label">Celular</label>
                                                                                                                              <div class="col-lg-6">
                                                                                                                                              <input type="text" class="form-control" name="cel" id="cel"
                                                                                                                                              maxlength="15" placeholder="Celular" size="16">
                                                                                                                              </div>                                                  
                                                                                                              </div>
                                                                                                             
                                                                                                             
                                                                                                              <div class="form-group">
                                                                                                              <div class="col-lg-9 col-lg-offset-3">                     
                                                                                                                              <a href="ListarUnidade.jsp" class="btn btn-white">Cancelar</a>
                                                                                                                              <button name="command" value="CriarUnidade" type="submit" class="btn btn-primary">Cadastrar</button>
                                                                                                              </div>
                                                                                                              </div>
                                                                                                             
                                                                                              </form>                                                              
                                                                               </div>
                                                               </section>
                                               </div> 
                               </div>
                </section>
 
                <script>
                               <!-- Formata os campos -->
                               $(document).ready(function(){
                                               $('#tel1').mask('(00) 0000-0000');
                                               $('#tel2').mask('(00) 0000-0000');
                                               $('#cel').mask('(00) 0000-0000');
                               });
                </script>
               
               
               
</body>
 
</html>