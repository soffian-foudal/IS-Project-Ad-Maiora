<%-- 
    Document   : VisualizzaDiscussione
    Created on : 26-gen-2021, 16.17.52
    Author     : Foudal Soffian
--%>

<%@page import="Storage.GestioneDati.Commento"%>
<%@page import="java.util.List"%>
<%@page import="Storage.GestioneDati.Discussione"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  int id;
    try {
        id = Integer.parseInt(request.getParameter("idDiscussione"));
    } catch(NumberFormatException nfe) {
        id = -1;
    }
    
    Discussione discussione = (Discussione) request.getAttribute("discussione");
    
    if(null == discussione) {
        response.sendRedirect("VisualizzaDiscussione?idDiscussione=" + id);
        return;
    }

    List<Commento> commenti = (List<Commento>) request.getAttribute("listaCommenti");
    
    String username = (String) session.getAttribute("nomeUtente");
    String mail = (String) session.getAttribute("postaElettronica");
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
        <title>Discussione</title>
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
        <%@ include file = "../Header.jsp" %>
        <section class="counters5 counters cid-sn8ditSOZC" id="counters5-10" style="padding-bottom: 9.6%!important;padding-top: 6%!important;">
            <div class="container pt-4 mt-2">
                <h2 class="mbr-section-title pb-3 align-center mbr-fonts-style display-1"><%=discussione.getNome()%></h2>
                <h3 class="mbr-section-subtitle pb-5 align-center mbr-fonts-style display-5"><%=discussione.getDescrizione()%></h3>
                <div class="row justify-content-center">
                    <div class="cards-block">
                        <div class="cards-container">
                            <div class="card px-3 align-left col-12">
                                <div class="panel-item p-4 d-flex">
                                    <div class="card-text">
                                        <h4 class="mbr-content-title mbr-bold mbr-fonts-style display-7">Creatore</h4>
                                        <p class="mbr-content-text mbr-fonts-style display-7"><%=(null == discussione.getMail())? "SISTEMA" : discussione.getMail()%></p>
                                    </div>
                                </div>
                            </div>
                            <div class="card px-3 align-left col-12">
                                <div class="panel-item p-4 d-flex">
                                    <div class="card-text">
                                        <h4 class="mbr-content-title mbr-bold mbr-fonts-style display-7">Sottocategoria</h4>
                                        <p class="mbr-content-text mbr-fonts-style display-7">
                                           <%=discussione.getSottocategoria()%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="timeline1 cid-sn88zSz9Od" id="timeline1-z" style="padding-top: 35px!important;">
            <div class="container align-center">
                <h2 style="padding-bottom: 10%!important;" class="mbr-section-title pb-3 mbr-fonts-style display-2">Post</h2>
                <div id="postLine" class="container timelines-container" mbri-timelines=""> 
                    <!-- per visualizzare un post a destra e uno a sinistra bisogna modificare il nome della classe 
                    in modo alternato, classe con reverse, post a sinistra, senza reverse post a destra
                    ho utilizzato il modulo della stessa variabile che uso per fare il ciclo
                    tu dovresti incrementare la variabile allinterno del foreach che userai per scorrere la lista
                    anche se penso che con te ste cose siano scontate-->
                    <%  String reverse = "";
                        for (int i = 0; i < commenti.size(); i++) {
                            if((i%2)==0){reverse = "reverse";}
                            else{reverse="";}
                    %>
                            <!--1-->
                            <div class="row timeline-element <%=reverse%> separline">
                                <span class="iconBackground"></span>
                                <div class="col-xs-12 col-md-6 align-right">
                                    <div class="timeline-text-content">
                                        <h4 class="mbr-timeline-title pb-3 mbr-fonts-style display-5"><%=commenti.get(i).getUtente().getMail()%></h4>
                                        <p class="mbr-timeline-text mbr-fonts-style display-7"><%=commenti.get(i).getCorpo()%></p>
                                    </div>
                                </div>
                            </div>
                    <%  }  %>
                </div>
            </div>
        </section>
        <%  if(isLogged && !("MODERATORE".equals(ruolo))) {%>        
                <section class="mbr-section form1 cid-sn8dssbbCB" id="form1-11" style="display:block!important;">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="title col-12 col-lg-8">
                                <h2 class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">Pubblica un post</h2>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="media-container-column col-lg-8">
                                    <div class="row">
                                        <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">
                                        </div>
                                    </div>
                                    <div class="dragArea row">
                                        <div data-for="message" class="col-md-12 form-group">
                                            <label for="message-form1-11" class="form-control-label mbr-fonts-style display-7">Message</label>
                                            <textarea name="corpo" data-form-field="Message" class="form-control display-7" id="message-form1-11" placeholder="Max 255 caratteri"></textarea> 
                                        </div>
                                        <input type="hidden" name="idDiscussione" value="<%=id%>">
                                        <input type="hidden" name="nomeUtente" value="<%=username%>">
                                        <div class="col-md-12 input-group-btn align-center">
                                            <button class="btn btn-primary btn-form display-4" onclick="pubblicazionePost()">INVIA POST</button>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                </section>
        <%  }%>
        <section style="background-color: #fff; display:none!important; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;">
            <a href="https://mobirise.site/r" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a>
            <p style="flex: 0 0 auto; margin:0; padding-right:1rem;">
                <a href="https://mobirise.site/d" style="color:#aaa;">The website</a>
                was made with Mobirise
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
        <script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
        <script src="assets/theme/js/script.js"></script>
        <script src="jQuery/jquery-3.5.1.js"></script>
        <script>
            var username = "<%=username%>";
            var mail = "<%=mail%>";
            var idDiscussione = "<%=id%>";
            var corpoPost;
            var reverse = "<%=reverse%>";
            function pubblicazionePost() {
                corpoPost = $("#message-form1-11").val();
                if(corpoPost.length <= 0 || corpoPost.length > 255) {
                    $("#message-form1-11").val("");
                    return;
                }
                $.ajax({
                    url: './PubblicazioneCommento',
                    type: 'POST',
                    data: jQuery.param({"corpo": corpoPost, "nomeUtente": username, "idDiscussione": idDiscussione}),
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    success: function (response) {
                        console.log(response);
                        reverse = reverse === "" ? reverse = "reverse" : reverse = "";
                        $("#postLine").append("\
                            <div class=\"row timeline-element " + reverse + " separline>" +
                                "<span class=\"iconBackground\"></span>" +
                                "<div class=\"col-xs-12 col-md-6 align-right\">" +
                                    "<div id=\"createdPost\" class=\"timeline-text-content\">" +
                                        "<h4 class=\"mbr-timeline-title pb-3 mbr-fonts-style display-5\">" + mail + "</h4>" +
                                        "<p class=\"mbr-timeline-text mbr-fonts-style display-7\">" + corpoPost + "</p>" +
                                    "</div>" +
                                "</div>" +
                            "</div>"
                        );
                        $("#form1-11").attr('style', 'display:none!important;');   
                    },
                    error: function () {
                        console.log("error");
                    },
                    async: true
                });
            }
        </script>
    </body>
</html>
