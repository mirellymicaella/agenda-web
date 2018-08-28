<%@page import="java.util.List"%>
<%@page import="br.com.senac.agenda.model.Contato"%>
<jsp:include page="../header.jsp"/>

<% List<Contato> lista = (List) request.getAttribute("lista"); %>

<% String mensagem = (String) request.getAttribute("mensgaem"); %>

<% if (mensagem != null) {%>
<div class="alert alert-danger">
    <%=mensagem%>
</div>
<%}%>



<fieldset >
    <center> <b><legend>Pesquisa de Contato </b></legend> </center>
    <form  action="./PesquisaContato" method="post">

        <div class="row">
            
        <div class="form-group col-md-2" >
            <label for='codigo'>Código</label>
            <input name="codigo" class="form-control" id="codigo" type="text"/>
        </div>

        <div class="form-group col-md-6" >
            <label style="margin-right: 10px">Nome</label>
            <input name="nome" id="nome" type="text" class="form-control form-control-sm"/>
        </div>
        
        <div class="form-group col-2" s>
        <label style="margin-right: 10px">Estado</label>   
        
        <select name="estado" class="custom-select">
        <option value=""  selected="true">--</option>    
	<option value="AC">AC</option>
	<option value="AL">AL</option>
	<option value="AP">AP</option>
	<option value="AM">AM</option>
	<option value="BA">BA</option>
	<option value="CE">CE</option>
	<option value="DF">DF</option>
	<option value="ES">ES</option>
	<option value="GO">GO</option>
	<option value="MA">MA</option>
	<option value="MT">MT</option>
	<option value="MS">MS</option>
	<option value="MG">MG</option>
	<option value="PA">PA</option>
	<option value="PB">PB</option>
	<option value="PR">PR</option>
	<option value="PE">PE</option>
	<option value="PI">PI</option>
	<option value="RJ">RJ</option>
	<option value="RN">RN</option>
	<option value="RS">RS</option>
	<option value="RO">RO</option>
	<option value="RR">RR</option>
	<option value="SC">SC</option>
	<option value="SP">SP</option>
	<option value="SE">Se</option>
	<option value="TO">TO</option>
         </select>
       <div class="invalid-feedback">Example invalid custom select feedback</div>
       </div>

            <div class="form-group col-2" style="margin-top: 30px;">
        <button type="submit" class="btn btn-default">Pesquisar</button>
       </div>

        </div>
    </form>
</fieldset>

<hr/>

Resultado:

<table class="table table-hover">
    <thead>
        <tr>
            <th>Código</th> <th>Nome</th><th>Endereço</th>
            <th>Telefone</th><th>Celular</th><th>Fax</th><th>E-mail</th>
        </tr>
    </thead>

    <% if (lista != null && lista.size() > 0) {
            for (Contato c : lista) {
           
    %>

    <tr>
        <td><%= c.getId()%></td><td><%= c.getNome()%></td>
        <td><%= c.getEndereco() + ", " + c.getNumero() + ", " + c.getBairro() + "-" + c.getCidade() + "-" + c.getUf()%></td>
        <td><%= c.getTelefone()%></td><td><%= c.getCelular()%></td><td><%= c.getFax()%></td>
        <td><%= c.getEmail()%></td>
    </tr>

    <% } // for

        } else {%>

    <tr >
        <td  colspan="2">Não Existem registros.</td>
    </tr>

    <%}%>



</table>









<jsp:include page="../footer.jsp" />
