package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Connection.ConnectionFactory;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Permissao;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.PermissaoColaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PermissaoColaboradorDAO {
    private Connection connection;


    public PermissaoColaboradorDAO(Connection connection) {
        this.connection = connection;
    }

    public PermissaoColaboradorDAO() {

    }

    public ArrayList<PermissaoColaborador> listAllPermissaoColaboradores() {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT codigocolaborador, codigopermissao FROM COLABORADOR_PERMISSAO");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            ArrayList<PermissaoColaborador> colaboradoresEPermissoes = new ArrayList<PermissaoColaborador>();
            while(rst.next()) {

                int codigoColaborador = rst.getInt("codigocolaborador");
                int codigoPermissao = rst.getInt("codigopermissao");
                PermissaoColaborador permissaoColaborador = new PermissaoColaborador(codigoColaborador, codigoPermissao);
                colaboradoresEPermissoes.add(permissaoColaborador);
            }
            if (colaboradoresEPermissoes.size() > 0) {
                return colaboradoresEPermissoes;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PermissaoColaborador findByCodigoPermissaoColaborador(int idColaborador) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT codigocolaborador, codigopermissao FROM COLABORADOR_PERMISSAO" +
                    " WHERE codigocolaborador = (?)");
            stm.setInt(1, idColaborador);
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            PermissaoColaborador permissaoColaborador = null;
            while(rst.next()) {
                int codigoColaborador = rst.getInt("CODIGOCOLABORADOR");
                int codigoPermissao = rst.getInt("codigopermissao");
                permissaoColaborador = new PermissaoColaborador(codigoColaborador, codigoPermissao);
            }
            return permissaoColaborador;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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

                int codigoPermissaoColaborador = rst.getInt("CODIGOCOLABORADOR");
                permissaoColaborador.setCodigoColaborador(codigoPermissaoColaborador);
                permissaoColaborador.setCodigoPermissao(codigoPermissaoColaborador);
            }

            return permissaoColaborador;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



//    public void aposValidacaoPermissaoColaborador(int codigoColaborador, int codigoPermissao) {
//        try {
//            PreparedStatement stmValidation = connection.prepareStatement("SELECT CODIGOCOLABORADOR FROM COLABORADOR_PERMISSAO WHERE CODIGOCOLABORADOR = ?");
//            stmValidation.setInt(1, codigoColaborador);
//            while(codigoPermissao <= 4) {
//                ResultSet resultadoValidation = stmValidation.executeQuery();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

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



