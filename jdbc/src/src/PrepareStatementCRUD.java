import org.junit.Test;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrepareStatementCRUD {
    @Test
    public void testInsert() throws ClassNotFoundException, SQLException {
        /**
         * t_user 插入一条数据
         *  account test
         *  password test
         *  nickname 二狗子
         */

        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "password");
        // 获取操作数据库的预处理对象
        String sql = "insert into t_user (account, password, nickname) values (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setObject(1, "test");
        preparedStatement.setObject(2, "test");
        preparedStatement.setObject(3, "二狗子");
        // 执行 SQL 语句
        int rows = preparedStatement.executeUpdate();
        // 处理结果
        if (rows > 0) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
        // 释放资源
        connection.close();
        preparedStatement.close();

    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        // 修改 id 为 3 的用户的昵称为 三狗子
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "password");
        String sql = "update t_user set nickname = ? where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, "三狗子");
        preparedStatement.setObject(2, 3);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
        connection.close();
        preparedStatement.close();
    }

    @Test
    public void testQuery() throws ClassNotFoundException, SQLException {
        // 查询所有用户 并且封装到一个 List<Map> list 集合中
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "password");
        String sql = "select * from t_user;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<Map> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                // getColumnLabel 获取列的别名, 没有别名就获取列名，常常我们使用别名
                String columnLabel = metaData.getColumnLabel(i);
                // 可以用 columnName，也可以用 i
                Object columnValue = resultSet.getObject(columnLabel);
                map.put(columnLabel, columnValue);
            }
            list.add(map);
        }
        System.out.println(list);
    }
}
