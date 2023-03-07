package utils;

import SQLEntity.User;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class BaseDAO {
    protected int update(String sql, Object... args) throws SQLException {
        Connection connection = JDBCUtilV2.getConnection();
//        String sql = "insert into t_user (account, password, nickname) values (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置占位符的值
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        int result = preparedStatement.executeUpdate();

        if (connection.getAutoCommit()) {
            JDBCUtilV2.freeConnection();
        } else {
            connection.close();
        }
        preparedStatement.close();

        return result;
    }

    protected <T> ArrayList<T> query(Class<T> tClass, String sql, Object... args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Connection connection = JDBCUtilV2.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置占位符的值
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        ArrayList<T> result = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (resultSet.next()) {
            T t = tClass.newInstance();
            for (int i = 0; i < columnCount; i++) {
                String columnName = metaData.getColumnName(i + 1);
                Object columnValue = resultSet.getObject(columnName);
                Field field = tClass.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            result.add(t);
        }
        return result;
    }

    @Test
    public void testUpdate() throws SQLException {
        int update = update("insert into t_user (account, password, nickname) values (?, ?, ?);",
                "lvdandan2", "123456", "lvdandan");
        System.out.println("update = " + update);
    }

    @Test
    public void testQuery() throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        ArrayList<User> users = query(User.class, "select * from t_user where id = ?;", 5018);
        System.out.println("users = " + users);
    }
}
