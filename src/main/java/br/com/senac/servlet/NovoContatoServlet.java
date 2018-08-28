
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


@WebServlet(name = "NovoContatoServlet", urlPatterns = {"/contato/NovoContatoServlet"})
public class NovoContatoServlet extends HttpServlet {

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
     
        String mensagem = null;
        
        try{
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String fax = request.getParameter("fax");
        String cep = request.getParameter("cep");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String email = request.getParameter("email");
        String codigo = request.getParameter("codigo");
        Integer id =0;

            if (codigo != null && !codigo.trim().isEmpty()) {
                id = new Integer(codigo);
            }
        
        Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setTelefone(telefone);
        contato.setCelular(celular);
        contato.setFax(fax);
        contato.setCep(cep);
        contato.setEndereco(endereco);
        contato.setNumero(numero);
        contato.setBairro(bairro);
        contato.setCidade(cidade);
        contato.setUf(uf);
        contato.setEmail(email);
        
        
        ContatoDAO dao = new ContatoDAO();
        dao.salvar(contato);
        mensagem = "Salvo com sucesso!";
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("contato",contato);
        
        }catch(Exception ex ){
            System.out.println("Erro ao salvar contato");
            
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("contato.jsp");
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
