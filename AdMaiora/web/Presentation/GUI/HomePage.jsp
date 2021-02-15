<%-- 
    Document   : HomePage
    Created on : 23 gen 2021, 18:14:20
    Author     : Foudal Soffian
--%>

<%@page import="Storage.GestioneDati.Discussione"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  List<Discussione> discussioni = (List<Discussione>) request.getAttribute("discussioni");
    if(null == discussioni) {
        response.sendRedirect("CaricamentoDiscussioni");
        return;
    }
    String ruolo = (String) session.getAttribute("ruolo");
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
         <title>HomePage</title>
        <link rel="stylesheet" href="assets/web/assets/mobirise-icons2/mobirise2.css">
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
        <%@include file = "Header.jsp" %>
        <section class="header19 cid-sn4qU0PqOe mbr-fullscreen mbr-parallax-background" id="header19-p" style="margin-top: 2.2%!important;">
            <div class="container">
                <div class="media-container">
                    <div class="col-md-12 align-center">
                        <h1 class="mbr-section-title mbr-white mbr-bold mbr-fonts-style mb-3 display-1">BENVENUTO IN ADMAIORA</h1>
                        <p class="mbr-text mbr-white mbr-fonts-style display-7">Crea, rispondi o visualizza discussioni. A tuo piacimento</p>
                        <div class="mbr-section-btn align-center">
                            <a class="btn btn-primary display-4" href="AboutUs.jsp">INFO</a>
                        </div>
                        <div class="row justify-content-center">
                            <%  if(isLogged && !("MODERATORE".equals(ruolo))) {%>
                                    <div class="col-12 col-md-6 col-lg-3">                                
                                        <div class="card-wrapper">
                                            <div class="card-box align-center">
                                                <a href="CreaDiscussione.jsp">
                                                    <span class="mbr-iconfont mobi-mbri-plus mobi-mbri"></span>
                                                </a> 
                                                <h4 class="card-title align-center mbr-black mbr-fonts-style display-7">
                                                    <strong>Crea Thread</strong>
                                                </h4>
                                            </div>
                                        </div>
                                    </div>
                            <%  }%>
                            <div class="col-12 col-md-6 col-lg-3">
                                <div class="card-wrapper">
                                    <div class="card-box align-center">
                                        <a href="HomePage.jsp#content5-q">
                                            <span class="mbr-iconfont mobi-mbri-preview mobi-mbri"></span>
                                        </a>
                                        <h4 class="card-title align-center mbr-black mbr-fonts-style display-7">
                                            <strong>Visualizza Thread</strong>
                                        </h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section style="padding:5%"class="form8 cid-sn7zKKnaDJ" id="form8-v">
            <div class="container-fluid">
                <div class="mbr-section-head">
                    <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                        <strong>Cerca tra i Thread&nbsp;</strong>
                    </h3>
                    <h4 class="mbr-section-subtitle mbr-fonts-style align-center mb-0 mt-2 display-5">Inserisci il nome</h4>
                </div>
                <div class="row justify-content-center mt-4">
                    <div class="col-lg-8 mx-auto mbr-form">
                        <form id="ricercaForm" action="VisualizzaDiscussione" method="GET" class="mbr-form form-with-styler mx-auto">
                            <div class="">
                                <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">Oops...! some problem!</div>
                            </div>
                            <div style="padding-left: 25%" class="dragArea row">
                                <div class="col-lg-4 col-md-12 col-sm-12 form-group" data-for="name">
                                    <input id="searchBar" type="text" list="Suggestions" name="cerca" placeholder="Cerca Thread" required data-form-field="name" class="form-control" value="" id="name-form8-v">
                                    <input id="idDiscussione" name="idDiscussione" type="hidden" value="">
                                    <datalist id="Suggestions">
                                        <%  for(Discussione d: discussioni) {%>
                                                <option name="<%=d.getNome()%>" id="<%=d.getId()%>" class="listoption" value="<%=d.getNome()%>">
                                        <%  }%>
                                    </datalist>
                                </div>
                                <div class="col-lg-4 col-md-12 col-sm-12 mbr-section-btn align-center">
                                    <button type="button" class="btn btn-primary display-4" onclick="beforeSubmit()">
                                        <span class="mobi-mbri mobi-mbri-search mbr-iconfont mbr-iconfont-btn"></span>
                                        Cerca
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <section style="background-color: #ffe3e3; margin-bottom:4rem!important;" class="content5 cid-sn4sHRRoa2" id="content5-q">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-12 col-lg-10">
                        <h4 class="mbr-section-subtitle mbr-fonts-style mb-4 display-5">HEY</h4>
                        <p class="mbr-text mbr-fonts-style display-7">Utilizza un linguaggio consono alla community, ricorda che i professori ti guardano :)</p>
                    </div>
                </div>
            </div>
        </section>
        <%  for (Discussione d: discussioni) {%>
                <section class="content7 cid-sn4sJliiHq" id="content7-r" style="padding-top: 0rem!important; padding-bottom: 0rem!important;" >
                    <a href="VisualizzaDiscussione?idDiscussione=<%=d.getId()%>" style="color: inherit">
                        <div class="container" >
                            <div class="row justify-content-center">
                                <div class="col-12 col-md-10">
                                    <blockquote>
                                        <h5 class="mbr-section-title mbr-fonts-style mb-2 display-7">
                                            <strong><%=d.getSottocategoria() + ": " + d.getNome()%></strong>
                                        </h5>
                                        <p class="mbr-text mbr-fonts-style display-4"><%=d.getOggetto() + "\n" + d.getDescrizione()%></p>
                                    </blockquote>
                                </div>
                            </div>
                        </div>
                    </a> 
                </section>
         <% }  %>
         <section style="background-color: #fff; display:none!important; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;">
             <a href="https://mobirise.site/l" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a>
             <p style="flex: 0 0 auto; margin:0; padding-right:1rem;"> </p>
         </section>
         <script src="assets/web/assets/jquery/jquery.min.js"></script>
         <script src="assets/popper/popper.min.js"></script>
         <script src="assets/tether/tether.min.js"></script>
         <script src="assets/bootstrap/js/bootstrap.min.js"></script>
         <script src="assets/smoothscroll/smooth-scroll.js"></script>
         <script src="assets/dropdown/js/nav-dropdown.js"></script>
         <script src="assets/dropdown/js/navbar-dropdown.js"></script>
         <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
         <script src="assets/vimeoplayer/jquery.mb.vimeo_player.js"></script>
         <script src="assets/parallax/jarallax.min.js"></script>
         <script src="assets/theme/js/script.js"></script>
         <script src="jQuery/jquery-3.5.1.js"></script>
         <script>
            function beforeSubmit() {
                var indice;
                var l = $("#Suggestions option").length;
                for(var i = 0; i < l; i++)
                    if($("#Suggestions option")[i].value === $("#searchBar").val()){
                        indice = $("#Suggestions option")[i].id;
                        break;
                    }
                $("#idDiscussione").val(indice);
                $("#ricercaForm").submit();
            };
         </script>
    </body>
</html>
