
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Carta</title>
    </head>
    <body>
        <%
            
            HttpSession ses=request.getSession();
            Administradores ad=(Administradores) ses.getAttribute("administrador");
            
                                                      
            %>                      
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
                    
                     
        <div class="container">                
            <h2 center>Hola Administrador <%=ad.getNombre()%></h2>
        </div>
        <center>  
            <div class="container">
             
            <table class="table table-striped" border="2">
                <tr class="text-center"><div>Menu Principal</div><tr>
                <tr> <td class="text-center"><a class="btn btn-success" href="Control?op=7">Lista de Pizzas</a></tr>  
                <tr><td class="text-center"><a class="btn btn-success" href="Control?op=8">Lista de Clientes</a></tr>
            </table> 
            </div>
            
        </center>
	                              
                                   
        
	<!-- Script de BOOTSTRAP-->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
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
                    © 2021 Pizza SanCarlos - Todos los derechos reservados. 
                    
                </div>
                <div class="col-lg-3">
                    <img src="img/numero.jpg" alt="..." height="80"  align="right">  
                </div
            </div>
        </footer>
</body>
</html>
