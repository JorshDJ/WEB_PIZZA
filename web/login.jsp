<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <title>Home</title>
    </head>
    <body>
    <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="logo">PIZZA SAN CARLOS</div>
                <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active" style="font-family: Showcard Gothic"><a class="nav-link" href="index.jsp">Inicio</a></li>
                    
                    <li class="nav-item active" style="font-family: Showcard Gothic"><a class="nav-link" href="Control?op=1">Carta</a></li>
                    <li class="nav-item active" style="font-family: Showcard Gothic"><a class="nav-link" href="sedes.jsp">Sedes</a></li>
                    <li class="nav-item active" style="font-family: Showcard Gothic"><a class="nav-link" href="webgrafico1.jsp">Graficos </a></li>
                </ul>
                </div>
                
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     <img src="img/pngwing.com.png" style="height:30px"/> ${usuario.getNombre()}
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="login.jsp">Iniciar Sesion</a>              
                        <a class="dropdown-item" href="loginAdm.jsp">Administrador</a>
                        <a class="dropdown-item" href="#">Salir</a>
                    </div>
                    <button class="btn btn-secondary" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     <img src="img/carro.png" style="height:30px"/>
                    </button>
                </div>
           </nav>
        </header>
    <body>
        <% 
            String mensaje="";
            if (request.getAttribute("dato")!=null)
            mensaje=(String)request.getAttribute("dato");              
        %>
        
        
        
        <section>
            <div class="container-login">
            <div class="row">                
                <div class="col-lg-4 offset-lg-4">
                    <div class="card">
                        <div class="card-header">Iniciar Sesion</div>   
                            <div class="card-body">
                                
                                <form action="Control" method="POST" >
                                    <input type="hidden" name="op" value="5">
                                    <div class="form-group">
                                        <label for="">Numero de tarjeta</label>
                                        <input type="text" onkeyup="" class="form-control" name="tarjeta"  placeholder="Ingrese numero de tarjeta">
                                        <div id="mensaje" style="color:red;"></div>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Contraseña</label>
                                        <input type="password" class="form-control"  placeholder="Ingresar contraseña" name="contra">
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-block" value="login" name="accion">Iniciar Sesion</button>
                                    <div >
                                        <%=mensaje%>
                                    </div>
                                    
                                 </form> 
                                <a href="registro.jsp">Crear Cuenta</a>                     
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </section>
        <footer>
            <div class="container-footer">
                <div class="col-lg-3">
                    <img src="img/redes.jpg" alt="..." height="150">  
                </div>
                <div class="col-lg-6">
                    <a class="footer-class"  href="#">NOSOTROS</a> <a> | </a> 
                    <a class="footer-class"  href="#">CONTACTO</a> <a> | </a>
                    <a class="footer-class"  href="#">LIBRO DE RECLAMACIONES</a>
                    <br><br><br><br><br>
                    © 2021 Mama Pizza - Todos los derechos reservados.
                    
                </div>
                <div class="col-lg-3">
                    <img src="img/numero.jpg" alt="..." height="80"  align="right">  
                </div>
            </div>
        </footer>
    </body>
</html>
