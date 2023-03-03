import org.junit.Test;

import java.sql.*;

public class SQOther {
    @Test
    public void getPrimaryKey() throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "password");
        // 获取操作数据库的预处理对象
        String sql = "insert into t_user (account, password, nickname) values (?, ?, ?);";
        // PreparedStatement.RETURN_GENERATED_KEYS 会返回自增主键的值
        PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        // 设置参数
        preparedStatement.setObject(1, "test3");
        preparedStatement.setObject(2, "test");
        preparedStatement.setObject(3, "二狗子");
        // 执行 SQL 语句
        int rows = preparedStatement.executeUpdate();
        // 处理结果
        if (rows > 0) {
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Object id = generatedKeys.getObject(1);
                System.out.println("插入成功！id = " + id);
            }
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
        // 释放资源
        connection.close();
        preparedStatement.close();
    }

    @Test
    public void batchUpdateDemo1() throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "password");
        // 获取操作数据库的预处理对象
        String sql = "insert into t_user (account, password, nickname) values (?, ?, ?);";
        // PreparedStatement.RETURN_GENERATED_KEYS 会返回自增主键的值
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int cnt = 1000;
        int rows = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt; i++) {
            // 设置参数
            preparedStatement.setObject(1, i + "test");
            preparedStatement.setObject(2, "test");
            preparedStatement.setObject(3, "二狗子");
            // 添加到批处理
            int row = preparedStatement.executeUpdate();
            rows += row;
        }
        long end = System.currentTimeMillis();
        // 耗时：635ms
        System.out.println("耗时：" + (end - start) + "ms");
        // 处理结果
        if (rows == cnt) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
        // 释放资源
        connection.close();
        preparedStatement.close();
    }

    @Test
    public void batchUpdateDemo2() throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "password");
        // 获取操作数据库的预处理对象
        String sql = "insert into t_user (account, password, nickname) values (?, ?, ?)";
        // PreparedStatement.RETURN_GENERATED_KEYS 会返回自增主键的值
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int cnt = 1000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt; i++) {
            // 设置参数
            preparedStatement.setObject(1, i + "atest");
            preparedStatement.setObject(2, "test");
            preparedStatement.setObject(3, "二狗子");
            // 添加到批处理
            preparedStatement.addBatch(); // 追加 value 到批处理
        }
        int[] rows = preparedStatement.executeBatch();
        long end = System.currentTimeMillis();
        // 耗时：635ms
        System.out.println("耗时：" + (end - start) + "ms");
        System.out.println("rows = " + rows);
        // 释放资源
        connection.close();
        preparedStatement.close();
    }
}
