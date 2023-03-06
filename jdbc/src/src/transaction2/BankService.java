package transaction2;

import org.junit.Test;
import utils.JDBCUtilV1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankService {
    public void transfer(String from, String to, int money) throws ClassNotFoundException, SQLException, SQLException {
        // 一个事务的最基本要求，必须是一个 connection
        // 一个转账的过程，必须是一个事务
        Connection connection = JDBCUtilV1.getConnection();

        try {
            // 关闭事务的自动提交
            connection.setAutoCommit(false);
            BankDAO bankDAO = new BankDAO();
            // 其实应该先减去，为了测试事务，先加上
            bankDAO.add(to, money, connection);
            bankDAO.sub(from, money, connection);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: 看看这里为什么不回滚也没问题
            // ? 这里为什么不回滚也没问题
            // 不走到 commit 不就好了吗？
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
