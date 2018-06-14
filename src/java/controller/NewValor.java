/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.FoodEJB;
import entities.Dish;
import entities.Rate;
import static entities.Rate_.date;
import entities.Restaurant;
import entities.User;
import exceptions.Eeeeerroooorr;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author daw2
 */
@WebServlet(name = "NewValor", urlPatterns = {"/NewValor"})
public class NewValor extends HttpServlet {
@EJB FoodEJB foodEjb;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int mark = Integer.parseInt(request.getParameter("mark"));
        String comment = request.getParameter("comment");
        Date dt = new Date();
        
        Dish d = foodEjb.getDishByName(request.getParameter("dish"));
        User u  = foodEjb.getUserByName(request.getParameter("user"));
        //User u = (User) HttpSession.getAttribute("user", tmp);
        
        Rate rt = new Rate(dt, mark, comment, u, d);
        try {
            foodEjb.altaValoras(rt);
            request.setAttribute("status", "Plato Valorado");
        }catch(Eeeeerroooorr e){
            request.setAttribute("status", e.getMessage());
        }
        request.getRequestDispatcher("/final.jsp").forward(request, response);
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