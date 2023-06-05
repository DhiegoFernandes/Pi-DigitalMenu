package br.digitalmenu.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private static HikariDataSource hds = null;

    public Connection recuperarConexao() {

        try {
            if (hds == null) {
                hds = createDataSource();
            }
            return hds.getConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://localhost:3306/digitalmenu");
        config.setUsername("root");
        config.setPassword("123456");

        config.setMaximumPoolSize(20);
        return new HikariDataSource(config);
    }

}
