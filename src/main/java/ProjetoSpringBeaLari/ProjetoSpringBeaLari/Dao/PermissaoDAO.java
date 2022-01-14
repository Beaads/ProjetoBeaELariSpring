package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Connection.ConnectionFactory;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Permissao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissaoDAO {

    public List<Permissao> listAllPermissoes() {
        List<Permissao> permissoes = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("select codigopermissao, nomepermissao from permissao");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                int codigoPermissao = rst.getInt("codigopermissao");
                String nomePermissao = rst.getString("nomepermissao");
                Permissao permissao = new Permissao(codigoPermissao, nomePermissao);
                permissoes.add(permissao);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return permissoes;
    }

    public Permissao findByCodigoPermissao(int codigoPermissao) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT codigopermissao, nomepermissao"
                    + " FROM PERMISSAO WHERE codigopermissao= (?)");
            stm.setInt(1, codigoPermissao);
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            Permissao permissao = null;

            while (rst.next()) {
                int idCodigoPermissao = rst.getInt("codigopermissao");
                String nomePermissao = rst.getString("nomepermissao");
                permissao = new Permissao(idCodigoPermissao, nomePermissao);
            }
            return permissao;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Permissao cadastrarPermissao(Permissao permissao) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement(
                    "insert into permissao (nomepermissao) values (?) returning codigopermissao");
            stm.setString(1, permissao.getNomePermissao());
            stm.execute();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                int CODIGOPERMISSAO = rst.getInt("CODIGOPERMISSAO");
                permissao.setCodigoPermissao(CODIGOPERMISSAO);
            }
            return permissao;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int codigoPermissao) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("delete from permissao where codigopermissao = ?");
            stm.setInt(1, codigoPermissao);
            stm.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateById(Permissao permissao, int codigoPermissao) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm =
                    connection.prepareStatement("update permissao set nomepermissao = ? where codigopermissao = ?");
            stm.setString(1, permissao.getNomePermissao());
            stm.setInt(2, codigoPermissao);
            stm.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
