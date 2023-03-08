package factory;

import dao.BookDao;
import dao.impl.BookDaoImpl;

// 实例工厂方法：实例工厂的方法，即先创建工厂本身，再调用工厂的实例方法来返回bean的实例。
public class BookDaoFactory2 {
    public BookDao getBookDao() {
        System.out.println("BookDaoFactory2.getBookDao()");
        return new BookDaoImpl();
    }
}
