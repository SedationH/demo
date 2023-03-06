package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
    这个工具类的作用就是用来给所有的SQL操作提供“连接”，和释放连接。
    这里使用ThreadLocal的目的是为了让同一个线程，在多个地方getConnection得到的是同一个连接。
    这里使用DataSource的目的是为了（1）限制服务器的连接的上限（2）连接的重用性等
 */
public class JDBCUtilV2 {
    private static DataSource dataSource;

    //    对于同一个static ThreadLocal，
    //    不同线程只能从中get，set，remove自己的变量，而不会影响其他线程的变量。
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        try {
            properties.load(
                    JDBCUtilV2.class.getClassLoader().getResourceAsStream("druid.properties")
            );
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void freeConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection != null) {
            threadLocal.remove();
            // 避免还给数据库连接池的连接不是自动提交模式
            connection.setAutoCommit(true);
            connection.close();
        }
    }

    @Test
    public void test() throws SQLException {
        dataSource.getConnection();
        freeConnection();
    }
}
