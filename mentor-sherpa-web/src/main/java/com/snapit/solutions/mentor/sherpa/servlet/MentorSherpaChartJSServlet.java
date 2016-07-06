/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@WebServlet(name = "MentorSherpaChartJSServlet", urlPatterns = {"/MentorSherpaChartJSServlet"})
public class MentorSherpaChartJSServlet extends HttpServlet {

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
            out.println("<title>Servlet MentorSherpaChartJSServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MentorSherpaChartJSServlet at " + request.getContextPath() + "</h1>");
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
    
    @RequestMapping(value = "/getReportData", method = RequestMethod.GET)
       public @ResponseBody
       String loadData(HttpServletResponse response) {
                  JsonObject piedata1  = new JsonObject();
                     piedata1.addProperty("value", Integer.parseInt("700"));
                     piedata1.addProperty("color", "#f56954");
                     piedata1.addProperty("highlight", "#f56954");
                     piedata1.addProperty("label", "Cooking");
                    
                     JsonObject piedata2  = new JsonObject();
                     piedata2.addProperty("value",  Integer.parseInt("500"));
                     piedata2.addProperty("color", "#00a65a");
                     piedata2.addProperty("highlight", "#00a65a");
                     piedata2.addProperty("label", "Baking");
                    
                     JsonObject piedata3  = new JsonObject();
                     piedata3.addProperty("value", Integer.parseInt("400"));
                     piedata3.addProperty("color", "#f39c12");
                     piedata3.addProperty("highlight", "#f39c12");
                     piedata3.addProperty("label", "Crafts");
                    
                    JsonObject piedata4  = new JsonObject();
                     piedata1.addProperty("value", Integer.parseInt("600"));
                     piedata1.addProperty("color", "#00c0ef");
                     piedata1.addProperty("highlight", "#00c0ef");
                     piedata1.addProperty("label", "Painting");
                    
                     JsonObject piedata5  = new JsonObject();
                     piedata2.addProperty("value",  Integer.parseInt("300"));
                     piedata2.addProperty("color", "#3c8dbc");
                     piedata2.addProperty("highlight", "#3c8dbc");
                     piedata2.addProperty("label", "Computer");
                    
                     JsonObject piedata6  = new JsonObject();
                     piedata3.addProperty("value", Integer.parseInt("100"));
                     piedata3.addProperty("color", "#d2d6de");
                     piedata3.addProperty("highlight", "#d2d6de");
                     piedata3.addProperty("label", "Sports");

                     ArrayList<Object> pieDataSet = new ArrayList<Object>();
                     pieDataSet.add(piedata1);
                     pieDataSet.add(piedata2);
                     pieDataSet.add(piedata3);
                     pieDataSet.add(piedata4);
                     pieDataSet.add(piedata5);
                     pieDataSet.add(piedata6);
                                 
                     return pieDataSet.toString();
             
       }

}
