package uchinchi_oy;

import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class open_db {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password= "bj";

        try (Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement()){
            statement.execute("create database myj_database");
            System.out.println("success");
        }catch (PSQLException e){
            e.printStackTrace();
        }

    }
}
