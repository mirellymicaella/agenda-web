<jsp:include page="header.jsp"/>

<form action="./NovoContatoServlet" method="post" >
     <div class="form-group">
        <label for="codigo">Código</label>
        <input type="text" class="form-control col-2" id="codigo" name="cdigo" readonly />
    </div>
    
    <div class="row">
        <div class="form-group col-md-6"
             <label for="nome">Nome</label>
            <input type="text" name="nome" id="nome" class="form-control " placeholder="Nome completo"/>
        </div>
    </div>

    <div class="row">
        <div class="col-4"
            <label for="telefone">Telefone</label>
            <input type="text" name="telefone" id="telefone" class="form-control"   />
        </div>

        <div class="col-4">
            <label for="celular">Celular</label>
            <input type="text" name="celular" id="celular" class="form-control "  />
        </div>

        <div class="col-4">
            <label for="fax"> Fax</label>
            <input type="text" class="form-control col-4" id="telefonefax" name="fax"  />
        </div>
    </div>

    <div class="row">
        <div class="col-3">
            <label for="cep">CEP</label>
            <input type="text" name="cep" id="cep"class="form-control" placeholder="Nome completo"/>
        </div>

        <div class="col-7">
            <label for="endereco">Endereço</label>
            <input type="text" name="endereco" id="endereco"class="form-control " />
        </div>

        <div class="col-2">
            <label for="numero">Numero</label>
            <input type="text" name="numero" id="numero"class="form-control " />
        </div>
    </div>

    <div class="row">
        <div class="col-5"
             <label for="bairro">Bairro</label>
            <input type="text" name="bairro" id="bairro" class="form-control " />
        </div>

        <div class="col-5">
            <label for="cidade">Cidade</label>
            <input type="text" name="cidade" id="cidade" class="form-control " />
        </div>

        <div class="col-2">
            <label for="uf">|UF</label>
            <input type="text" name="uf" id="uf" class="form-control "/>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-6">
        <label for="email">Email</label>
        <input type="email" name="email" class="form-control" id="email" placeholder="Email">
        </div>
    </div>
    
     <div class="form-group">
        <button type="submit" class="btn btn-defaut">Salvar</button>
        <button type="reset" class="btn btn-defaut">Cancelar</button>
    </div>




</form>

<jsp:include page="footer.jsp"/>