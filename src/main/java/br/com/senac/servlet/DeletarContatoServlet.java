package br.com.senac.servlet;

import br.com.senac.agenda.dao.ContatoDAO;
import br.com.senac.agenda.model.Contato;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeletarContatoServlet", urlPatterns = {"/contato/DeletarContatoServlet"})
public class DeletarContatoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mensagem = null;

        try {

            String codigo = request.getParameter("id");

            Integer id = 0;
            if (codigo != null && !codigo.trim().isEmpty()) {
                id = new Integer(codigo);
            }

            ContatoDAO dao = new ContatoDAO();
            Contato contato = dao.get(id);
            dao.deletar(contato);

            mensagem = "Deletado com sucesso!";
            request.setAttribute("mensagem", mensagem);

        } catch (Exception ex) {
               mensagem = "Erro ao deletar contato";
            System.out.println(mensagem);
            request.setAttribute("mensagem", mensagem);
        }
     
         RequestDispatcher dispatcher = request.getRequestDispatcher("pesquisarContato.jsp");
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
