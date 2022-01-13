package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Connection.ConnectionFactory;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ColaboradorDAO {

    private Connection connection;

    public ColaboradorDAO(Connection connection) {
        this.connection = connection;
    }

    public ColaboradorDAO() {
        
    }

    public ArrayList<Colaborador> listAllColaboradores() {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT codigocolaborador, nomecolaborador,"
                    + " datanascimento, qtdmaxpermissoes FROM public.colaborador");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
            while(rst.next()) {
                int codigoColaborador = rst.getInt("CODIGOCOLABORADOR");
                String nomecolaborador = rst.getString("nomecolaborador");
                String datanascimento = rst.getString("datanascimento");
                int qtdmaxpermissoes = rst.getInt("qtdmaxpermissoes");
                Colaborador colaborador = new Colaborador(codigoColaborador, nomecolaborador, datanascimento, qtdmaxpermissoes);
                colaboradores.add(colaborador);
            }
            if (colaboradores.size() > 0) {
                return colaboradores;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Colaborador findByCodigoColaborador(int idColaborador) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT codigocolaborador, nomecolaborador,"
                    + " datanascimento, qtdmaxpermissoes FROM COLABORADOR WHERE codigocolaborador= (?)");
            stm.setInt(1, idColaborador);
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            Colaborador colaborador = null;
            while(rst.next()) {
                int codigoColaborador = rst.getInt("CODIGOCOLABORADOR");
                String nomecolaborador = rst.getString("nomecolaborador");
                String datanascimento = rst.getString("datanascimento");
                int qtdmaxpermissoes = rst.getInt("qtdmaxpermissoes");
                colaborador = new Colaborador(codigoColaborador, nomecolaborador, datanascimento, qtdmaxpermissoes);
            }
            return colaborador;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Colaborador cadastrarColaborador(Colaborador colaborador) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO PUBLIC.COLABORADOR (" +
                    " NOMECOLABORADOR, DATANASCIMENTO, qtdMaxPermissoes) VALUES (?, ?, ?) RETURNING CODIGOCOLABORADOR");
            stm.setString(1, colaborador.getNomeColaborador());
            stm.setString(2, colaborador.getDataNascimento());
            stm.setInt(3, colaborador.getQtdMaxPermissoes());
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

    public void deleteById(int codigoColaborador) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM COLABORADOR WHERE " +
                    "CODIGOCOLABORADOR = ?");
                stm.setInt(1, codigoColaborador);
                stm.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateById(Colaborador colaborador, int codigoColaborador) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("UPDATE COLABORADOR " +
                     "SET NOMECOLABORADOR = ?, DATANASCIMENTO = ?, qtdMaxPermissoes = ?" +
                    "WHERE CODIGOCOLABORADOR = ?");
            stm.setString(1, colaborador.getNomeColaborador());
            stm.setString(2, colaborador.getDataNascimento());
            stm.setInt(3, colaborador.getQtdMaxPermissoes());
            stm.setInt(4, codigoColaborador);
            stm.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
//    public int calculaIdade() throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Calendar dataNascimento = Calendar.getInstance();
//        dataNascimento.setTime(sdf.parse("15/09/1970"));
//
//        Calendar dataAtual = Calendar.getInstance();
//
//        int idade = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
//
//        if (dataAtual.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
//            idade--;
//        } else {
//            if (dataAtual.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && dataAtual
//                    .get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
//                idade--;
//            }
//        }
//        return idade;
//    }
//}
