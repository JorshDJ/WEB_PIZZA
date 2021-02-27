
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
            
            
            HttpSession ses = request.getSession();
            Articulos a = (Articulos) ses.getAttribute("dato");
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
	<br>
	<section>
          <h2 class="text-center"> MODIFICAR PIZZA <%=a.getIdArtic()%></h2>
        <div class="container">            
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">INGRESE LOS DATOS</div>
                        <div class="card-body">
                            <form class="form-horizontal" action="Control" method="post">
                                <input type="hidden" name="op" value="10"> 
                                <div class="form-group">
                                    <label for="name" class="cols-sm-2 control-label">DESCRIPCIÓN</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="desArt" id="name" placeholder="<%=a.getDescripArtic()%>" required=""/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="name" class="cols-sm-2 control-label">INGRESAR PRECIO UNITARIO</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="preArt" id="name" placeholder="<%=a.getPrecioUnitArtic()%>" required=""/>
                                        </div>
                                    </div>
                                </div>                               
                                <div class="form-group">
                                    <label class="cols-sm-2 control-label">INGRESA STOCK</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="stoArt" placeholder="<%=a.getStockArtic()%>" required=""/>
                                        </div>
                                    </div>
                                </div>                                
                                <div class="form-group ">
                                    <input type="submit" class="btn btn-outline-secondary"  onclick="alert('Registro Modificado')">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>            
         
		
                                    
		
                                    
	</section>
        
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
                    © 2021 Pizza SanCarlos - Todos los derechos reservados. By Webtilia
                    
                </div>
                <div class="col-lg-3">
                    <img src="img/numero.jpg" alt="..." height="80"  align="right">  
                </div
            </div>
        </footer>
</body>
</html>
