package transaction;

import utils.JDBCUtilV2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DAO = Data Access Object
 * 数据库访问对象
 */
public class BankDAO {
    public void add(String account, int money) throws SQLException {
        Connection connection = JDBCUtilV2.getConnection();
        System.out.println(connection);
        String sql = "update t_bank set money = money + ? where account = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, money);
        preparedStatement.setObject(2, account);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("add");
    }

    public void sub(String account, int money) throws ClassNotFoundException, SQLException {
        Connection connection = JDBCUtilV2.getConnection();
        System.out.println(connection);
        String sql = "update t_bank set money = money - ? where account = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, money);
        preparedStatement.setObject(2, account);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        System.out.println("sub");
    }
}
