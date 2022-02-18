/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Circle;

/**
 *
 * @author LENOVO
 */
public class BouncingCicleController extends HttpServlet {

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
        int num = Integer.parseInt(request.getParameter("num"));
        int canvaswidth = Integer.parseInt(this.getInitParameter("canvaswidth"));
        int canvasheight = Integer.parseInt(this.getInitParameter("canvasheight"));
        int circleRadius =20;
        ArrayList<Circle> circleList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            Circle c = new Circle();
            c.setX(random.nextInt(canvaswidth-2*circleRadius+1)+circleRadius);
            c.setY(random.nextInt(canvasheight-2*circleRadius+1)+circleRadius);
            c.setR(circleRadius);
            c.setSpdX(random.nextInt(21)-10);
            c.setSpdY(random.nextInt(21)-10);
            circleList.add(c);
        }
        request.setAttribute("radius", circleRadius);
        request.setAttribute("circleL", circleList);
        request.setAttribute("width", canvaswidth);
        request.setAttribute("height", canvasheight);
        request.getRequestDispatcher("view/circle.jsp").forward(request, response);
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
