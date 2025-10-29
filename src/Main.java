import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String pass = "";
        System.out.println("Enter a number");
int num1= input.nextInt();
switch(num1) {
    case 1:
        System.out.println("Adding a student");
        break;

    case 2:
        System.out.println("Reading a student");
        break;

        case 3:
            System.out.println("Updating a student");
            break;

    case 4:
        System.out.println("Deleting a student");
        break;

        default:
            System.out.println("Invalid input");

}
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Connected to Database Successfully!");
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

            PreparedStatement pst2 = con.prepareStatement("SELECT * FROM students");
            while (pst2.executeQuery().next()) {
                System.out.println(pst2.executeQuery().getString("name"));
                System.out.println(pst2.executeQuery().getInt("age"));
                System.out.println(pst2.executeQuery().getInt("course"));
            }

            PreparedStatement pst3 = con.prepareStatement("SELECT * FROM students WHERE name = ?");
            pst3.setString(1, "NishchalAcharya");
            pst3.setString(2, "java");
            ResultSet rs = pst3.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getString("course"));
            }


            con.close();
        } catch (Exception e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
        }

    }
}
