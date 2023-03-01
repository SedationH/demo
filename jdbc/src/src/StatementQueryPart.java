
// add description here

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class StatementQueryPart {
    public static void main(String[] args) throws SQLException {
        // 注册驱动
        DriverManager.registerDriver(new Driver());
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "password");
        // 创建 Statement
        Statement statement = connection.createStatement();
        // 执行 SQL
        String sql = "SELECT * FROM t_user;";
        ResultSet resultSet = statement.executeQuery(sql);
        // 处理结果
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String account = resultSet.getString("account");
            System.out.println("id: " + id + ", account: " + account);
        }
        // 关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
