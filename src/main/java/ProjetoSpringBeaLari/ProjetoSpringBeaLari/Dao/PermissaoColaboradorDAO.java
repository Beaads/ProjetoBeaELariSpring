//package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao;
//
//import ProjetoJaneiro.Connection.ConnectionFactory;
//import ProjetoJaneiro.Domain.Colaborador;
//import ProjetoJaneiro.Domain.Permissao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class PermissaoColaboradorDAO {
//    private Connection connection;
//    private Colaborador colaborador;
//    private Permissao permissao;
//
//    public PermissaoColaboradorDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void cadastrarPermissaoColaborador(Integer codigoColaborador, Integer codigoPermissao) {
//        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
//            PreparedStatement stmValidation = connection.prepareStatement(
//                    "INSERT INTO COLABORADOR_PERMISSAO (" +
//                            "CODIGOCOLABORADOR, CODIGOPERMISSAO) VALUES (?, ?)");
////                    "SELECT CODIGOPERMISSAO FROM COLABORADOR_PERMISSAO " +
////                            "WHERE CODIGOPERMISSAO = ?");
//            stmValidation.setInt(1, codigoColaborador);
//            stmValidation.setInt(2, codigoPermissao);
//            ResultSet resultadoValidation = stmValidation.executeQuery();
//            if (resultadoValidation.next()) {
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
////    public void validacaoPermissaoColaborador(Integer permissao, Integer colaborador) {
////         try (Connection connection = new ConnectionFactory().recuperarConexao()) {
////            PreparedStatement stm = connection.prepareStatement(
////                    "INSERT INTO COLABORADOR_PERMISSAO (" +
////                            "CODIGOPERMISSAO_PERMISSAO, CODIGOCOLABORADOR_COLABORADOR) VALUES (?, ?)");
////            stm.setInt(1, permissao);
////            stm.setInt(2, colaborador);
////
////            stm.execute();
////            connection.close();
////
////        } catch (SQLException | ClassNotFoundException e) {
////            e.printStackTrace();
////        }
////    }
//
//    public void excluirPermissaoColaborador(Integer codigoColaborador, Integer codigoPermissao) {
//         try (Connection connection = new ConnectionFactory().recuperarConexao()) {
//                PreparedStatement stm = connection.prepareStatement(
//                "DELETE FROM COLABORADOR_PERMISSAO WHERE (" +
//                        "CODIGOCOLABORADOR, CODIGOPERMISSAO) = (?, ?)"); {
//            stm.setInt(1, codigoColaborador);
//            stm.setInt(2, codigoPermissao);
//
//            stm.execute();
//
//        }
//    } catch (SQLException | ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//
////    public List<Permissao> listarPermissaoColaborador() throws SQLException {
////        Colaborador colaborador = null;
////        List<Permissao> listas = new ArrayList<>();
////
////
////        String sql = "select veiculo_pneu.id_veiculo as id_veiculo,\n" +
////                "       veiculo_pneu.id_pneu    as id_pneu,\n" +
////                "       v.placa                 as placa,\n" +
////                "       v.qtd_maxima_pneus      as qtd_maxima_pneus,\n" +
////                "       v.cod_marca             as marca,\n" +
////                "       mv.nome                 as nome_marca,\n" +
////                "       p.numero_pneu           as numero_pneu,\n" +
////                "       p.preco_compra          as preco\n" +
////                "from veiculo_pneu\n" +
////                "         inner join veiculo v on veiculo_pneu.id_veiculo = v.id\n" +
////                "         inner join marca_veiculo mv on v.cod_marca = mv.id\n" +
////                "         inner join pneu p on veiculo_pneu.id_pneu = p.id;";
////
////        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
////            pstm.execute();
////
////            try (ResultSet rst = pstm.getResultSet()) {
////                while (rst.next()) {
////                    int idVeiculo = rst.getInt(1);
////                    int idPneu = rst.getInt(2);
////                    String placa = rst.getString(3);
////                    int qtadeMaxPneu = rst.getInt(4);
////                    int idMarca = rst.getInt(5);
////                    String nomeMarca = rst.getString(6);
////                    String numeroPneu = rst.getString(7);
////                    Double precoPneu = rst.getDouble(8);
////
////
////                    if (veiculo == null || !veiculo.equals(rst.getString(2))) {
////                        MarcaVeiculoT1 marca = new MarcaVeiculoT1(idMarca, nomeMarca);
////                        VeiculoT1 veiculoT1 = new VeiculoT1(idVeiculo, placa, qtadeMaxPneu, marca);
////
////                        veiculo = veiculoT1;
////                        veiculo.mostrarDados();
////                    }
////                    PneuT1 pneu = new PneuT1(idPneu, numeroPneu, precoPneu);
////
////                    veiculo.addPneu(pneu);
////
////                }
////            }
////            return listas;
////        }
////    }
////}
//
//}
//
//}
//
