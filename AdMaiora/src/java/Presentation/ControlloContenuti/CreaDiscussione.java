/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.ControlloContenuti;

import Application.ControlloContenuti.ManagerRichiesta;
import Application.GestioneAccount.ManagerUtente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Servlet per la creazione di una richiesta di creazione, il metodo di 
 *  riferimento per l'operazione citata è il metodo <code>doPost</code>.
 * 
 *  @author Davide Meriano
 *  @see    Application.ControlloContenuti.ManagerRichiesta
 */
public class CreaDiscussione extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreaDiscussione</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreaDiscussione at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Si occupa della coordinamento del flusso di operaizoni necessario
     * alla creazione di una richiesta di creazione, relativa ad una
     * discussione.
     *
     *  @param request  richiesta alla servlet. Contiene i parametri necessari 
     *                  allo svolgimento dell'operazione di cui sopra: il nome, 
     *                  l'oggetto, la descrizione, la sottocategoria, la 
     *                  categoria e l'username dell'utente che ha sottoposto la
     *                  richiesta.
     *  @param response risposta della servlet
     *  @throws ServletException nel caso di errori servlet-specific
     *  @throws IOException nel caso di errori di I/O
     *  @see    Storage.GestioneDati.RichiestaCreazione
     *  @see    Application.ControlloContenuti.ManagerRichiesta
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String oggetto = request.getParameter("oggetto");
        String descrizione = request.getParameter("descrizione");
        String sottocategoria = request.getParameter("sottocategoria");
        String categoria = request.getParameter("categoria");
        String username = (String) request.getSession(false).getAttribute("nomeUtente");
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/HomePage.jsp");
        
        boolean controlloNome = false;
        boolean controlloOggetto = false;
        boolean controlloDescrizione = false;
        boolean controlloSottocategoria = false;
        boolean controlloCategoria = false;
        
        
        if(null!=nome) {
            boolean aboveMin = (nome.length() > 0);
            boolean belowMax = (nome.length() < 128); 
            controlloNome = aboveMin && belowMax;
        }
        if(null!=oggetto) {
            boolean aboveMin = (oggetto.length() > 0);
            boolean belowMax = (oggetto.length() < 128); 
            controlloOggetto = aboveMin && belowMax;
        }
        if(null!=descrizione) {
            boolean aboveMin = (descrizione.length() > 0);
            boolean belowMax = (descrizione.length() < 256); 
            controlloDescrizione = aboveMin && belowMax;
        }
        
        if(null!=sottocategoria) {
            boolean aboveMin = (sottocategoria.length() > 0);
            boolean belowMax = (sottocategoria.length() < 51); 
            controlloSottocategoria = aboveMin && belowMax;
        }
        
        if(null!=categoria) {
            boolean aboveMin = (categoria.length() > 0);
            boolean belowMax = (categoria.length() < 51); 
            controlloCategoria = aboveMin && belowMax;
        }
        
        request.setAttribute("LNOK", controlloNome);
        request.setAttribute("LOOK", controlloOggetto);
        request.setAttribute("LDOK", controlloDescrizione);
        request.setAttribute("LSOK", controlloSottocategoria);
        request.setAttribute("LCOK", controlloCategoria);
        
        if(controlloNome && controlloOggetto && controlloDescrizione && 
                controlloDescrizione && controlloSottocategoria && controlloCategoria) {
            ManagerRichiesta managerRichiesta = new ManagerRichiesta();
            ManagerUtente managerUtente = new ManagerUtente();
            managerRichiesta.create(nome, oggetto, descrizione, sottocategoria, categoria, managerUtente.getById(username));
        }
        
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
