package uchinchi_oy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_connection {
    private static final String url = "jdbc:postgresql://localhost/poligon";
    private static final String user = "postgres";
    private static final String password = "bj";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
}
