/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.PersonaDAO;
import dao.TipoPersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Persona;
import pojo.TipoPersona;

/**
 *
 * @author marcocameros
 */
@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class Test extends HttpServlet {

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
        
            String name= request.getParameter("nombre");
            String paterno=request.getParameter("paterno");
            String materno=request.getParameter("materno");
            String telefono=request.getParameter("telefono");
            int tipo=Integer.parseInt(request.getParameter("tipoPersona"));
            
            
            PersonaDAO personita=new PersonaDAO();
            Persona personaNueva=new Persona();
            // TipoPersonaDAO tipoPersona = new TipoPersonaDAO();
            
            
            //personaNueva.setNombre(name);
            //personaNueva.setPaterno(paterno);
            //personaNueva.setMaterno(materno);
            //personaNueva.setTelefono(telefono);
            //personaNueva.setTipoPersona(tipoPersona.getTipoPersonaById(tipo));
            
            personita.savePersona(name, materno, paterno, telefono, tipo);
            
            
            response.sendRedirect("exito.jsp");
            
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
