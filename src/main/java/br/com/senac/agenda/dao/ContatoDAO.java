
package br.com.senac.agenda.dao;

import br.com.senac.agenda.model.Contato;
import br.com.senac.agenda.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public void deletar(Contato contato) {
        String query = "DELETE FROM  contato WHERE id = ? ";
        Connection connection = null;
        
        try{
            connection = Conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, contato.getId());
            ps.executeUpdate();
        
        }catch (Exception ex){
            System.out.println("Erro ao deletar contato");
        }finally{
            try{
                connection.close();
            }catch (SQLException ex){
                System.out.println("Falha ao fechar conexão");
            }
        }
 
    }

    @Override
    public List<Contato> listar() {
        String query = "select * from contato;";
        List<Contato> lista = new ArrayList<>();
        Connection connection = null;

        try {
            connection = Conexao.getConnection();//abre conexao com o banco
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query); //executar a query e retorna um conjunto de resultados (tabela)

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setCelular(rs.getString("celular"));
                contato.setFax(rs.getString("fax"));
                contato.setCep(rs.getString("cep"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setNumero(rs.getString("numero"));
                contato.setBairro(rs.getString("bairro"));
                contato.setCidade(rs.getString("cidade"));
                contato.setEmail(rs.getString("email"));
                
                lista.add(contato);
            }

        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao fazer a consulta....");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Falha ao fechar conexao....");
            }
        }

        return lista;
        
   
    }

    @Override
    public Contato get(int id) {
        Contato contato = null;
        Connection connection = null;
        String query = "select * from contato where id= ?;";

        try {
            connection = Conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setCelular(rs.getString("celular"));
                contato.setFax(rs.getString("fax"));
                contato.setCep(rs.getString("cep"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setNumero(rs.getString("numero"));
                contato.setBairro(rs.getString("bairro"));
                contato.setCidade(rs.getString("cidade"));
                contato.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            System.out.println("Falha ao execultar consulta.......");

        } finally {

            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Falha ao fechar conexão.....");
            }
        }

        return contato;
 
    }
    
    public Contato getByName(String nome){
        Contato contato = null;
        Connection connection = null;
        String query = "select * from contato where nome= ?;";

        try {
            connection = Conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setCelular(rs.getString("celular"));
                contato.setFax(rs.getString("fax"));
                contato.setCep(rs.getString("cep"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setNumero(rs.getString("numero"));
                contato.setBairro(rs.getString("bairro"));
                contato.setCidade(rs.getString("cidade"));
                contato.setEmail(rs.getString("email"));
            }
            
        } catch (Exception ex) {
            System.out.println("Falha ao execultar consulta.......");

        } finally {

            try {
                connection.close();
            } catch (Exception ex) {
                System.out.println("Falha ao fechar conexão.....");
            }
        }

        return contato;

    }
    
    public List<Contato> getByFiltro(Integer id, String nome, String estado) {
        Contato contato = null;
        Connection connection = null;
        List<Contato> lista = new ArrayList<>();

        try {

            StringBuilder sb = new StringBuilder("select * from contato where 1=1 ");

            if (id != null) {
                sb.append("and id = ? ");
            }
            if (nome != null && !nome.trim().isEmpty()) {
                sb.append("and nome like ? ");
            }
            if (estado != null && !estado.trim().isEmpty()) {
                sb.append("and estado = ? ");
            }

            connection = Conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(sb.toString());

            int index = 0;

            if (id != null) {
                ps.setInt(++index, id);
            }
            if (nome != null && !nome.trim().isEmpty()) {
                ps.setString(++index, "%" + nome + "%");
            }
            if (estado != null && !estado.trim().isEmpty()) {
                ps.setString(++index, estado);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setCelular(rs.getString("celular"));
                contato.setFax(rs.getString("fax"));
                contato.setCep(rs.getString("cep"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setNumero(rs.getString("numero"));
                contato.setBairro(rs.getString("bairro"));
                contato.setCidade(rs.getString("cidade"));
                contato.setEmail(rs.getString("email"));
                lista.add(contato);
            }

        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao fazer a consulta....");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Falha ao fechar conexao....");
            }
        }

        return lista;

    }
    
    
    
    
    
    
}

