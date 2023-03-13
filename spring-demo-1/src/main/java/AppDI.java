import dao.impl.BookDaoImpl4;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.BookServiceImpl3;

public class AppDI {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.registerShutdownHook();
        BookServiceImpl3 bookService = (BookServiceImpl3) ctx.getBean("bookService2");
        bookService.save();
    }
}
