import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("テストです");

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/tododb";
        String user = "appuser";
        String password = "app_pass";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, title FROM todo")
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");

                System.out.println(id + " : " + title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}