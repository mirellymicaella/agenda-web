
<%@page import="java.util.List"%>
<%@page import="br.com.senac.agenda.model.Usuario"%>
<jsp:include page="../header.jsp"/>

<script type="text/javascript">

function excluir(id , nome){
    
    $('#nomeUsuario').text(nome);
    
    var formNome = $('#txtNome').val(); 
    var formId = $('#txtCodigo').val() ; 
    
    var url = './DeletarUsuarioServlet?id=' + id + "&formNome=" + formNome + "&formId=" + formId ; 
    
    $('#btnConfirmar').attr('href' , url ) ; 
    
}
    
    
</script>

<% List<Usuario> lista = (List) request.getAttribute("lista");  %>

<% String mensagem = (String) request.getAttribute("mensagem");   %>

<% if (mensagem != null) {%>
<div class="alert alert-danger">
    <%=mensagem%>
</div>
<%}%>




<fieldset >
    <center> <b><legend>Pesquisa de usuários</b></legend> </center>
    <form class="form-inline" action="./PesquisaUsuario">

        <div class="form-group" style="padding: 60px">
            <label for='txtCodigo col-lg-2' style="margin-right: 10px" >Código: </label>
            <input name="id" class="form-control input-sm" id="txtCodigo" type="text"/>
        </div>

        <div class="form-group" >
            <label style="margin-right: 10px">Nome</label>
            <input name="nome" id="nome" type="text" class="form-control form-control-sm"/>
        </div>

        
        <button type="submit" class="btn btn-primary">Pesquisar</button>
    </form>
    <form class="form-inline" action="./SalvarUsuarioServlet">
        <button type="submit" class="btn btn-primary">Adicionar</button>
    </form>
    
</fieldset>

<hr/>

Resultado:

<table class="table table-hover">
    <thead>
        <tr>
            <th style="width: 100px;">Código</th><th>Nome</th><th style="width: 10px;"></th>
        </tr>
    </thead>

    <% if (lista != null && lista.size() > 0) {
            for (Usuario u : lista) {       
    %>

    <tr>
        <td><%= u.getId()%></td><td><%= u.getNome()%></td>
        
        <td> 
            <a href="./SalvarUsuarioServlet?id=<%= u.getId() %>" > 
                <img src="../resourses/imagens/pencil-blue-icon.png" />
            </a> 
            <a href="" data-toggle="modal" data-target="#modalExclusao" 
                   onclick="excluir(<%= u.getId()%> , '<%= u.getNome()%>' );">
                <img src="../resourses/imagens/Button-Delete-icon.png" />
            </a>
        </td>  
    </tr>
    

    <% } // for

        } else {%>

    <tr >
        <td  colspan="2">Não Existem registros.</td>
    </tr>

    <%}%>

</table>
    
   <!-- Modal -->
<div class="modal fade" id="modalExclusao" tabindex="-1" role="dialog" 
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Exclusão</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Deseja realmente apagar o usuário <span id="nomeUsuario"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                
                <a  id="btnConfirmar" class="btn btn-primary">Confirmar</a>
            </div>
        </div>
    </div>
</div> 
    
    
    

<jsp:include page="../footer.jsp"/>
