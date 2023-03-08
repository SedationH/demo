package factory;

import dao.BookDao;
import dao.impl.BookDaoImpl;

public class BookDaoFactory {
    public static BookDao getBookDao() {
        System.out.println("BookDaoFactory.getBookDao()");
        return new BookDaoImpl();
    }
}
