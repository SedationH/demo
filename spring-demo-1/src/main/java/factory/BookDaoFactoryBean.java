package factory;

import dao.impl.BookDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class BookDaoFactoryBean implements FactoryBean<BookDaoImpl> {

    @Override
    public BookDaoImpl getObject() throws Exception {
        return new BookDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return BookDaoImpl.class;
    }
}
