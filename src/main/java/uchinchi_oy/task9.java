package uchinchi_oy;

import java.sql.*;
import java.util.Scanner;

public class task9 {
    static void updateTB(){
        String query = "UPDATE xodimlar set ism = ? WHERE id = ?";
        try (Connection connection = new DB_connection().connect();
             PreparedStatement statement = connection.prepareStatement(query)){
            System.out.printf("ismni kiriting: ");
            String newname = new Scanner(System.in).nextLine();
            System.out.printf("id ni kiriting: ");
            int id = new Scanner(System.in).nextInt();
            statement.setString(1,newname);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void showDetail(){
        String querry = "SELECT * FROM xodimlar";
        try (Connection connection = new DB_connection().connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(querry)){
            while (rs.next()){
                System.out.println(rs.getString("id") + "\t"
                        +rs.getString("ism") + "\t"
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
        updateTB();
    }
}
