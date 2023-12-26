package Vazifalar;

import java.sql.*;
import java.util.Scanner;

public class service {

    static class _connection {
        private static final String url = "jdbc:postgresql://localhost/uyga_vazifa";
        private static final String user = "postgres";
        private static final String password = "bj";

        public static Connection connect() throws SQLException {
            return DriverManager.getConnection(url,user,password);
        }
    }

    public static void start_up_menu() throws SQLException {
        System.out.printf("\n\n1.insert\n2.show\n3.exit\n-> ");
        int choice = new Scanner(System.in).nextInt();
        switch (choice){
            case 1:
                insertDetail();
                break;
            case 2:
                showDetail();
                break;
            case 3:
                break;
        }
        start_up_menu();
    }
    public static void showDetail() {
        String querry;
        System.out.printf("\n\n1.show candidates\n2.show companies\n3.show all candidates(also no data candidates)\n-> ");
        int choice = new Scanner(System.in).nextInt();
        switch (choice){
            case 1:
                querry = """
                            
                        select u_user.id as id,username,age,address,information,linkedin_link,skill_name,level,job_title,company_name,school_name,education.from_date as edfrom,history.to_date as edto
                                                                                                                      from u_user inner join public.candidate_resume resume on u_user.id = resume.candidate_id
                                                                                                                                  inner join public.candidate_skills skills on resume.id = skills.resume_id
                                                                                                                                  inner join public.candidate_education education on u_user.id = education.candidate_id
                                                                                                                                  inner join public.candidate_job_history history on u_user.id = education.candidate_id;
                            """;
                try (Connection connection = _connection.connect();
                     Statement statement = connection.createStatement();
                     ResultSet rs = statement.executeQuery(querry)) {
                    if(rs.next()) {
                            while (rs.next()) {
                                System.out.println(rs.getString("id") + "\n "
                                        + rs.getString("username") + "\t"
                                        + rs.getString("age") + "\t"
                                        + rs.getString("address") + "\t"
                                        + rs.getString("information") + "\t"
                                        + rs.getString("linkedin_link") + "\t"
                                        + rs.getString("skill_name") + "\t"
                                        + rs.getString("level") + "\t"
                                        + rs.getString("job_title") + "\t"
                                        + rs.getString("company_name") + "\t"
                                        + rs.getString("school_name") + "\t"
                                        + rs.getString("edfrom") + "\t"
                                        + rs.getString("edto") + "\n\n"

                                );
                            }
                    }else{
                        System.out.println("null");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                querry = "select * from company_description";
                try (Connection connection = _connection.connect();
                     Statement statement = connection.createStatement();
                     ResultSet rs = statement.executeQuery(querry)) {
                    while (rs.next()) {
                        System.out.println(rs.getString("id") + "\n "
                                + rs.getString("company_id") + "\t"
                                + rs.getString("information_text") + "\t"
                                + rs.getString("website_link") + "\t"
                                + rs.getString("main_office_location") + "\t"
                                + rs.getString("number_of_worker") + "\t"
                                + rs.getString("owner") + "\n\n"
                        );
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                querry = "select * from u_user";
                try (Connection connection = _connection.connect();
                     Statement statement = connection.createStatement();
                     ResultSet rs = statement.executeQuery(querry)) {
                    while (rs.next()) {
                        System.out.println(rs.getString("id") + "\n "
                                + rs.getString("username") + "\t"
                                + rs.getString("phone") + "\t"
                                + rs.getString("email") + "\t"
                                + rs.getString("role") + "\n\n"
                        );
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }
    public static void insertDetail() throws SQLException {
        Connection connection = _connection.connect();
        PreparedStatement statement;
        String querry;
        System.out.printf("\n\n1.insert candidates\n2.insert companies\n-> ");
        int choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1:
                System.out.println("ENTERING RESUME TABLE...  ");
                querry = "insert into candidate_resume(candidate_id,information,linkedin_link,address,age) values(?,?,?,?,?)";
                statement = connection.prepareStatement(querry);
                System.out.printf("candidate_id: ");
                int candidate_id = new Scanner(System.in).nextInt();
                statement.setInt(1, candidate_id);

                System.out.printf("information about you: ");
                String info = new Scanner(System.in).nextLine();
                statement.setString(2, info);

                System.out.printf("linkedin link(should starts with https://www.linkedin.com/): ");
                String linkedin = new Scanner(System.in).nextLine();
                statement.setString(3, linkedin);

                System.out.printf("address: ");
                String address = new Scanner(System.in).nextLine();
                statement.setString(4, address);

                System.out.printf("age: ");
                int age = new Scanner(System.in).nextInt();
                statement.setInt(5, age);

                statement.executeUpdate();

                System.out.println("ENTERING SKILLS TABLE...  ");
                querry = "insert into candidate_skills(resume_id,skill_name,level) values(?,?,?)";

                statement = connection.prepareStatement(querry);
                int choice2;
                do {
                    System.out.printf("resume id: ");
                    int resume_id = new Scanner(System.in).nextInt();
                    statement.setInt(1, resume_id);

                    System.out.printf("skill name: ");
                    String skill = new Scanner(System.in).nextLine();
                    statement.setString(2, skill);

                    System.out.printf("level: ");
                    int lv = new Scanner(System.in).nextInt();
                    statement.setInt(3, lv);
                    statement.executeUpdate();
                    System.out.printf("yana qo'shasizmi ?[1/0]: ");
                    choice2 = new Scanner(System.in).nextInt();
                } while (choice2 != 0);

                System.out.println("ENTERING JOB HISTORY TABLE...  ");

                querry = "insert into candidate_job_history(candidate_id,job_title,company_name,from_date,to_date,information_about_job) values(?,?,?,?::date,?::date,?)";
                statement = connection.prepareStatement(querry);
                System.out.printf("candidate_id: ");
                int candidate_id2 = new Scanner(System.in).nextInt();
                statement.setInt(1, candidate_id2);

                System.out.printf("job_title: ");
                String job_title = new Scanner(System.in).nextLine();
                statement.setString(2, job_title);

                System.out.printf("company name: ");
                String company = new Scanner(System.in).nextLine();
                statement.setString(3, company);

                System.out.printf("enter started date (format: 2023-12-26) : ");
                String from_date = new Scanner(System.in).nextLine();
                statement.setString(4, from_date);

                System.out.printf("enter ended date (format: 2023-12-26) : ");
                String to_date = new Scanner(System.in).nextLine();
                statement.setString(5, to_date);

                System.out.printf("info about the job: ");
                String about = new Scanner(System.in).nextLine();
                statement.setString(6, about);

                statement.executeUpdate();

                System.out.println("ENTERING EDUCATION TABLE...  ");

                querry = "insert into candidate_education(candidate_id,school_name,from_date,to_date,about_courses) values(?,?,?::date,?::date,?)";
                statement = connection.prepareStatement(querry);
                System.out.printf("candidate_id: ");
                int candidate_id3 = new Scanner(System.in).nextInt();
                statement.setInt(1, candidate_id3);

                System.out.printf("school name: ");
                String school = new Scanner(System.in).nextLine();
                statement.setString(2, school);

                System.out.printf("enter started date (format: 2023-12-26) : ");
                String from_date2 = new Scanner(System.in).nextLine();
                statement.setString(3, from_date2);

                System.out.printf("enter ended date (format: 2023-12-26) : ");
                String to_date2 = new Scanner(System.in).nextLine();
                statement.setString(4, to_date2);

                System.out.printf("info about the courses: ");
                String course = new Scanner(System.in).nextLine();
                statement.setString(5, course);

                statement.executeUpdate();

                break;
            case 2:
                querry ="insert into u_user(company_id, information_text, website_link,main_office_location,number_of_workers,owner) values(?,?,?,?,?,?)";
                try (PreparedStatement statement2 = connection.prepareStatement(querry)){
                    System.out.printf("company id: ");
                    int companyID = new Scanner(System.in).nextInt();
                    statement2.setInt(1,companyID);

                    System.out.printf("information : ");
                    String information = new Scanner(System.in).nextLine();
                    statement2.setString(2,information);

                    System.out.printf("website link: ");
                    String website = new Scanner(System.in).nextLine();
                    statement2.setString(3,website);

                    System.out.printf("main office location: ");
                    String location = new Scanner(System.in).nextLine();
                    statement2.setString(4,location);

                    System.out.printf("number of workers: ");
                    int workers = new Scanner(System.in).nextInt();
                    statement2.setInt(5,workers);

                    System.out.printf("owner name: ");
                    String owner = new Scanner(System.in).nextLine();
                    statement2.setString(3,owner);

                    statement2.executeUpdate();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        System.out.println("  Data Successfully Added ");
    }

    public static void main(String[] args) throws SQLException {
        start_up_menu();
    }

}
