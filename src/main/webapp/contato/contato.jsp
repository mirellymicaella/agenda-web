<%@page import="br.com.senac.agenda.model.Contato"%>
<jsp:include page="../header.jsp"/>

<% String mensagem = (String) request.getAttribute("mensagem"); %>

<% Contato contato = (Contato) request.getAttribute("contato"); %>

<% if (mensagem != null) {%>
<div class="alert alert-success">
    <%=mensagem%>
</div>
<%  }%>

<form action="./NovoContatoServlet" method="post" >

    <div class="form-group">
        <label for="codigo">Código</label>
        <input type="text" name="codigo" class="form-control col-2" id="codigo" readonly 
               value="<%= contato != null ? contato.getId() : ""%>"/>
    </div>

    <div class="row">
        <div class="form-group col-md-6"
             <label for="nome">Nome</label>
            <input type="text" name="nome" id="nome" class="form-control " placeholder="Nome completo"
                   value="<%= contato != null ? contato.getNome() : ""%>"/>
        </div>
    </div>

    <div class="row">
        <div class="col-4"
             <label for="telefone">Telefone</label>
            <input type="text" name="telefone" id="telefone" class="form-control"   
                   value="<%= contato != null ? contato.getTelefone() : ""%>"/>
        </div>

        <div class="col-4">
            <label for="celular">Celular</label>
            <input type="text" name="celular" id="celular" class="form-control "  
                   value="<%= contato != null ? contato.getCelular() : ""%>"/>
        </div>

        <div class="col-4">
            <label for="fax"> Fax</label>
            <input type="text" class="form-control col-4" id="telefonefax" name="fax" 
                   value="<%= contato != null ? contato.getFax() : ""%>"/>
        </div>
    </div>

    <div class="row">
        <div class="col-3">
            <label for="cep">CEP</label>
            <input type="text" name="cep" id="cep"class="form-control" placeholder="Nome completo"
                   value="<%= contato != null ? contato.getCep() : ""%>"/>
        </div>

        <div class="col-7">
            <label for="endereco">Endereço</label>
            <input type="text" name="endereco" id="endereco"class="form-control " 
                   value="<%= contato != null ? contato.getEndereco() : ""%>"/>
        </div>

        <div class="col-2">
            <label for="numero">Numero</label>
            <input type="text" name="numero" id="numero"class="form-control "
                   value="<%= contato != null ? contato.getNumero() : ""%>"/>
        </div>
    </div>

    <div class="row">
        <div class="col-5"
             <label for="bairro">Bairro</label>
            <input type="text" name="bairro" id="bairro" class="form-control " 
                   value="<%= contato != null ? contato.getBairro() : ""%>"/>
        </div>

        <div class="col-5">
            <label for="cidade">Cidade</label>
            <input type="text" name="cidade" id="cidade" class="form-control " 
                   value="<%= contato != null ? contato.getCidade() : ""%>"/>
        </div>

        <div class="col-2">
            <label for="uf">|UF</label>
            <select name="uf" class="custom-select">
                <option value=""  selected="true"><%= contato != null ? contato.getUf() : "--" %></option>    
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
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-6">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control" id="email" placeholder="Email"
                   value="<%= contato != null ? contato.getEmail() : ""%>">
        </div>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-defaut">Salvar</button>
        <button type="reset" class="btn btn-defaut">Cancelar</button>
    </div>




</form>

<jsp:include page="../footer.jsp"/>