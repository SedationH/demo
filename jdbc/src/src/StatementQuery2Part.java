import java.sql.*;
import java.util.Scanner;

public class StatementQuery2Part {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号：");
        String account = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        scanner.close();

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "password");
        Statement statement = connection.createStatement();
        String sql = "SELECT * from t_user where account = '" + account + "' and password = '" + password + "' ;";
        System.out.println(sql);
        // 会有 SQL 注入问题 用 PreparedStatement 解决
//        请输入账号：
//        d
//        请输入密码：
//        ' or '1' = '1
//        SELECT * from t_user where account = 'd' and password = '' or '1' = '1' ;
//        登录成功！
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
    }
}