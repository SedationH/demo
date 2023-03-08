package dao.impl;

import dao.BookDao;

public class BookDaoImpl2 implements BookDao {
    public BookDaoImpl2() {
        System.out.println("BookDaoImpl.BookDaoImpl() constructor 2");
    }

    @Override
    public void save() {
        System.out.println("BookDaoImpl.save() 2");
    }
}
