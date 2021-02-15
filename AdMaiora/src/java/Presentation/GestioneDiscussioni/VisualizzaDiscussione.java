/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.GestioneDiscussioni;

import Application.GestioneDiscussioni.ManagerCommento;
import Application.GestioneDiscussioni.ManagerDiscussione;
import Storage.GestioneDati.Commento;
import Storage.GestioneDati.Discussione;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author utente
 */
public class VisualizzaDiscussione extends HttpServlet {

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
            out.println("<title>Servlet VisualizzaDiscussione</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VisualizzaDiscussione at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/HomePage.jsp");
        try {
            int id = Integer.parseInt(request.getParameter("idDiscussione"));
            if(id >= 0) {
                ManagerDiscussione managerDiscussione = new ManagerDiscussione();
                Discussione discussione = managerDiscussione.getById(String.valueOf(id));
                if(null != discussione) {
                    request.setAttribute("discussione", discussione);
                    ManagerCommento managerCommento = new ManagerCommento();
                    List<Commento> commenti = managerCommento.getPostDiscussione(discussione);
                    if(null != commenti)
                        request.setAttribute("listaCommenti", commenti);
                    dispatcher = this.getServletContext().getRequestDispatcher("/VisualizzaDiscussione.jsp");
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
