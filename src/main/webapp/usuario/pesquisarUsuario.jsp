
<jsp:include page="../header.jsp"/>



<fieldset >
    <legend>Pesquisa de usuários</legend>
    <form class="form-inline">

        <div class="form-group" style="padding: 60 px">
            <label for='txtCodigo col-lg-2' style="margin-right: 10px" >Código: </label>
            <input name = "id" class="form-control input-sm" id="txtCodigo" type="text"/>
        </div>

        <div class="form-group" style="margin-right: 10px">
            <label>Nome</label>
            <input name = "nome" type="text" class="form-control form-control-sm"/>
        </div>

        <buttom type='submit' class='btn btn-default'>Pesquisar</buttom>

    </form>
</fieldset>

<hr/>

<table>
    <thead>
        <tr>
            <th>Código</th> <th>Nome</th>
        </tr>
    </thead>
    
    <tr>
        <td>1</td><td>mirelly</td>
    </tr>
    
    
</table>















<jsp:include page="../footer.jsp"/>
