
package br.com.senac.agenda.dao;

import br.com.senac.agenda.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class ContatoDAO extends DAO<Contato>{

    @Override
    public void salvar(Contato contato) {
        Connection connection = null;
        try{
            String query;
            if(contato.getId() == 0){
                query="INSERT INTO contato (nome,telefone,celular,fax,cep,endereco,numero,bairro,cidade,uf,email) "
                        + "values (?,?,?,?,?,?,?,?,?,?,?);";
            }else{
                query="UPDATE contato SET nome = ?, telefone = ?, celular = ?, fax = ?, cep = ? , enderco = ? ,"
                        + "numero = ? , bairro = ? , cidade = ? , uf = ? , email = ? WHERE id = ? ;";
            }
            connection = Conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.setString(3, contato.getCelular());
            ps.setString(4, contato.getFax());
            ps.setString(5, contato.getCep());
            ps.setString(6, contato.getEndereco());
            ps.setString(7, contato.getNumero());
            ps.setString(8, contato.getBairro());
            ps.setString(9, contato.getCidade());
            ps.setString(10, contato.getUf());
            ps.setString(11, contato.getEmail());

            if(contato.getId() == 0){
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.first();
                contato.setId(rs.getInt(1));
            }else{
                ps.setInt(12, contato.getId());
                ps.executeUpdate();
            }   
            
        }catch(Exception ex){
            System.out.println("Erro ao salvar ");
            
        }finally{
            try{
                connection.close();
            }catch (Exception ex){
               System.out.println("Falha ao fechar conexao....");
            }
        }
        

    }

    @Override
    public void deletar(Contato objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contato> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contato get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

