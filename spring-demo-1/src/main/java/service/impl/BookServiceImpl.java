package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

public class BookServiceImpl implements BookService {
    public BookServiceImpl() {
        System.out.println("BookServiceImpl.BookServiceImpl() constructor");
    }

    private BookDao bookDao = new BookDaoImpl();

    public void save() {
        System.out.println("BookServiceImpl.save()");
        bookDao.save();
    }
}
