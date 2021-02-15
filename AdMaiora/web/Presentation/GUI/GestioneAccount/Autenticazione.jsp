<%-- 
    Document   : Autenticazione
    Created on : 25 gen 2021, 03:12:18
    Author     : Foudal Soffian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Login</title>
        <link rel="stylesheet" href="assets/tether/tether.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="assets/dropdown/css/style.css">
        <link rel="stylesheet" href="assets/formstyler/jquery.formstyler.css">
        <link rel="stylesheet" href="assets/formstyler/jquery.formstyler.theme.css">
        <link rel="stylesheet" href="assets/datepicker/jquery.datetimepicker.min.css">
        <link rel="stylesheet" href="assets/socicon/css/styles.css">
        <link rel="stylesheet" href="assets/theme/css/style.css">
        <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css">
        <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
    </head>
    <body>
        <section class="menu cid-s48OLK6784" once="menu" id="menu1-k">
            <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
                <div class="container">
                    <div class="navbar-brand">
                        <span class="navbar-logo">
                            <a href="HomePage.jsp">
                                <img src="assets/images/logoAdMaiora.png"" alt="Home" style="height: 8rem;">
                            </a>
                        </span>
                        <span class="navbar-caption-wrap"><a class="navbar-caption text-black display-7" href="HomePage.jsp">ADMaiora</a></span>
                    </div>
            
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true">
                            <li class="nav-item">
                                <a class="nav-link link text-black display-4" href=""></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </section>
        <section class="header2 cid-sn4bT96L7D mbr-parallax-background" id="header2-m">
            <div class="mbr-overlay" style="opacity: 0.8; background-color: rgb(255, 255, 255);">
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-lg-7">
                        <h1 class="mbr-section-title mbr-fonts-style mb-3 display-1"><strong>LOGIN</strong></h1>
                    </div>
                </div>
            </div>
        </section>
        <section style="padding-bottom: 13%;" class="form9 cid-sn4cvTF8hu" id="form9-n">
            <div class="mbr-overlay"></div>
            <div class="container-fluid">
                <div class="mbr-section-head">
                    <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                        <strong>Accedi al sistema AdMaiora</strong>
                        <strong><br></strong>
                    </h3>
                </div>
                <div class="row justify-content-center mt-4">
                    <div class="col-lg-8 mx-auto mbr-form">
                        <form id="formAut" action=" ${pageContext.request.contextPath}/Autenticazione" method="post" class="mbr-form form-with-styler mx-auto">
                            <div class="">
                                <div id="formAdvisor" data-form-alert-danger="" class="alert alert-danger col-12" style="display:none;" onclick="nascondi()">
                                    <p id="infoParametri"></p>
                                </div>
                            </div>
                            <div class="dragArea row">
                                <div class="col-lg-12">  
                                </div>
                                <div class="col-lg-4 col-md-12 col-sm-12 form-group" data-for="name">
                                    <input id="nomeUtente" type="text" name="nomeUtente" placeholder="Usernane" data-form-field="name" class="form-control" value="" id="name-form9-n" required pattern="[^'&()><\]\[\x22,;\|]{7,15}">
                                </div>
                                <div data-for="password" class="col-lg-4 col-md-12 col-sm-12 form-group">
                                    <input id="parolaChiave" type="password" name="parolaChiave" placeholder="Password" data-form-field="email" class="form-control" value="" id="email-form9-n" required pattern="[^'\x22]{7,15}">
                                </div>
                                <div class="col-lg-4 col-md-12 col-sm-12 mbr-section-btn align-center">
                                    <button type="button" class="btn btn-primary display-4" onclick="verificaInput()">Accedi</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <section style="background-color: #fff; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: none;">
            <a href="https://mobirise.site/j" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a>
            <p style="flex: 0 0 auto; margin:0; padding-right:1rem;"></p>
        </section>
        <script src="assets/web/assets/jquery/jquery.min.js"></script>
        <script src="assets/popper/popper.min.js"></script>
        <script src="assets/tether/tether.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/smoothscroll/smooth-scroll.js"></script>
        <script src="assets/dropdown/js/nav-dropdown.js"></script>
        <script src="assets/dropdown/js/navbar-dropdown.js"></script>
        <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
        <script src="assets/parallax/jarallax.min.js"></script>
        <script src="assets/formstyler/jquery.formstyler.js"></script>
        <script src="assets/formstyler/jquery.formstyler.min.js"></script>
        <script src="assets/datepicker/jquery.datetimepicker.full.js"></script>
        <script src="assets/theme/js/script.js"></script>
        <script src="jQuery/jquery-3.5.1.js"></script>
        <script>
            function verificaInput() {
                nascondi();
                
                var username = $("#nomeUtente").val();
                var password = $("#parolaChiave").val();
                
                var LU = false;
                var LP = false;
                var FU = false;
                var FP = false;
                
                var matchU = username.match("[^'\\(\\)><\\[\\]\\x22,;|]+");
                var matchP = password.match("[^'\"]+");
                
                if(username !== null && username.length > 6 && username.length < 16) LU = true;
                if(matchU!==null && username === matchU[0]) FU = true;
                if(password !== null && password.length > 6 && password.length < 16) LP = true;
                if(matchP!==null && password === matchP[0]) FP = true;
                
                if(LU === false) $("#infoParametri").append("<div id=\"LU\">Lunghezza Username non valida</div>");
                if(FU === false) $("#infoParametri").append("<div id=\"FU\">Formato Username non valido</div>");
                if(LP === false) $("#infoParametri").append("<div id=\"LP\">Lunghezza Password non valida</div>");
                if(FP === false) $("#infoParametri").append("<div id=\"FP\">Formato Password non valido</div>");
                
                if(LU === true && FU === true && LP === true && FP === true) {
                    $("#formAut").submit();
                } else {
                    $("#formAdvisor").css('display', 'block');
                }
            };
            
            function nascondi() {
                $("#formAdvisor").css('display', 'none');
                $("#formAdvisor").empty();
                $("#formAdvisor").append("<div>Informazioni sulla Compilazione:<br><br><p id=\"infoParametri\" align=\"left\" style=\"padding-left:30%;\"></p></div>");
            };
        </script>
    </body>
</html>
