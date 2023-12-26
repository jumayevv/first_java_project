import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class default_CRUD {

    static class _connection {
        private static final String url = "jdbc:postgresql://localhost/poligon";
        private static final String user = "postgres";
        private static final String password = "bj";

        public static Connection connect() throws SQLException {
            return DriverManager.getConnection(url,user,password);
        }
    }

    public static void start_up_menu(){
        System.out.printf("\n\n1.create\n2.show\n3.update\n4.delete\n5.exit\n-> ");
        int choice = new Scanner(System.in).nextInt();
        switch (choice){
            case 1:
                insertDetail();
                start_up_menu();
            case 2:
                showDetail();
                start_up_menu();
            case 3:
                updateDetail();
                start_up_menu();
            case 4:
                deleteDetail();
                start_up_menu();
            case 5:
                break;

        }
    }
    public static void showDetail() {
        String querry = "SELECT * FROM table_name ORDER BY id";
        try (Connection connection = _connection.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(querry)) {
            while (rs.next()) {
                System.out.println(rs.getString("id") + "\n "
                        + rs.getString("name") + "\t"
                        + rs.getString("price") + "\t"
                        + rs.getString("expiration_date") + "\t"
                        + rs.getString("is_valid") + "\n"
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertDetail(){
        String querry1 = "INSERT INTO table_name() VALUES(?)";
        try (Connection connection = _connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry1)){
            System.out.printf("name: ");
            String name = new Scanner(System.in).nextLine();
            statement.setString(1,name);

            System.out.printf("its price(in float type with 7 length and 2 decimals): ");
            float price = new Scanner(System.in).nextFloat();
            statement.setFloat(2,price);

            System.out.printf("created date: ");
            String created_date = new Scanner(System.in).nextLine();
            statement.setDate(3, Date.valueOf(created_date));

            statement.executeUpdate();
            System.out.println("  Data Successfully Added ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateDetail(){
        String querry = "UPDATE table_name SET name=? WHERE id=?";
        try (Connection connection = _connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry)){
            System.out.printf("enter new name: ");
            String new_name = new Scanner(System.in).nextLine();
            statement.setString(1,new_name);
            System.out.printf("id: ");
            int id = new Scanner(System.in).nextInt();
            statement.setInt(2,id);
            statement.executeUpdate();
            System.out.println("  Data Successfully Updated ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteDetail(){
        String querry = "DELETE FROM ? WHERE id=?";
        try (Connection connection = _connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry)){
            System.out.printf("id: ");
            int id = new Scanner(System.in).nextInt();
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("    Data Successfully Deleted ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        start_up_menu();
    }

}
