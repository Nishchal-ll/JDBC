import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String pass = "";

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
