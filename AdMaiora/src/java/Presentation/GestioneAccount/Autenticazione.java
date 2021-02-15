/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.GestioneAccount;

import Application.GestioneAccount.ManagerUtente;
import Storage.GestioneDati.UtenteGenerico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author utente
 */
public class Autenticazione extends HttpServlet {

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
            out.println("<title>Servlet Autenticazione</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Autenticazione at " + request.getContextPath() + "</h1>");
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
        String username = request.getParameter("nomeUtente");
        String password = request.getParameter("parolaChiave");
        
        boolean controlloUsername = (null != username) && username.matches("[^'\\(\\)><\\[\\]\\x22,;|]{7,15}");
        boolean controlloPassword = (null != password) && password.matches("[^'\\x22]{7,15}");
        
        if(null != password) {
            boolean lpok = password.matches(".{7,15}");
            boolean lpfpok = controlloPassword;
            boolean fpok = password.matches("[^'\\x22]+");
            request.setAttribute("LPOK", lpok);
            request.setAttribute("FPOK", fpok);
            request.setAttribute("LPFPOK", lpfpok);
        }
        if(null != username) {
            boolean lpok = username.matches(".{7,15}");
            boolean lpfpok = controlloUsername;
            boolean fpok = username.matches("[^'\\(\\)><\\[\\]\\x22,;|]+");
            request.setAttribute("LUOK", lpok);
            request.setAttribute("FUOK", fpok);
            request.setAttribute("LUFUOK", lpfpok);
        }

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/LoginError.jsp");
        
        boolean authSuccess = false;
        
        if(controlloUsername && controlloPassword) {
            ManagerUtente managerUtente = new ManagerUtente();
            UtenteGenerico utente = managerUtente.login(username, password);
            if(null != utente) {
                HttpSession sessione = request.getSession(true);
                sessione.setAttribute("nomeUtente", utente.getUsername());
                sessione.setAttribute("ruolo", utente.getRuolo());
                sessione.setAttribute("postaElettronica", utente.getMail());
                authSuccess = true;
                dispatcher = this.getServletContext().getRequestDispatcher("/PaginaPersonale.jsp");
            }
        }
        
        request.setAttribute("UserRetreived", authSuccess);
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
