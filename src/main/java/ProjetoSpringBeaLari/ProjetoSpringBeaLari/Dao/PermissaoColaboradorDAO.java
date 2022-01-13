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




//    public PermissaoColaborador cadastrarPermissaoColaborador(Colaborador colaborador) {
//        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
//            PreparedStatement stm = connection.prepareStatement("INSERT INTO COLABORADOR_PERMISSAO (" +
//                    " CODIGOCOLABORADOR, CODIGOPERMISSAO) VALUES (?, ?) RETURNING CODIGOCOLABORADOR, CODIGOPERMISSAO");
//            stm.setInt(1, permissaoColaborador.get());
//            stm.setInt(2, permissao.getCodigoPermissao());
//            stm.execute();
//            ResultSet rst = stm.getResultSet();
//            while (rst.next()) {
//                int codigoColaborador = rst.getInt("CODIGOCOLABORADOR");
//                colaborador.setCodigoColaborador(codigoColaborador);
//                PermissaoColaborador permissaoColaborador = new PermissaoColaborador (codigoColaborador, codigoPermissao);
//                colaboradores.add(permissaoColaborador);
//            }
//            return colaborador;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}


//    public ArrayList<PermissaoColaborador> listAllPermissaoColaboradores() {
//        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
//            PreparedStatement stm = connection.prepareStatement("SELECT codigocolaborador, codigopermissao FROM Colaborador_Permissao");
//            stm.executeQuery();
//            ResultSet rst = stm.getResultSet();
//            ArrayList<PermissaoColaborador> permissoesColaboradores = new ArrayList<PermissaoColaborador>();
//            while(rst.next()) {
//                int codigoColaborador = rst.getInt("CODIGOCOLABORADOR");
//                int codigoPermissao = rst.getInt("CODIGOPERMISSAO");
//
//                PermissaoColaborador permissaoColaborador = new PermissaoColaborador(codigoColaborador, codigoPermissao);
//                permissoesColaboradores.add(permissaoColaborador);
//            }
//            if (permissoesColaboradores.size() > 0) {
//                return permissoesColaboradores;
//            }
//
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Colaborador findByCodigoPermissaoColaborador(int idColaborador) {
//        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
//            PreparedStatement stm = connection.prepareStatement("SELECT codigocolaborador, nomecolaborador,"
//                    + " datanascimento, qtdmaxpermissoes FROM public.colaborador WHERE codigocolaborador= (?)");
//            stm.setInt(1, idColaborador);
//            stm.executeQuery();
//            ResultSet rst = stm.getResultSet();
//            Colaborador colaborador = null;
//            while(rst.next()) {
//                int codigoColaborador = rst.getInt("CODIGOCOLABORADOR");
//                String nomecolaborador = rst.getString("nomecolaborador");
//                String datanascimento = rst.getString("datanascimento");
//                int qtdmaxpermissoes = rst.getInt("qtdmaxpermissoes");
//                colaborador = new Colaborador(codigoColaborador, nomecolaborador, datanascimento, qtdmaxpermissoes);
//            }
//            return colaborador;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
//
//
//

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
//    public void addPneuNoVeiculo(Integer pneu, Integer veiculo) {
//        try {
//            PreparedStatement stmValidation = connection.prepareStatement("SELECT COLABORADOR_PERMISSAO FROM CODIGOCOLABORADOR, CODIGOPERMISSAO WHERE CODIGOCOLABORADOR = ?");
//            stmValidation.setInt(1, pneu);
//            ResultSet resultadoValidation = stmValidation.executeQuery();
//            if (resultadoValidation.next()) {
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteById(Integer codigoColaborador, Integer codigoPermissao) {
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

