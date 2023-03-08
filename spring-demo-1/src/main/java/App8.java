import dao.impl.BookDaoImpl3;
import dao.impl.BookDaoImpl4;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App8 {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.registerShutdownHook();
        BookDaoImpl4 bookDao = (BookDaoImpl4) ctx.getBean("bookDao7");
        bookDao.save();
//        ctx.close();
    }
}
