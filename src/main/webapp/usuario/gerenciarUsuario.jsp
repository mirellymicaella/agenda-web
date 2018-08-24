<%@page import="br.com.senac.agenda.model.Usuario"%>
<jsp:include page="../header.jsp"/>



<% String mensagem = (String) request.getAttribute("mensagem");   %>

<% Usuario usuario = (Usuario) request.getAttribute("usuario");%>

<% if (mensagem != null ) {%>
<div class="alert alert-success">
    <%=mensagem%>
</div>
<%}%>






<form action="./SalvarUsuarioServlet" method="post" style="margin-left: 70px">

    <div class="form-group">
        <label for="codigo">Código</label>
        <input type="text" class="form-control col-2" id="codigo" name="cdigo" readonly 
               value="<%= usuario != null ? usuario.getId(): "" %>"/>
    </div>

    <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" name="nome"class="form-control col-xl-6" placeholder="Nome completo"
               value="<%= usuario != null ? usuario.getNome() : ""  %>"/>
    </div>

    <div class="form-group">
        <label for="senha">Password</label>
        <input type="password" name="senha" class="form-control col-xl-6" id="senha" placeholder="Senha" />
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-defaut">Salvar</button>
        <button type="reset" class="btn btn-defaut">Cancelar</button>
    </div>
</form></center


<jsp:include page="../footer.jsp"/>