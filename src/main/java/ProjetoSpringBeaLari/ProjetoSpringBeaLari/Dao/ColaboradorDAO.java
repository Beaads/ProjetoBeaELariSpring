package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Connection.ConnectionFactory;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ColaboradorDAO {

    private Connection connection;

    public ColaboradorDAO(Connection connection) {
        this.connection = connection;
    }

    public ColaboradorDAO() {
        
    }

    public Colaborador cadastrarColaborador(Colaborador colaborador) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO COLABORADOR (" +
                    " NOMECOLABORADOR, DATANASCIMENTO) VALUES (?, ?) RETURNING CODIGOCOLABORADOR");
            stm.setString(1, colaborador.getNomeColaborador());
            stm.setString(2, colaborador.getDataNascimento());

            stm.execute();

            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                int codigoColaborador = rst.getInt("CODIGOCOLABORADOR");
                colaborador.setCodigoColaborador(codigoColaborador);
            }
            return colaborador;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void excluirColaborador(int codigocolaborador) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM COLABORADOR WHERE " +
                    "CODIGOCOLABORADOR = ?");
            {
                stm.setInt(1, codigocolaborador);

                stm.execute();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
