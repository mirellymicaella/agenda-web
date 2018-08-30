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

@WebServlet(name = "SalvarUsuarioServlet", urlPatterns = {"/usuario/SalvarUsuarioServlet"})
public class SalvarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("id");

        Integer id = 0;
        if (codigo != null && !codigo.trim().isEmpty()) {
            id = new Integer(codigo);
        }
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.get(id);
        
        request.setAttribute("usuario", usuario);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("gerenciarUsuario.jsp");
        dispatcher.forward(request, response);

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
        String mensagem = null;

        try {
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            String codigo = request.getParameter("codigo");
            Integer id = 0;

            if (codigo != null && !codigo.trim().isEmpty()) {
                id = new Integer(codigo);
            }

            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNome(nome);
            usuario.setSenha(senha);

            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(usuario);
            mensagem = "Salvo com sucesso!!";
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("usuario", usuario);

        } catch (Exception ex) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("gerenciarUsuario.jsp");
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
