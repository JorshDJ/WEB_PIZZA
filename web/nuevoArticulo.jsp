<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Pizza San Carlos | Administrador</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script type="text/javascript"></script>        <
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    </head>
    <body>
        <%
       
            String mensaje="";
            mensaje=(String)request.getAttribute("dato");
            ;
            
        %>
        <!--Cabecera Administrador-->
        <div class="container">
            <header>
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <div class="logo">PIZZA SAN CARLOS</div>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav" id="menu">
                            <li class="nav-item active" style="font-family: Showcard Gothic"><a class="nav-link" href="index.jsp">Inicio</a></li>                    
                    <li class="nav-item active" style="font-family: Showcard Gothic"><a class="nav-link" href="Control?op=1">Carta</a></li>
                    <li class="nav-item active" style="font-family: Showcard Gothic"><a class="nav-link" href="sedes.jsp">Sedes</a></li>
                    <li class="nav-item active" style="font-family: Showcard Gothic"><a class="nav-link" href="webgrafico1.jsp">Graficos </a></li>
                        </ul>
                    </div>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="img/pngwing.com.png" style="height:30px"/> 
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">                            
                            <a class="dropdown-item" href="Control?op=8">Salir</a>
                        </div>                        
                    </div>
                </nav>
            </header>
        </div>
        <br>
        <h2 class="text-center"> NUEVA  PIZZA </h2>
        <br>
        <div class="container">            
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">INGRESE TODOS LOS DATOS</div>
                        <div class="card-body">
                            
                            <!--
                            <form name="fr" class="form-horizontal" action="Sube" method="post" enctype="multipart/form-data">
                                <table>
                                    <tr><td><input type="file" class="form-control" name="file">
                                        <td><input type="submit" class="form-control" value="enviar" >
                                    <tr><td colspan="2"><%=mensaje%>
                                </table>
                            -->
                                
                            </form>
                            <form class="form-horizontal" action="Control" method="post">
                                <input type="hidden" name="op" value="11"> 
                                <div class="form-group">
                                    <label for="name" class="cols-sm-2 control-label">ID</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="idArt" placeholder="Ingresar ID" max="5" required/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="name" class="cols-sm-2 control-label">DESCRIPCIÓN</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="desArt" placeholder="Ingresar Descripción" required/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="name" class="cols-sm-2 control-label">INGRESAR PRECIO UNITARIO</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="preArt" placeholder="Ingresar Precio Unitario" required/>
                                        </div>
                                    </div>
                                </div> 
                                <div class="form-group">
                                    <label class="cols-sm-2 control-label">STOCK</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="stoArt" placeholder="Stock Existente" required/>
                                        </div>
                                    </div>
                                </div>     
                                <div class="form-group ">
                                    <input type="submit" class="btn btn-outline-secondary"  onclick="alert('Nueva Pizza Agregada')">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br> <br> 
    </body>
</html>
