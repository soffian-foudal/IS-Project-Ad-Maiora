/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.GestioneDiscussioni;

import Application.GestioneAccount.ManagerUtente;
import Application.GestioneDiscussioni.ManagerCommento;
import Application.GestioneDiscussioni.ManagerDiscussione;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author utente
 */
public class PubblicazioneCommento extends HttpServlet {

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
            out.println("<title>Servlet PubblicazioneCommento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PubblicazioneCommento at " + request.getContextPath() + "</h1>");
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
        HttpSession sessione = request.getSession(false);
        
        String username = (String) sessione.getAttribute("nomeUtente");
        
        String idDiscussione = request.getParameter("idDiscussione");
        String corpo = request.getParameter("corpo");
        
        boolean controlloCorpo = false;
        if(null != corpo) {
            boolean aboveMin = (corpo.length() > 0);
            boolean belowMax = (corpo.length() < 256); 
            controlloCorpo = aboveMin && belowMax;
        } 
        
        if(controlloCorpo) {
            ManagerUtente managerUtente = new ManagerUtente();
            ManagerCommento managerCommento = new ManagerCommento();
            ManagerDiscussione managerDiscussione = new ManagerDiscussione();
        
            managerCommento.pubblica(corpo, managerUtente.getById(username), managerDiscussione.getById(idDiscussione));
        }
        
        request.setAttribute("LCOK", controlloCorpo);
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
