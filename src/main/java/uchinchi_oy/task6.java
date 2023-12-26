package uchinchi_oy;

import java.net.ConnectException;
import java.sql.*;

public class task6 {

    public static void showBooks(){
        String querry = "SELECT * FROM xabar";
        try (Connection connection = new DB_connection().connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(querry)){
            while (rs.next()){
                System.out.println(rs.getString("id") + "\t"
                        + rs.getString("title") + "\n"
                        + rs.getString("content"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        showBooks();
    }
}
