<%-- 
    Document   : PaginaPersonale
    Created on : 23-gen-2021, 18.44.56
    Author     : Foudal Soffian
--%>

<%@page import="java.util.List"%>
<%@page import="Storage.GestioneDati.RichiestaCreazione"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  String username = (String) session.getAttribute("nomeUtente");
    String mail = (String) session.getAttribute("postaElettronica");
    String ruolo = (String) session.getAttribute("ruolo");
    
    List<RichiestaCreazione> richieste = (List<RichiestaCreazione>) request.getAttribute("listaRichieste");

    String nome = (String) request.getAttribute("nome");
    String cognome = (String) request.getAttribute("cognome");
    
    if(null == username || null == mail || null == ruolo) {
        response.sendRedirect("/Autenticazione.jsp");
        return;
    }
    
    if(null == nome || null == cognome) {
        response.sendRedirect("PaginaPersonale");
        return;
    }
    
    boolean mod = null != richieste? true : false;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="generator" content="Mobirise v5.2.0, mobirise.com">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
        <link rel="shortcut icon" href="assets/images/logoAdMaiora.png" type="image/x-icon">
        <meta name="description" content="">
        <title>Pagina Personale</title>
        <link rel="stylesheet" href="assets/web/assets/mobirise-icons2/mobirise2.css">
        <link rel="stylesheet" href="assets/tether/tether.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="assets/dropdown/css/style.css">
        <link rel="stylesheet" href="assets/datatables/data-tables.bootstrap4.min.css">
        <link rel="stylesheet" href="assets/socicon/css/styles.css">
        <link rel="stylesheet" href="assets/theme/css/style.css">
        <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css">
        <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
    </head>
    <body>
        <%@ include file = "../Header.jsp" %>
        <section class="services3 cid-sniXzEDlWv mbr-parallax-background" id="services3-1d" style="margin-top: 1.6%">
            <!--Overlay-->
            <div class="mbr-overlay" style="opacity: 0.3; background-color: rgb(255, 255, 255);">
            </div>
            <!--Container-->
            <div class="container">
                <div class="row">
                    <!--Titles-->
                    <div class="title pb-5 col-12" style="padding-top: 4%; padding-bottom: 9%!important;">
                        <h2 class="align-left mbr-fonts-style display-1">Bentornato, <%=ruolo.substring(0, 1).toUpperCase() + ruolo.substring(1).toLowerCase()%>!</h2>
                    </div>
                    <!--Card-1--><!--INIZIO LABEL USERNAME -->
                    <div class="card px-3 col-12 col-md-6" style="margin-bottom:3rem!important; height: 11rem;">
                        <div class="card-wrapper media-container-row media-container-row">
                            <div class="card-box">
                                <div class="top-line pb-1">
                                    <h4 class="card-title mbr-fonts-style display-5">Username</h4>
                                    <p class="mbr-text card-title cost mbr-fonts-style m-0 display-5">&nbsp; &nbsp; &nbsp; &nbsp;</p>
                                </div>
                                <div class="bottom-line">
                                    <p class="mbr-text mbr-fonts-style display-5"><%=username%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--FINE LABEL USERNAME -->
                    <!--Card-2--><!--INIZIO LABEL EMAIL -->
                    <div class="card px-3 col-12 col-md-6" style="margin-bottom:3rem!important; height: 11rem;">
                        <div class="card-wrapper media-container-row media-container-row">
                            <div class="card-box">
                                <div class="top-line pb-3">
                                    <h4 class="card-title mbr-fonts-style display-5">Email</h4>
                                    <p class="mbr-text card-title cost mbr-fonts-style m-0 display-5">&nbsp; &nbsp; &nbsp; &nbsp;</p>
                                </div>
                                <div class="bottom-line">
                                    <p class="mbr-text mbr-fonts-style display-7"><%=mail%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--FINE LABEL EMAIL -->
                    <!--Card-3--><!--INIZIO LABEL NAME -->
                    <div class="card px-3 col-12 col-md-6" style="margin-bottom:3rem!important; height: 11rem;">
                        <div class="card-wrapper media-container-row media-container-row">
                            <div class="card-box">
                                <div class="top-line pb-3">
                                    <h4 class="card-title mbr-fonts-style display-5">Nome</h4>
                                    <p class="mbr-text card-title cost mbr-fonts-style m-0 display-5">&nbsp; &nbsp; &nbsp; &nbsp;</p>
                                </div>
                                <div class="bottom-line">
                                    <p class="mbr-text mbr-fonts-style display-5"><%=nome%></p>
                                </div>
                            </div>
                        </div>
                    </div><!--FINE LABEL NAME -->
                    <!--Card-4--><!--INIZIO LABEL COGNOME -->
                    <div class="card px-3 col-12 col-md-6" style="margin-bottom:3rem!important; height: 11rem;">
                        <div class="card-wrapper media-container-row media-container-row">
                            <div class="card-box">
                                <div class="top-line pb-3">
                                    <h4 class="card-title mbr-fonts-style display-5">Cognome</h4>
                                    <p class="mbr-text card-title cost mbr-fonts-style m-0 display-5">&nbsp; &nbsp; &nbsp; &nbsp;</p>
                                </div>
                                <div class="bottom-line">
                                    <p class="mbr-text mbr-fonts-style display-5"><%=cognome%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--INIZIO LABEL COGNOME-->
                </div>
            </div>
        </section>
        <%  if(mod) {%>
                <section class="section-table cid-sniTgvkpiL" id="table1-1c" style="background: #da8888;border-style: solid; border-color: #e5e5e5">
                    <div class="container container-table">
                        <h2 class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">Richieste in sospeso</h2>
                        <div class="table-wrapper">
                            <div class="container">
                            </div>
                            <div class="container scroll">
                                <table class="table" cellspacing="0" data-empty="No matching records found">
                                    <thead>
                                        <tr class="table-heads ">
                                            <th class="head-item mbr-fonts-style display-7">Nome Creatore</th>
                                            <th class="head-item mbr-fonts-style display-7">Id Richiesta&nbsp;</th>
                                            <th class="head-item mbr-fonts-style display-7">Oggetto</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%  for (RichiestaCreazione r: richieste) {%>
                                            <tr onclick="location.href='VisualizzaRichiesta?idRichiesta=<%=r.getId()%>';" style="cursor: pointer;  position: relative; ">
                                                <td class="body-item mbr-fonts-style display-7"><%=r.getUtenteGenerico().getMail()%></td>
                                                <td class="body-item mbr-fonts-style display-7"><%=r.getId()%></td>
                                                <td class="body-item mbr-fonts-style display-7"><%=r.getOggetto()%></td>
                                            </tr>
                                    <%  } %>
                                    </tbody>
                                </table>
                            </div>
                            <div class="container table-info-container">
                            </div>
                        </div>
                    </div>
                </section>
        <%  }%>
        <section style="background-color: #fff; display:none!important; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;">
            <a href="https://mobirise.site/z" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a>
            <p style="flex: 0 0 auto; margin:0; padding-right:1rem;">Created with Mobirise - <a href="https://mobirise.site/l" style="color:#aaa;">Click now</a></p>
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
        <script src="assets/datatables/jquery.data-tables.min.js"></script>
        <script src="assets/datatables/data-tables.bootstrap4.min.js"></script>
        <script src="assets/theme/js/script.js"></script>
    </body>
</html>
