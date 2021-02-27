<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Sedes</title>
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

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <br>
        <section>
            <div class="local">
                <div class="col-lg-5" id="map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1094.9090731928384!2d-77.03772888137405!3d-12.056431666531426!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105c8c6c76e03e5%3A0x3e12ff686b901453!2sReal%20Plaza%20Centro%20C%C3%ADvico!5e0!3m2!1ses!2spe!4v1589190925875!5m2!1ses!2spe" 
                        width="560" height="550" frameborder="0" style="border:2;" 
                        allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                </div>
                <div class="col-lg-5">
                    <div class="card-title">
                        <h2><strong>Sede Centro</strong></h2>
                        </div>
                    <div class="local">
                        <h5 class="card-text">Direccion:&nbsp;&nbsp; Av. Inca Garcilaso de la Vega 1337<br>
                        Horario:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 11:00 - 21:00</h5>
                        </div>
                    <br>
                    <a href="#" class="btn btn-danger">Ubicacion</a>
                    <hr>
                <div class="card-title">
                        <h2><strong>Sede Surco</strong></h2>
                        </div>
                    <div class="local">
                        <h5 class="card-text">Direccion:&nbsp;&nbsp;Av. Ignacio Merino 2492<br>
                        Horario:&nbsp;&nbsp;&nbsp;&nbsp; 12:00 - 23:00</h5>
                        </div>
                    <br>
                    <a href="#" class="btn btn-danger">Ubicacion</a>
                        </div>
                </div>
            
            
        </section>
        <br>
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
                    © 2017 Mama Pizza - Todos los derechos reservados. By Webtilia
                    
                </div>
                <div class="col-lg-3">
                    <img src="img/numero.jpg" alt="..." height="80"  align="right">  
                </div
            </div>
        </footer>
</body>
</html>
