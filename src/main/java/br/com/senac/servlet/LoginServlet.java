
package br.com.senac.servlet;

import br.com.senac.agenda.dao.UsuarioDAO;
import br.com.senac.agenda.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        
       String usuario = requisicao.getParameter("user");
       String navegador = requisicao.getHeader("User-agent");
       
        //tipo de resposta
        resposta.setContentType("text/html");
        PrintWriter out = resposta.getWriter();
        out.println ("<html>");
        out.println ("<body>");
        
        out.println ("<font size=20> Olá, " + usuario + " </font><br/> <br/>");
        out.println ("<font color = red size=15 > Seja bem vindo ao mundo dos Sevlets !! </font> ");
        out.println ("<br/><font color = blue size=20 > Voce esta usando o navegador " + navegador + " </font> ");
        
        out.println ("</body>");
        out.println ("</html>");
        
        
    }

    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        
        
        String nome= requisicao.getParameter("usuario");
        String senha= requisicao.getParameter("senha");
        
        PrintWriter out = resposta.getWriter();
    out.println("<html>");
    out.println("<body>");
        
        if(nome!=null 
                && senha!=null
                    && !nome.trim().isEmpty() //.trim tira o espaço vazio
                        && !senha.trim().isEmpty()){
        
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.getByName(nome);
            
            if (usuario!=null && usuario.getSenha().equals(senha)){
                //Caso não exista sessão o conteiner vai criar
                //Caso exista ele vai somente devolver oobjeto
                HttpSession session= requisicao.getSession();
                session.setAttribute("user", usuario);
                session.getAttribute("user");
                
 //               out.println("<font size=30>Seja bem vindo, " + nome + " !!!</font>"); 
                 resposta.sendRedirect("principal.jsp");
  
            }else{
                if(usuario==null){
                   out.println("<font size=30>Usuario inexistente </font>");
                }else{
                out.println("<font size=30 >Falha na autenticação! </font>");
                }
            }
            
        }else{
                resposta.sendRedirect("login.html");
        }
        
    out.println("</body>");
    out.println("</html>");

   
        
     
        
    }
    
    
  
}
