import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String pass = "";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Connected to Database Successfully!");
            Scanner input = new Scanner(System.in);

            System.out.println("✅ Connected to Database Successfully!");

            System.out.println("\n1. Add Student");
            System.out.println("2. Read Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline
            switch(choice) {
                case 1:
                    System.out.println("Adding a student");
                    PreparedStatement pst = con.prepareStatement("INSERT INTO students (name, age, course) VALUES (?, ?,?)");
                    pst.setString(1, "NishchalAcharya");
                    pst.setInt(2, 23);
                    pst.setString(3, "java");
                    int i = pst.executeUpdate();
                    if (i > 0) {
                        System.out.println("Data Inserted Successfully!");
                    }
                    else {
                        System.out.println("Data Insert Failed!");
                    }
                    break;

                case 2:
                    System.out.println("Reading a student");
                    System.out.println("Showing a student");
                    PreparedStatement pst2 = con.prepareStatement("SELECT * FROM students");
                    while (pst2.executeQuery().next()) {
                        System.out.println(pst2.executeQuery().getString("name"));
                        System.out.println(pst2.executeQuery().getInt("age"));
                        System.out.println(pst2.executeQuery().getInt("course"));
                    }

                    break;

                case 3:
                    System.out.println("Updating a student");
                    PreparedStatement pst3 = con.prepareStatement("SELECT * FROM students WHERE name = ?");
                    pst3.setString(1, "NishchalAcharya");
                    ResultSet rs = pst3.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getString("name"));
                        System.out.println(rs.getInt("age"));
                        System.out.println(rs.getString("course"));
                    }
                    break;

                case 4:
                    System.out.println("Deleting a student");
                    PreparedStatement pst4 = con.prepareStatement("DELETE FROM students WHERE name = ?");
                    pst4.setString(1, "NishchalAcharya");
                    System.out.println(pst4.executeUpdate());

                    break;


                default:
                    System.out.println("Invalid input");

            }
            con.close();
        } catch (Exception e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
        }

    }
}
