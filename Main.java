import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("テストです");

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/tododb";
        String user = "root";
        String password = "password";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, title, done FROM todo")
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                boolean done = rs.getBoolean("done");

                System.out.println(id + " : " + title + " : " + done);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}