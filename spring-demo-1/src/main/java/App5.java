import dao.impl.BookDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDaoImpl bookDao = (BookDaoImpl) ctx.getBean("bookDao4");
        bookDao.save();
    }
}
