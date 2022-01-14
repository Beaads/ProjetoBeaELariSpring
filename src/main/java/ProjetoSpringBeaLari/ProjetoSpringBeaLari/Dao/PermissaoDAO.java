package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Connection.ConnectionFactory;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Permissao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PermissaoDAO {

    private Connection connection;

    public PermissaoDAO(Connection connection) {
        this.connection = connection;
    }

    public PermissaoDAO() {

    }

    public ArrayList<Permissao> listAllPermissoes() {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT codigoPermissao, nomePermissao FROM PERMISSAO");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            ArrayList<Permissao> permissoes = new ArrayList<>();
            while(rst.next()) {
                int codigoPermissao = rst.getInt("codigopermissao");
                String nomePermissao = rst.getString("nomepermissao");
                Permissao permissao = new Permissao(codigoPermissao, nomePermissao);
                permissoes.add(permissao);
            }
            return permissoes;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Permissao findByCodigoPermissao(int codigoPermissao) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT codigopermissao, nomepermissao"
                    + " FROM PERMISSAO WHERE codigopermissao= (?)");
            stm.setInt(1, codigoPermissao);
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            Permissao permissao = null;

            while(rst.next()) {
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

    public String returnPermisao(int codigoPermissao) {
        String permissao = "";
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT nomepermissao FROM PERMISSAO WHERE codigopermissao= (?)");
            stm.setInt(1, codigoPermissao);
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while(rst.next()) {
                permissao = rst.getString("nomepermissao");
            }
            return permissao;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return permissao;
    }

    public Permissao cadastrarPermissao(Permissao permissao) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO PERMISSAO (NOMEPERMISSAO) VALUES (?) RETURNING CODIGOPERMISSAO");
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
            PreparedStatement stm = connection.prepareStatement("DELETE FROM PERMISSAO WHERE codigoPermissao = ?");
            stm.setInt(1, codigoPermissao);
            stm.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateById(Permissao permissao, int codigoPermissao) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("UPDATE PERMISSAO SET nomePermissao = ? WHERE codigoPermissao = ?");
            stm.setString(1, permissao.getNomePermissao());
            stm.setInt(2, codigoPermissao);
            stm.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
