package dao.impl;

import dao.BookDao;

public class BookDaoImpl implements BookDao {
    public BookDaoImpl() {
        System.out.println("BookDaoImpl.BookDaoImpl() constructor");
    }
    public void save() {
        System.out.println("BookDaoImpl.save()");
    }
}
