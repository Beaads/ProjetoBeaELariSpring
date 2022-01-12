//package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao;
//
//import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Connection.ConnectionFactory;
//import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Permissao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class PermissaoDAO {
//    private final Connection connection;
//
//    public PermissaoDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void cadastrarPermissao(Permissao permissao) {
//        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
//            PreparedStatement stm = connection.prepareStatement(
//                    "INSERT INTO PERMISSAO (CODIGOPERMISSAO, NOMEPERMISSAO ) VALUES (?, ?)");
//
//            stm.setInt(1, permissao.getCodigoPermissao());
//            stm.setString(2, permissao.getNomePermissao());
//
//            stm.execute();
//
//            ResultSet rst = stm.getResultSet();
//            while (rst.next()) {
//                Integer CODIGOPERMISSAO = rst.getInt("CODIGOPERMISSAO");
//                System.out.println(CODIGOPERMISSAO);
//                String NOMEPERMISSAO = rst.getString("NOMEPERMISSAO");
//                System.out.println(NOMEPERMISSAO);
//
//                connection.close();
//            }
//
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void excluirPermissao(Integer codigopermissao) {
//        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
//            PreparedStatement stm = connection.prepareStatement(
//                    "DELETE FROM PERMISSAO WHERE CODIGOPERMISSAO = ?");
//            {
//                stm.setInt(1, codigopermissao);
//                stm.execute();
//
//                connection.close();
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
