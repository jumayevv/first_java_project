package uchinchi_oy;

import java.sql.*;

public class task8 {
    static void createTB(){
        String query = "UPDATE studentlar set name = ? WHERE id = ?";
        try (Connection connection = new DB_connection().connect();
             PreparedStatement statement = connection.prepareStatement(query)){
                 statement.setString(1,"Sanjarbek");
                 statement.setInt(2,1);
                statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        createTB();
    }
}
