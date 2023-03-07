import dao.impl.BookDaoImpl;
import service.impl.BookServiceImpl;

public class App {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.save();
    }
}
