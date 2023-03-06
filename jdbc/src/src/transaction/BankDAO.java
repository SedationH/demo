package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DAO = Data Access Object
 * 数据库访问对象
 */
public class BankDAO {
    public void add(String account, int money, Connection connection) throws ClassNotFoundException, SQLException {
        String sql = "update t_bank set money = money + ? where account = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, money);
        preparedStatement.setObject(2, account);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("add");
    }

    public void sub(String account, int money, Connection connection) throws ClassNotFoundException, SQLException {
        String sql = "update t_bank set money = money - ? where account = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, money);
        preparedStatement.setObject(2, account);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        System.out.println("sub");
    }
}
