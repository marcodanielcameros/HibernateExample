<%-- 
    Document   : index
    Created on : 06-nov-2017, 17:13:30
    Author     : marcocameros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

        
        <!-- Website CSS style -->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!-- Google Fonts -->
        <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
                
        <script src="js/popper.js "></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>

    </head>
    <body>
        <div class="container">
            <div class="row main" id="idSuperGenial">
                <div class="panel-heading">
                    <div class="panel-title text-center">
                        <h1 class="title">RIGORETO</h1>
                        <hr />
                    </div>
                </div> 
                <div class="main-login main-center">
                    <form class="form-horizontal" method="post" action="Login">

                        <div class="form-group">
                            <label for="name" class="cols-sm-2 control-label">Nombre</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="nombre" id="name"  placeholder="Escribe tu nombre"/>
                                    <input type="hidden" class="form-control" name="forma" value="login"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">Telefono</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="telefono" id="password"  placeholder="Escribe tu Telefono"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group ">
                            <!--<button type="button" class="btn btn-primary btn-lg btn-block login-button">Register</button>-->
                            <input class="btn btn-primary btn-lg btn-block login-button" type="submit" name="Envia">
                        </div>
                        <div class="login-register">
                            <a href="registro.jsp">Register</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
