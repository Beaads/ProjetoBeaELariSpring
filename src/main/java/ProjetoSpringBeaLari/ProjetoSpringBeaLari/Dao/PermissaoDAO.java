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
            PreparedStatement stm = connection.prepareStatement("SELECT codigoPermissao, nomePermissao FROM public.Permissao");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            ArrayList<Permissao> permissoes = new ArrayList<Permissao>();
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
                    + " FROM public.permissao WHERE codigopermissao= (?)");
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

    public void excluirPermissao(Integer codigopermissao) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement(
                    "DELETE FROM PERMISSAO WHERE CODIGOPERMISSAO = ?");
            {
                stm.setInt(1, codigopermissao);
                stm.execute();

                connection.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
