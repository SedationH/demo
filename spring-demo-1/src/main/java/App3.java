import dao.impl.BookDaoImpl;
import dao.impl.BookDaoImpl2;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.BookServiceImpl2;

public class App3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDaoImpl2 bookDao = (BookDaoImpl2) ctx.getBean("bookDao2");
        bookDao.save();
    }
}
