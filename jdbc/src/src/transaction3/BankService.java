package transaction3;

import org.junit.Test;
import utils.JDBCUtilV1;
import utils.JDBCUtilV2;

import java.sql.Connection;
import java.sql.SQLException;

public class BankService {
    public void transfer(String from, String to, int money) throws ClassNotFoundException, SQLException, SQLException {
        // 一个事务的最基本要求，必须是一个 connection
        // 一个转账的过程，必须是一个事务
        Connection connection = JDBCUtilV2.getConnection();
        System.out.println(connection);

        try {
            // 关闭事务的自动提交
            connection.setAutoCommit(false);
            BankDAO bankDAO = new BankDAO();
            // 其实应该先减去，为了测试事务，先加上
            bankDAO.add(to, money);
            bankDAO.sub(from, money);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }
    }

    @Test
    public void testTransfer() throws ClassNotFoundException, SQLException {
        transfer("lvdandan", "ergouzi", 9);
    }
}
