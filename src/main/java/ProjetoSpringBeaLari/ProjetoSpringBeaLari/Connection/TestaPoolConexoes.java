package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Connection;

import java.sql.SQLException;

public class TestaPoolConexoes {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 0; i < 20; i++) {
            connectionFactory.recuperarConexao();
            System.out.println("Conexão de número: " + i);
        }
    }
}

