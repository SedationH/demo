package druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Demo1 {
    @Test
    public void hardCode() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();

        //设置四个必须参数
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        String url = "jdbc:mysql://localhost:3306/atguigu";
        dataSource.setUrl(url);
        //获取连接
        Connection connection = dataSource.getConnection();
        // JDBC的步骤
        //回收连接
        connection.close();
    }

    @Test
    public void configCode() throws Exception {
        Properties properties = new Properties();
        InputStream resourceAsStream = Demo1.class.getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
        //回收连接url
        connection.close();
    }
}
