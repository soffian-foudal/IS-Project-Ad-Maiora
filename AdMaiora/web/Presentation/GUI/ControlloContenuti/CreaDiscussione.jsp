<%-- 
    Document   : CreaDiscussione
    Created on : 28-gen-2021, 22.46.28
    Author     : Foudal Soffian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  String username = (String) session.getAttribute("nomeUtente");
    if(null == username) {
        response.sendRedirect("./HomePage.jsp");
        return;
    }
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
        <title>Crea una Discussione!</title>
        <link rel="stylesheet" href="assets/web/assets/mobirise-icons2/mobirise2.css">
        <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css">
        <link rel="stylesheet" href="assets/tether/tether.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="assets/dropdown/css/style.css">
        <link rel="stylesheet" href="assets/socicon/css/styles.css">
        <link rel="stylesheet" href="assets/theme/css/style.css">
        <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css">
        <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
    </head>
    <body>
        <%@ include file = "../Header.jsp" %>
        <section class="header15 cid-sn8OY6Utv2 mbr-fullscreen mbr-parallax-background"  id="header15-13">
            <div class="mbr-overlay" style="opacity: 0.7; background-color: rgb(7, 59, 76);"></div>
            <div class="container align-right">
                <div class="row">
                    <div class="mbr-white col-lg-8 col-md-7 content-container">
                        <h1 class="mbr-section-title mbr-bold pb-3 mbr-fonts-style display-1">Crea il tuo thread</h1>
                        <div class="">
                            <div id="formAdvisor" data-form-alert-danger="" class="alert alert-danger col-12" style="display:none;" onclick="nascondi()">
                                <p id="infoParametri"></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-5">
                        <div class="form-container">
                            <div class="media-container-column">
                                <form id="formAut" action="${pageContext.request.contextPath}/CreaDiscussione" method="POST" class="mbr-form form-with-styler">
                                    <div class="row">
                                    </div>
                                    <div class="dragArea row">
                                        <div class="col-md-12 form-group " data-for="name">
                                            <input id="nome" type="text" name="nome" placeholder="Nome" data-form-field="Oggetto" required="required" pattern=".{1,127}" class="form-control px-3 display-7" id="name-header15-13">
                                        </div>
                                        <div class="col-md-12 form-group " data-for="name">
                                            <input id="oggetto" type="text" name="oggetto" placeholder="Oggetto" data-form-field="Oggetto" required="required" pattern=".{1,127}" class="form-control px-3 display-7" id="name-header15-13">
                                        </div>
                                        <div class="col-md-12 form-group " data-for="name">
                                            <input id="categoria" type="text" name="categoria" placeholder="Categoria" data-form-field="Categoria" required="required" pattern=".{1,50}" class="form-control px-3 display-7" id="email-header15-13">
                                        </div>
                                        <div data-for="phone" class="col-md-12 form-group ">
                                            <input id="sottocategoria" type="text" name="sottocategoria" placeholder="Sottocategoria" data-form-field="Sottocategoria" required pattern=".{1,50}" class="form-control px-3 display-7" id="phone-header15-13">
                                        </div>
                                        <div data-for="message" class="col-md-12 form-group ">
                                            <textarea id="descrizione" name="descrizione" placeholder="Descrizione" data-form-field="Message" required pattern=".{1,255}" class="form-control px-3 display-7" id="message-header15-13"></textarea>
                                        </div>
                                        <div class="col-md-12 input-group-btn">
                                            <button type="button" class="btn btn-secondary btn-form display-4" onclick="verificaInput()">INVIA RICHIESTA</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section style="background-color: #fff; display:none!important; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;">
            <a href="https://mobirise.site/f" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a>
            <p style="flex: 0 0 auto; margin:0; padding-right:1rem;">Created with Mobirise
                <a href="https://mobirise.site/j" style="color:#aaa;">website</a>
                builder
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
        <script src="assets/parallax/jarallax.min.js"></script>
        <script src="assets/theme/js/script.js"></script>
        <script src="jQuery/jquery-3.5.1.js"></script>
        <script>
            function verificaInput() {
                nascondi();
                
                var nome = $("#nome").val();
                var oggetto = $("#oggetto").val();
                var descrizione = $("#descrizione").val();
                var sottocategoria = $("#sottocategoria").val();
                var categoria = $("#categoria").val();
                
                var LN = false;
                var LO = false;
                var LD = false;
                var LS = false;
                var LC = false;
                
                if(nome!==null && nome.length>0 && nome.length<128) LN = true;
                if(oggetto!==null && oggetto.length>0 && oggetto.length<128) LO = true;
                if(descrizione!==null && descrizione.length>0 && descrizione.length<256) LD = true;
                if(sottocategoria!==null && sottocategoria.length>0 && sottocategoria.length<51) LS = true;
                if(categoria!==null && categoria.length>0 && categoria.length< 51) LC = true;
                
                if(LN === false) $("#infoParametri").append("<div id=\"LN\">Lunghezza Nome non valida</div>");
                if(LO === false) $("#infoParametri").append("<div id=\"LO\">Lunghezza Oggetto non valido</div>");
                if(LD === false) $("#infoParametri").append("<div id=\"LD\">Lunghezza Descrizione non valida</div>");
                if(LS === false) $("#infoParametri").append("<div id=\"LS\">Lunghezza Sottocategoria non valido</div>");
                if(LC === false) $("#infoParametri").append("<div id=\"LC\">Lunghezza Categoria non valido</div>");
                
                if(LN === true && LO === true && LD === true && LS === true && LC) {
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
