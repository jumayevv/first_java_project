package uchinchi_oy;

import java.sql.*;
import java.util.Scanner;

public class array_crud {

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
                exit();
                break;

        }
    }
    public static void showDetail() {
        String querry = "SELECT * FROM store";
        try (Connection connection = _connection.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(querry)) {
            while (rs.next()) {
                System.out.println(rs.getString("id") + "\n "
                        + rs.getString("name") + "\t"
                        + rs.getString("tags") + "\n"
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertDetail(){
        String querry1 = "INSERT INTO store(name,tags) VALUES(?,?)";
        try (Connection connection = _connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry1)){
            Scanner sc = new Scanner(System.in);
            System.out.printf("name: ");
            String name = sc.nextLine();
            statement.setString(1,name);
            System.out.printf("size of tags: ");
            int size = new Scanner(System.in).nextInt();
            String[] tags = new String[size];
            for (int i = 0; i < size; i++) {
                System.out.printf("-> ");
                String tag = sc.next()+sc.nextLine();
                tags[i] = tag;
            }
            Array all_tags = _connection.connect().createArrayOf("text",tags);
            statement.setArray(2,all_tags);
            statement.executeUpdate();
            System.out.println("  Data Successfully Added ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateDetail(){
        String querry = "UPDATE store SET tags=array_append(tags,?) WHERE id=?";
        try (Connection connection = _connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry)){
            System.out.printf("enter new tag: ");
            String new_tag = new Scanner(System.in).nextLine();
            statement.setString(1,new_tag);
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
        String querry = "UPDATE store SET tags=array_remove(tags,?) WHERE id=?";
        try (Connection connection = _connection.connect();
             PreparedStatement statement = connection.prepareStatement(querry)){

            System.out.printf("enter tag: ");
            String tag = new Scanner(System.in).nextLine();
            statement.setString(1,tag);
            System.out.printf("id: ");
            int id = new Scanner(System.in).nextInt();
            statement.setInt(2 ,id);
            statement.executeUpdate();
            System.out.println("    Data Successfully Deleted ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void exit(){
        System.out.println("System off");
    }

    public static void main(String[] args) {
        start_up_menu();
    }

}
