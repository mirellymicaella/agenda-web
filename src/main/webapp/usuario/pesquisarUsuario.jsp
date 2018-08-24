
<%@page import="java.util.List"%>
<%@page import="br.com.senac.agenda.model.Usuario"%>
<jsp:include page="../header.jsp"/>

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

        
        <button type="submit" class="btn btn-default">Pesquisar</button>

    </form>
</fieldset>

<hr/>

Resultado:

<table class="table table-hover">
    <thead>
        <tr>
            <th>Código</th> <th>Nome</th>
        </tr>
    </thead>

    <% if (lista != null && lista.size() > 0) {
            for (Usuario u : lista) {
           
    %>

    <tr>
        <td><%= u.getId()%></td><td><%= u.getNome()%></td>
    </tr>

    <% } // for

        } else {%>

    <tr >
        <td  colspan="2">Não Existem registros.</td>
    </tr>

    <%}%>



</table>















<jsp:include page="../footer.jsp"/>
