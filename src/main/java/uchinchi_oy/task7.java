package uchinchi_oy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class task7 {
    public static void showDetail(){
        String querry = "SELECT * FROM xodimlar";
        try (Connection connection = new DB_connection().connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(querry)){
            while (rs.next()){
                System.out.println(rs.getString("ism") + "\t"
                        + rs.getString("yosh") + "\t"
                        + rs.getString("email") + "\t"
                        + rs.getString("phone") + "\n"
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        showDetail();
    }
}
