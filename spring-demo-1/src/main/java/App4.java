import dao.impl.BookDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDaoImpl bookDao = (BookDaoImpl) ctx.getBean("bookDao3");
        bookDao.save();
    }
}
