package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Connection.ConnectionFactory;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.PermissaoColaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissaoColaboradorDAO {

    public List<PermissaoColaborador> listAllPermissaoColaboradores() {
        List<PermissaoColaborador> colaboradoresEPermissoes = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT codigocolaborador, codigopermissao FROM COLABORADOR_PERMISSAO");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while(rst.next()) {
                int codigoColaborador = rst.getInt("codigocolaborador");
                int codigoPermissao = rst.getInt("codigopermissao");
                PermissaoColaborador permissaoColaborador = new PermissaoColaborador(codigoColaborador, codigoPermissao);
                colaboradoresEPermissoes.add(permissaoColaborador);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return colaboradoresEPermissoes;
    }

    public List<PermissaoColaborador> findByCodigoPermissaoColaborador(int codigoColaborador) {
        List<PermissaoColaborador> colaboradoresEPermissoes = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT codigocolaborador, codigopermissao FROM COLABORADOR_PERMISSAO WHERE codigocolaborador = (?)");
            stm.setInt(1, codigoColaborador);
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while(rst.next()) {
                int idCodigoColaborador = rst.getInt("codigocolaborador");
                int codigoPermissao = rst.getInt("codigopermissao");
                PermissaoColaborador permissaoColaborador = new PermissaoColaborador(idCodigoColaborador, codigoPermissao);
                colaboradoresEPermissoes.add(permissaoColaborador);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return colaboradoresEPermissoes;
    }

    public PermissaoColaborador cadastrarPermissaoColaborador(PermissaoColaborador permissaoColaborador) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO COLABORADOR_PERMISSAO (" +
                    " CODIGOCOLABORADOR, CODIGOPERMISSAO) VALUES (?, ?) RETURNING CODIGOCOLABORADOR, CODIGOPERMISSAO");
            stm.setInt(1, permissaoColaborador.getCodigoColaborador());
            stm.setInt(2, permissaoColaborador.getCodigoPermissao());
            stm.execute();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                int codigoColaborador = rst.getInt("CODIGOCOLABORADOR");
                int codigoPermissao = rst.getInt("CODIGOPERMISSAO");
                permissaoColaborador.setCodigoColaborador(codigoColaborador);
                permissaoColaborador.setCodigoPermissao(codigoPermissao);
            }

            return permissaoColaborador;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int codigoColaborador, int codigoPermissao) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM COLABORADOR_PERMISSAO WHERE " +
                    "CODIGOCOLABORADOR = ? AND CODIGOPERMISSAO = ?");
            stm.setInt(1, codigoColaborador);
            stm.setInt(2, codigoPermissao);
            stm.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}




