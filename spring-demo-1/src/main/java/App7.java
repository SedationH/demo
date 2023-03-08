import dao.impl.BookDaoImpl;
import dao.impl.BookDaoImpl3;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App7 {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.registerShutdownHook();
        BookDaoImpl3 bookDao = (BookDaoImpl3) ctx.getBean("bookDao6");
        bookDao.save();
//        ctx.close();
    }
}
