package dao.impl;

import dao.BookDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookDaoImpl4 implements BookDao, InitializingBean, DisposableBean {
    public BookDaoImpl4() {
        System.out.println("BookDaoImpl.BookDaoImpl() constructor");
    }

    public void save() {
        System.out.println("BookDaoImpl.save()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BookDaoImpl.destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BookDaoImpl.init()");
    }
}
