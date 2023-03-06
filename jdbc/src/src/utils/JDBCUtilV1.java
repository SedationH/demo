package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilV1 {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(
                    JDBCUtilV1.class.getClassLoader().getResourceAsStream("druid.properties")
            );
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void freeConnection(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        connection.close();
    }

    @Test
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        freeConnection(connection);
    }
}
