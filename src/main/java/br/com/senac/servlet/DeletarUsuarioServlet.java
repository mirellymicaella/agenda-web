/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.servlet;

import br.com.senac.agenda.dao.UsuarioDAO;
import br.com.senac.agenda.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sala302b
 */
@WebServlet(name = "DeletarUsuarioServlet", urlPatterns = {"/usuario/DeletarUsuarioServlet"})
public class DeletarUsuarioServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String mensagem = null;
        
        try{
        
        String codigo = request.getParameter("id");

        Integer id = 0;
        if (codigo != null && !codigo.trim().isEmpty()) {
            id = new Integer(codigo);
        }
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.get(id);
        dao.deletar(usuario);
        
        mensagem = "Deletado com sucesso!";
        request.setAttribute("mensagem", mensagem);
        
        }catch (Exception ex){
            mensagem = "Erro ao deletar usuário";
            System.out.println(mensagem);
            request.setAttribute("mensagem", mensagem);
            
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("pesquisarUsuario.jsp");
        dispatcher.forward(request, response);
        
        
        
        
        
        
        
        
        
        
        
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
