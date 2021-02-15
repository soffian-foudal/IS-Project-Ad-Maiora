/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.ControlloContenuti;

import Application.ControlloContenuti.ManagerRichiesta;
import Storage.GestioneDati.RichiestaCreazione;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Servlet per la lettura di una richiesta di creazione, il metodo di 
 *  riferimento per l'operazione citata è il metodo <code>doGet</code>
 * 
 *  @author Davide Meriano
 *  @see    Storage.GestioneDati.RichiestaCreazione
 *  @see    Application.ControlloContenuti.ManagerRichiesta
 */
public class VisualizzaRichiesta extends HttpServlet {

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
            out.println("<title>Servlet VisualizzaRichiesta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VisualizzaRichiesta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Si occupa della coordinamento del flusso di operaizoni necessario
     * alla lettura di una richiesta di creazione.
     *
     *  @param request  richiesta alla servlet. Contiene i parametri necessari 
     *                  allo svolgimento dell'operazione di cui sopra: l'id di 
     *                  una Richiesta.
     *  @param response risposta della servlet
     *  @throws ServletException nel caso di errori servlet-specific
     *  @throws IOException nel caso di errori di I/O
     *  @see    Storage.GestioneDati.RichiestaCreazione
     *  @see    Application.ControlloContenuti.ManagerRichiesta
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaPersonale.jsp");
        try {
            int id = Integer.parseInt(request.getParameter("idRichiesta"));
            if(id >= 0) {
                ManagerRichiesta managerRichiesta = new ManagerRichiesta();
                RichiestaCreazione richiesta = managerRichiesta.getById(String.valueOf(id));
                if(null != richiesta) {
                    request.setAttribute("richiesta", richiesta);
                    dispatcher = this.getServletContext().getRequestDispatcher("/VisualizzaRichiesta.jsp?id=" + id);
                }
            }
        } catch(NumberFormatException nfe) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "{0}@doGet: {1} has been caught...", new String[]{getClass().getName(), nfe.getClass().getName()});
        } finally {
            dispatcher.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
