import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("テストです");

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/tododb";
        String user = "appuser";
        String password = "app_pass";

        Connection conn = DriverManager.getConnection(url, user, password);
        // conn DBとつながっている変数
        // DB操作をしたい場合はconnに命令する

        Statement stmt = conn.createStatement();
        // クエリ使えるよモードになった変数stmt

        ResultSet rs = stmt.executeQuery("SELECT * FROM todo");
        // クエリを実行して結果をrsに入れる
        // [
        //   [1, todoテスト１],
        //   [2, todoテスト２]
        // ]

        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            System.out.println(id + ": " + title);
        }
    }
}