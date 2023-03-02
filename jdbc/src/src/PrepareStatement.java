import java.sql.*;
import java.util.Scanner;

public class PrepareStatement {
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
        String sql = "select  * from  t_user where account = ? and password = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, account);
        preparedStatement.setObject(2, password);
        System.out.println(preparedStatement);
        // prepareStatement 会理解 SQL 的结构，不会有 SQL 注入问题

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
    }
}
