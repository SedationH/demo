package service.impl;

import dao.BookDao;
import service.BookService;

public class BookServiceImpl3 implements BookService {
    public BookServiceImpl3() {
        System.out.println("BookServiceImpl.BookServiceImpl() constructor 2");
    }

    public BookServiceImpl3(BookDao bookDao3, String age) {
        this.bookDao3 = bookDao3;
        this.age = age;
        System.out.println("BookServiceImpl.BookServiceImpl() constructor 3");
    }

    // 删除业务层中使用 new 创建的 dao 对象
    private BookDao bookDao;
    private BookDao bookDao2;
    private BookDao bookDao3;
    private String name;
    private String age;


    public void save() {
        System.out.println(name + bookDao + bookDao2);
        System.out.println(age + bookDao3);
//        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setBookDao2(BookDao bookDao2) {
        this.bookDao2 = bookDao2;
    }

    public void setName(String name) {
        this.name = name;
    }
}
