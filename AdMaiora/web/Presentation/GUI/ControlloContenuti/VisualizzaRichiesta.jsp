<%-- 
    Document   : VisualizzaRichiesta
    Created on : 29-gen-2021, 16.11.43
    Author     : Foudal Soffian
--%>

<%@page import="Storage.GestioneDati.RichiestaCreazione"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  int id;
    try {
        id = Integer.parseInt(request.getParameter("idRichiesta"));
    } catch (NumberFormatException nfe) {
        id = -1;
    }
    RichiestaCreazione richiesta = (RichiestaCreazione) request.getAttribute("richiesta");
    
    if(null == richiesta) {
        response.sendRedirect("VisualizzaRichiesta?idRichiesta=" + id);
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
        <title>Visualizza Richiesta</title>
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
        <%@include file="../Header.jsp" %>
        <section class="counters5 counters cid-snoKJPePre visible" id="counters5-1e" style="background-color: #e5e5e5!important;padding-top: 4.5%;padding-bottom: 6%;">
            <div class="container pt-4 mt-2">
                <h2 class="mbr-section-title pb-3 align-center mbr-fonts-style display-2"><%=richiesta.getNome()%></h2>
                <h3 class="mbr-section-subtitle pb-5 align-center mbr-fonts-style display-5" style="color: #767676; font-weight: 300;"><%=richiesta.getOggetto()%></h3>
                <div class="row justify-content-center">
                    <div class="cards-block">
                        <div class="cards-container">
                            <hr>
                            <div class="card px-3 align-left col-12">
                                <div class="panel-item p-4 d-flex">
                                    <div class="card-text">
                                        <h4 class="mbr-content-title mbr-bold mbr-fonts-style display-7">Descrizione</h4>
                                        <p class="mbr-content-text mbr-fonts-style display-7"><%=richiesta.getDescrizione()%></p>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="card px-3 align-left col-12">
                                <div class="panel-item p-4 d-flex">
                                    <div class="card-text">
                                        <h4 class="mbr-content-title mbr-bold mbr-fonts-style display-7">Sottogategoria</h4>
                                        <p class="mbr-content-text mbr-fonts-style display-7"><%=richiesta.getSottocategoria()%></p>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="card px-3 align-left col-12">
                                <div class="panel-item p-4 d-flex">
                                    <div class="card-text">
                                        <h4 class="mbr-content-title mbr-bold mbr-fonts-style display-7">Categoria</h4>
                                        <p class="mbr-content-text mbr-fonts-style display-7"><%=richiesta.getCategoria()%></p>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="card px-3 align-left col-12">
                                <div class="panel-item p-4 d-flex">
                                    <div class="card-texts">
                                        <h4 class="mbr-content-title mbr-bold mbr-fonts-style display-7">Mail</h4>
                                        <p class="mbr-content-text mbr-fonts-style display-7"><%=richiesta.getUtenteGenerico().getMail()%></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="mbr-section form1 cid-snoKMyaxKN" id="form1-1f" style="padding-bottom: 2%;">
            <!---DIV LABEL ACCETTA--->
            <div class="container" style="margin-bottom: 1rem!important;">
                <div class="row justify-content-center">
                    <div class="title col-12 col-lg-8">
                        <h2 class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">Accetta la richiesta</h2>
                    </div>
                </div>
            </div>
            <!---DIV FORM ACCETTA--->
            <div class="container" style="margin-bottom: 3rem!important;">
                <div class="row justify-content-center">
                    <div class="media-container-column col-lg-8">
                        <!---Formbuilder Form--->
                        <form action="AccettaRichiesta?idRichiesta=<%=id%>" method="GET" class="mbr-form form-with-styler">
                            <div class="row">
                            </div>
                            <div class="dragArea row">
                                <div class="col-md-12 input-group-btn align-center">
                                    <input type="hidden" name="idRichiesta" value="<%=id%>">
                                    <button type="submit" class="btn btn-primary btn-form display-4" style="margin:auto!important;">ACCETTA RICHIESTA</button>
                                </div>
                            </div>
                        </form><!---Formbuilder Form--->
                    </div>
                </div>
            </div>
            <hr>
            <!---DIV LABEL RIFIUTA--->
            <div class="container" style="margin-top: 3rem!important;">
                <div class="row justify-content-center">
                    <div class="title col-12 col-lg-8">
                        <h2 class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">Rifiuta la richiesta</h2>
                        <h3 class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">Rifiuta la richiesta della creazione di un thread specificando una motivazione&nbsp;</h3>
                    </div>
                </div>
            </div>
            <!---DIV FORM RIFIUTA--->
            <div class="container">
                <div class="row justify-content-center">
                    <div class="media-container-column col-lg-8">
                    <!---Formbuilder Form--->
                        <form action="RifiutaRichiesta" method="GET" class="mbr-form form-with-styler">
                            <div class="row">
                                <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">
                                </div>
                            </div>
                            <div class="dragArea row">
                                <div data-for="message" class="col-md-12 form-group">
                                    <label for="message-form1-1f" class="form-control-label mbr-fonts-style display-7">Motivazione</label>
                                    <textarea name="motivazione" data-form-field="Message" class="form-control display-7" id="message-form1-1f"></textarea>
                                </div>
                                <div class="col-md-12 input-group-btn align-center">
                                    <input type="hidden" name="idRichiesta" value="<%=id%>">
                                    <button type="submit" class="btn btn-primary btn-form display-4" style="margin:auto!important;">RIFIUTA RICHIESTA</button>
                                </div>
                            </div>
                        </form><!---Formbuilder Form--->
                    </div>
                </div>
            </div>
        </section>
        <section style="background-color: #fff; display:none!important; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;">
            <a href="https://mobirise.site/h" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a>
            <p style="flex: 0 0 auto; margin:0; padding-right:1rem;">Created with Mobirise <a href="https://mobirise.site/u" style="color:#aaa;">web</a> theme</p>
        </section>
        <script src="assets/web/assets/jquery/jquery.min.js"></script>
        <script src="assets/popper/popper.min.js"></script>
        <script src="assets/tether/tether.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/smoothscroll/smooth-scroll.js"></script>
        <script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
        <script src="assets/theme/js/script.js"></script> 
    </body>
</html>
