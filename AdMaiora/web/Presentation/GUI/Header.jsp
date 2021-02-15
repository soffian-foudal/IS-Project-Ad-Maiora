<%-- 
    Document   : Header
    Created on : 26-gen-2021, 16.39.00
    Author     : Foudal Soffian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  String nomeUtente = (String) session.getAttribute("nomeUtente");
    boolean isLogged = null != nomeUtente? true : false;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="generator" content="Mobirise v5.2.0, mobirise.com">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
        <link rel="shortcut icon" href="assets/images/logoAdMaiora.png" type="image/x-icon">
        <meta name="description" content="">
        <title></title>
        <link rel="stylesheet" href="/assets/web/assets/mobirise-icons2/mobirise2.css">
        <link rel="stylesheet" href="/assets/tether/tether.min.css">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="/assets/dropdown/css/style.css">
        <link rel="stylesheet" href="/assets/socicon/css/styles.css">
        <link rel="stylesheet" href="/assets/theme/css/style.css">
        <link rel="preload" as="style" href="/assets/mobirise/css/mbr-additional.css">
        <link rel="stylesheet" href="/assets/mobirise/css/mbr-additional.css" type="text/css">
    </head>
    <body>
        <section class="menu cid-s48OLK6784" once="menu" id="menu1-o">
            <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
                <div class="container">
                    <div class="navbar-brand">
                        <span class="navbar-logo">
                            <a href="HomePage.jsp">
                                <img src="./assets/images/logoAdMaiora.png" alt="Home" style="height: 8rem;">
                            </a>
                        </span>
                        <span class="navbar-caption-wrap">
                            <a class="navbar-caption text-black display-7" href="HomePage.jsp">AdMaiora</a>
                        </span>
                    </div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <div class="hamburger">
                            <span></span>
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true">
                            <li class="nav-item">
                                <%  if(!isLogged) {%>
                                        <a class="nav-link link text-black text-primary display-4" href="Autenticazione.jsp">Accedi</a>
                                <%  } else {%>
                                        <a class="nav-link link text-black text-primary display-4" href="./LogoutDalSistema">Logout</a>
                                <%  }%>
                            </li>
                        </ul>
                        <div class="icons-menu" <% if(!isLogged) {%> style="display:none!important;"<%}%>>
                            <a class="iconfont-wrapper" href="PaginaPersonale.jsp">
                                <span class="p-2 mbr-iconfont mobi-mbri-user mobi-mbri"></span>
                            </a>
                        </div>
                    </div>
                </div>
            </nav>
        </section>
        <section style="background-color: #fff; display: none!important; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;">
            <a href="https://mobirise.site/y" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a>
            <p style="flex: 0 0 auto; margin:0; padding-right:1rem;">Mobirise free software - 
                <a href="https://mobirise.site/n" style="color:#aaa;">More here</a>
            </p>
        </section>
        <script src="assets/web/assets/jquery/jquery.min.js"></script>
        <script src="assets/popper/popper.min.js"></script>
        <script src="assets/tether/tether.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/smoothscroll/smooth-scroll.js"></script>
        <script src="assets/dropdown/js/nav-dropdown.js"></script>
        <script src="assets/dropdown/js/navbar-dropdown.js"></script>
        <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
        <script src="assets/theme/js/script.js"></script>  
    </body>
</html>
