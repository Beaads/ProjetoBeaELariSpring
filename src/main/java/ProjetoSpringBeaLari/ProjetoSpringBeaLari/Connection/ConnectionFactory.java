package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public DataSource dataSource;

    public ConnectionFactory() throws ClassNotFoundException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "12345678");
        comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        comboPooledDataSource.setUser("postgres");
        comboPooledDataSource.setPassword("12345678");

        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() throws SQLException {
        return this.dataSource.getConnection();
    }
}

