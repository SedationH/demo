package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import dao.impl.BookDaoImpl2;
import service.BookService;

public class BookServiceImpl2 implements BookService {
    public BookServiceImpl2() {
        System.out.println("BookServiceImpl.BookServiceImpl() constructor 2");
    }
    // 删除业务层中使用 new 创建的 dao 对象
    private BookDao bookDao;

    public void save() {
        System.out.println("BookServiceImpl.save()");
        bookDao.save();
    }

    public void setBookDao(BookDaoImpl2 bookDao) {
        this.bookDao = bookDao;
    }

}
