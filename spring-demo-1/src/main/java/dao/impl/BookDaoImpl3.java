package dao.impl;

import dao.BookDao;

public class BookDaoImpl3 implements BookDao {
    public BookDaoImpl3() {
        System.out.println("BookDaoImpl.BookDaoImpl() constructor");
    }

    public void save() {
        System.out.println("BookDaoImpl.save()");
    }

    public void init() {
        System.out.println("BookDaoImpl.init()");
    }

    public void destroy() {
        System.out.println("BookDaoImpl.destroy()");
    }
}
