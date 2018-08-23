package br.com.senac.agenda.dao;

import br.com.senac.agenda.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends DAO<Usuario> {

    @Override
    public void salvar(Usuario usuario) {
        Connection connection = null;
        try {
            String query;
            if (usuario.getId() == 0) {
                query = "INSERT INTO usuario(nome , senha) values (?, ?) ;";
            } else {
                query = "UPDATE usuario SET nome = ? ,  senha = ? where id = ? ; ";
            }
            connection = Conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            if (usuario.getId() == 0) {
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.first();
                usuario.setId(rs.getInt(1));
            } else {
                ps.setInt(3, usuario.getId());
                ps.executeUpdate();
            }

        } catch (Exception ex) {

        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Falha ao fechar conexao....");
            }
        }

    }

    @Override
    public void deletar(Usuario usuario) {
        String query = "DELETE FROM usuario WHERE id = ?";
        Connection connection = null;

        try {
            connection = Conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, usuario.getId());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Erro ao deletar registro...");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Falha ao fechar conexao....");
            }
        }
    }

    @Override
    public List<Usuario> listar() {
        String query = "select * from usuario;";
        List<Usuario> lista = new ArrayList<>();
        Connection connection = null;

        try {
            connection = Conexao.getConnection();//abre conexao com o banco
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query); //executar a query e retorna um conjunto de resultados (tabela)

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                lista.add(usuario);
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
    public Usuario get(int id) {
        Usuario usuario = null;
        Connection connection = null;
        String query = "select * from usuario where id= ?;";

        try {
            connection = Conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));

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

        return usuario;
    }

    public Usuario getByName(String nome) {
        Usuario usuario = null;
        Connection connection = null;
        String query = "select * from usuario where nome= ?;";

        try {
            connection = Conexao.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));

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

        return usuario;

    }

    public List<Usuario> getByFiltro(Integer id, String nome) {
        Usuario usuario = null;
        Connection connection = null;
        List<Usuario> lista = new ArrayList<>();

        try {

            StringBuilder sb = new StringBuilder("select * from usuario where 1=1 ");

            if (id != null) {
                sb.append("and id = ? ");
            }
            if (nome != null && !nome.trim().isEmpty()) {
                sb.append("and nome like ? ");
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

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                lista.add(usuario);
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

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        List<Usuario> lista = dao.getByFiltro(null, "mi");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> ++++" + lista.size());

        for (Usuario u : lista) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + u.getId() + " " + u.getNome() + " " + u.getSenha());
        }

        //Usuario u = usuarioDAO.get(3);
        //System.out.println("USUARIO " + u.getNome());
        //Usuario usuario = new Usuario("mirelly","123");
        //dao.salvar(usuario);
    }

}
