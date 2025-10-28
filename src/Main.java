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
            con.close();
        } catch (Exception e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
        }

    }
}
