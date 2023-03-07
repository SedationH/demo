import dao.impl.BookDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.BookServiceImpl;
import service.impl.BookServiceImpl2;

public class App2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl2 bookService = (BookServiceImpl2) ctx.getBean("bookService2");
        bookService.save();
    }
}
